package com.refanzzzz.pokeverse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.refanzzzz.pokeverse.model.PokemonAbility;
import com.refanzzzz.pokeverse.recycler.PokemonAbilityAdapterRecyclerView;
import com.refanzzzz.pokeverse.retrofit.ApiService;
import com.refanzzzz.pokeverse.shared_preferences.SharedPrefConfig;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AbilityActivity extends AppCompatActivity {

    private SearchView svAbilitySearch;
    private Context context;
    private RecyclerView recyclerView;
    private final String TAG = "AbilityActivity";
    private List<PokemonAbility.AbilityDetail> pokemonAbilityDetailList;
    private List<PokemonAbility.Ability> pokemonAbilityList;
    private PokemonAbilityAdapterRecyclerView pokemonAbilityAdapterRecyclerView;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ability);

        init();

        setActionBarTitle();

        initBackButton();

        getPokemonAbility();

        setAbilitySearch();
    }

    void initRecyclerView(List<PokemonAbility.Ability> pokemonAbilityList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        pokemonAbilityAdapterRecyclerView = new PokemonAbilityAdapterRecyclerView(context, pokemonAbilityList);
        recyclerView.setAdapter(pokemonAbilityAdapterRecyclerView);
    }

    void setAbilitySearch() {
        svAbilitySearch.clearFocus();
        svAbilitySearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterAbilityList(newText);
                return true;
            }
        });
    }

    private void filterAbilityList(String newText) {
        List<PokemonAbility.Ability> filteredPokemonAbilityList = new ArrayList<>();

        for (PokemonAbility.Ability item : pokemonAbilityList) {
            if (item.getName().toLowerCase().contains(newText.toLowerCase())) {
                filteredPokemonAbilityList.add(item);
            }
        }

        if(filteredPokemonAbilityList.isEmpty()) {
            Toast.makeText(context, "No data found", Toast.LENGTH_SHORT).show();
        } else {
            pokemonAbilityAdapterRecyclerView.setFilteredAbilityList(filteredPokemonAbilityList);
        }
    }

    private void getPokemonAbility() {
        ApiService.getService().getAbility().enqueue(new Callback<PokemonAbility>() {
            @Override
            public void onResponse(Call<PokemonAbility> call, Response<PokemonAbility> response) {
                if(response.body() != null) {
                    try {
                        pokemonAbilityList = response.body().getAbilityList();
                        Log.d(TAG, pokemonAbilityList.toString());
                        initRecyclerView(pokemonAbilityList);
                    } catch (Exception e) {
                       Log.d(TAG, e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<PokemonAbility> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    private void initBackButton() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setActionBarTitle() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Pokemon Ability");
    }

    private void init() {
        context = getApplicationContext();
        svAbilitySearch = findViewById(R.id.sv_ability_search);
        recyclerView = findViewById(R.id.rv_ability);
    }
}