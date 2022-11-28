package com.refanzzzz.pokeverse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

import com.refanzzzz.pokeverse.model.PokemonItem;
import com.refanzzzz.pokeverse.recycler.PokemonItemAdapterRecyclerView;
import com.refanzzzz.pokeverse.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemActivity extends AppCompatActivity {

    private SearchView searchItem;
    private RecyclerView recyclerView;
    private static final String TAG = "ItemActivity";
    private PokemonItemAdapterRecyclerView pokemonItemAdapterRecyclerView;
    private Context context;
    private List<PokemonItem.Item> pokemonItemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        init();

        initBackButton();

        getPokemonItem();

        setItemSearch();
    }

    private void initRecyclerView(List<PokemonItem.Item> pokemonItemList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        pokemonItemAdapterRecyclerView = new PokemonItemAdapterRecyclerView(context, pokemonItemList);
        recyclerView.setAdapter(pokemonItemAdapterRecyclerView);
    }

    private void getPokemonItem() {
        ApiService.getService().getItem().enqueue(new Callback<PokemonItem>() {
            @Override
            public void onResponse(Call<PokemonItem> call, Response<PokemonItem> response) {
                if (response.body() != null) {
                    try {
                        pokemonItemList = response.body().getPokeItemList();
                        Log.d(TAG, pokemonItemList.toString());
                        initRecyclerView(pokemonItemList);
                    } catch (Exception e) {
                        Log.d(TAG, e.getMessage().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<PokemonItem> call, Throwable t) {

            }
        });
    }

    private void setItemSearch() {
        searchItem.clearFocus();
        searchItem.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterItemList(s);
                return true;
            }
        });
    }

    private void filterItemList(String text) {
        List<PokemonItem.Item> filteredPokemonItemList = new ArrayList<>();

        for (PokemonItem.Item item : pokemonItemList) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())){
                filteredPokemonItemList.add(item);
            }
        }

        if (filteredPokemonItemList.isEmpty()) {
            Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            pokemonItemAdapterRecyclerView.setFilteredPokemonItemList(filteredPokemonItemList);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initBackButton() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void init() {
        context = getApplicationContext();
        searchItem = findViewById(R.id.sv_item_search);
        recyclerView = findViewById(R.id.rv_item);
    }
}