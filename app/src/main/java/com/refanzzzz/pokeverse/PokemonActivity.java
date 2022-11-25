package com.refanzzzz.pokeverse;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.refanzzzz.pokeverse.model.PokemonData;
import com.refanzzzz.pokeverse.recycler.PokemonAdapterRecyclerView;
import com.refanzzzz.pokeverse.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private Context context;
    private RecyclerView recyclerView;
    private List<PokemonData.Data> pokemonItemList;
    private SearchView svPokemon;
    private PokemonAdapterRecyclerView recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);

        init();

        initBackButton();

        getPokemonItem();

        setPokemonSearch();
    }

    void initRecyclerView(List<PokemonData.Data> pokemonItemList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new PokemonAdapterRecyclerView(context, pokemonItemList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    void getPokemonItem() {
        ApiService.getService().getList().enqueue(new Callback<PokemonData>() {
            @Override
            public void onResponse(Call<PokemonData> call, Response<PokemonData> response) {
                if (response.body() != null) {
                    try {
                        pokemonItemList = response.body().getResults();
                        Log.d(TAG, pokemonItemList.toString());
                        initRecyclerView(pokemonItemList);
                    } catch (Exception e) {
                        Log.d(TAG, e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<PokemonData> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    void setPokemonSearch() {
        svPokemon.clearFocus();
        svPokemon.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterPokemonList(newText);
                return true;
            }
        });
    }

    void filterPokemonList(String text) {
        List<PokemonData.Data> filteredPokemonItem = new ArrayList<>();
        for (PokemonData.Data item : pokemonItemList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredPokemonItem.add(item);
            }
        }

        if (filteredPokemonItem.isEmpty()) {
            Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            recyclerViewAdapter.setFilteredPokemonItemList(filteredPokemonItem);
        }
    }

    void initBackButton() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void init() {
        context = getApplicationContext();
        recyclerView = findViewById(R.id.rv_pokemon);
        svPokemon = findViewById(R.id.sv_pokemon_search);
    }
}