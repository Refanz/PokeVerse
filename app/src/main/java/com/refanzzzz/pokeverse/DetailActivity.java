package com.refanzzzz.pokeverse;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.beardedhen.androidbootstrap.BootstrapProgressBar;
import com.refanzzzz.pokeverse.model.PokemonDetail;
import com.refanzzzz.pokeverse.retrofit.ApiService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private AppCompatImageView ivdAvatar, ivdType1, ivdType2;
    private AppCompatTextView tvdName, tvdHeight, tvdWeight, tvdAbilities, tvdStatHP, tvdStatAttack,
            tvdStatDefense, tvdStatSpAttack, tvdStatSpDefense, tvdStatSpeed;
    private BootstrapProgressBar pbStatHP, pbStatDefense, pbStatAttack,
            pbStatSpAttack, pbStatSpDefense, pbStatSpeed;

    private String pokemonNameIntent = "";
    private final static String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        init();

        initBackButton();

        getIntentPokemonName();

        getPokemonDetail(pokemonNameIntent);
    }

    void getIntentPokemonName() {
        pokemonNameIntent = getIntent().getStringExtra("POKEMON_NAME_ID");
    }

    void getPokemonDetail(String pokemonName) {
        ApiService.getService().getAttribute(pokemonName).enqueue(new Callback<PokemonDetail>() {
            @Override
            public void onResponse(Call<PokemonDetail> call, Response<PokemonDetail> response) {
                if (response.body() != null) {
                    try {
                        tvdName.setText(response.body().getName());
                    } catch (Exception e) {

                    }
                }
            }

            @Override
            public void onFailure(Call<PokemonDetail> call, Throwable t) {

            }
        });
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
        tvdName = findViewById(R.id.tvd_name);
        ivdAvatar = findViewById(R.id.ivd_avatar);
        ivdType1 = findViewById(R.id.ivd_type_1);
        ivdType2 = findViewById(R.id.ivd_type_2);
        tvdHeight = findViewById(R.id.tvd_height);
        tvdWeight = findViewById(R.id.tvd_weight);
        tvdAbilities = findViewById(R.id.tvd_ability);
        tvdStatHP = findViewById(R.id.tvd_stat_hp);
        tvdStatAttack = findViewById(R.id.tvd_stat_attack);
        tvdStatDefense = findViewById(R.id.tvd_stat_defense);
        tvdStatSpAttack = findViewById(R.id.tvd_stat_attack);
        tvdStatSpDefense = findViewById(R.id.tvd_stat_defense);
        tvdStatSpeed = findViewById(R.id.tvd_stat_speed);
        pbStatHP = findViewById(R.id.pb_stat_hp);
        pbStatAttack = findViewById(R.id.pb_stat_attack);
        pbStatDefense = findViewById(R.id.pb_stat_defense);
        pbStatSpAttack = findViewById(R.id.pb_stat_sp_attack);
        pbStatSpDefense = findViewById(R.id.pb_stat_sp_defense);
        pbStatSpeed = findViewById(R.id.pb_stat_speed);
    }

}