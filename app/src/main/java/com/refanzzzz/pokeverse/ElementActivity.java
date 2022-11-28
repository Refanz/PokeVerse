package com.refanzzzz.pokeverse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.widget.SearchView;

import android.view.MenuItem;
import android.widget.Toast;

import com.refanzzzz.pokeverse.model.PokemonElement;
import com.refanzzzz.pokeverse.recycler.PokemonElementAdapterRecyclerView;
import com.refanzzzz.pokeverse.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ElementActivity extends AppCompatActivity {

    private Context context;
    private RecyclerView recyclerView;
    private List<PokemonElement.Element> pokemonElementList;
    private PokemonElementAdapterRecyclerView pokemonElementAdapterRecyclerView;
    private final String TAG = "ElementActivity";
    private SearchView svElement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);

        init();

        initBackButton();

        getPokemonElement();

        setElementSearch();
    }

    void initRecyclerView(List<PokemonElement.Element> pokemonElementList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        pokemonElementAdapterRecyclerView = new PokemonElementAdapterRecyclerView(context, pokemonElementList);
        recyclerView.setAdapter(pokemonElementAdapterRecyclerView);
    }

    void getPokemonElement() {
        ApiService.getService().getElement().enqueue(new Callback<PokemonElement>() {
            @Override
            public void onResponse(Call<PokemonElement> call, Response<PokemonElement> response) {
                if(response.body() != null){
                    try {
                        pokemonElementList = response.body().getResults();
                        Log.d(TAG, pokemonElementList.toString());
                        initRecyclerView(pokemonElementList);
                    } catch (Exception e) {
                        Log.d(TAG, e.getMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<PokemonElement> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    void setElementSearch() {
        svElement.clearFocus();
        svElement.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterElementList(newText);
                return true;
            }
        });
    }

    void filterElementList(String text) {
        List<PokemonElement.Element> filteredElementList = new ArrayList<>();

        for(PokemonElement.Element element : pokemonElementList) {
            if(element.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredElementList.add(element);
            }
        }

        if(filteredElementList.isEmpty()) {
            Toast.makeText(context, "No Data Found", Toast.LENGTH_SHORT).show();
        } else {
            pokemonElementAdapterRecyclerView.setFilteredPokemonElementList(filteredElementList);
        }
    }

    void initBackButton() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void init() {
        recyclerView = findViewById(R.id.rv_element);
        context = getApplicationContext();
        svElement = findViewById(R.id.sv_element_search);
    }
}