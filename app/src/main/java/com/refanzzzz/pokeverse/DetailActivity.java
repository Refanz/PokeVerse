package com.refanzzzz.pokeverse;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.beardedhen.androidbootstrap.BootstrapProgressBar;
import com.bumptech.glide.Glide;
import com.refanzzzz.pokeverse.model.PokemonDetail;
import com.refanzzzz.pokeverse.model.PokemonType;
import com.refanzzzz.pokeverse.retrofit.ApiService;
import com.refanzzzz.pokeverse.util.Util;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    private final static String TAG = "DetailActivity";
    private Context context;
    private AppCompatImageView ivdAvatar, ivdType1, ivdType2;
    private AppCompatTextView tvdName, tvdHeight, tvdWeight, tvdAbilities, tvdStatHP, tvdStatAttack,
            tvdStatDefense, tvdStatSpAttack, tvdStatSpDefense, tvdStatSpeed;
    private BootstrapProgressBar pbStatHP, pbStatDefense, pbStatAttack,
            pbStatSpAttack, pbStatSpDefense, pbStatSpeed;
    private String pokemonNameIntent = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        init();

        setActionBarTitle();

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
                        String name = response.body().getName();
                        double height = response.body().getHeight() / (double) 10;
                        double weight = response.body().getWeight() / (double) 10;
                        int totalType = response.body().getPokemonTypeList().size();
                        List<PokemonType.Type> pokemonType = new ArrayList<>();
                        String type1 = "";
                        String type2 = "";
                        String avatar = response.body().getPokemonSpriteList().getFrontDefault();

                        for (int i = 0; i < totalType; i++) {
                            pokemonType.add(response.body().getPokemonTypeList().get(i).getType());
                            System.out.println(pokemonType.toString());
                        }

                        if (totalType == 1) {
                            type1 = pokemonType.get(0).getName();
                            ivdType2.setVisibility(View.GONE);
                            System.out.println(type1);
                        } else {
                            type1 = pokemonType.get(0).getName();
                            type2 = pokemonType.get(1).getName();
                        }

                        switch (type1) {
                            case "normal":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_normal);
                                break;
                            case "fighting":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_fighting);
                                break;
                            case "flying":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_flying);
                                break;
                            case "poison":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_poison);
                                break;
                            case "ground":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_ground);
                                break;
                            case "rock":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_rock);
                                break;
                            case "bug":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_bug);
                                break;
                            case "ghost":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_ghost);
                                break;
                            case "steel":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_steel);
                                break;
                            case "fire":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_fire);
                                break;
                            case "water":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_water);
                                break;
                            case "grass":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_grass);
                                break;
                            case "electric":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_electric);
                                break;
                            case "psychic":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_psychic);
                                break;
                            case "ice":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_ice);
                                break;
                            case "dragon":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_dragon);
                                ;
                                break;
                            case "dark":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_dark);
                                break;
                            case "fairy":
                                setElementIcon(ivdType1, R.drawable.ic_pokemon_type_fairy);
                                break;
                            default:
                                setElementIcon(ivdType1, R.drawable.ic_unspecified);
                                break;
                        }

                        switch (type2) {
                            case "normal":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_normal);
                                break;
                            case "fighting":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_fighting);
                                break;
                            case "flying":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_flying);
                                break;
                            case "poison":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_poison);
                                break;
                            case "ground":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_ground);
                                break;
                            case "rock":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_rock);
                                break;
                            case "bug":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_bug);
                                break;
                            case "ghost":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_ghost);
                                break;
                            case "steel":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_steel);
                                break;
                            case "fire":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_fire);
                                break;
                            case "water":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_water);
                                break;
                            case "grass":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_grass);
                                break;
                            case "electric":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_electric);
                                break;
                            case "psychic":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_psychic);
                                break;
                            case "ice":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_ice);
                                break;
                            case "dragon":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_dragon);
                                break;
                            case "dark":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_dark);
                                break;
                            case "fairy":
                                setElementIcon(ivdType2, R.drawable.ic_pokemon_type_fairy);
                                break;
                            default:
                                setElementIcon(ivdType2, R.drawable.ic_unspecified);
                                break;
                        }

                        tvdName.setText(Util.capitalize(name));
                        tvdHeight.setText(String.valueOf(height) + " m");
                        tvdWeight.setText(String.valueOf(weight) + " kg");
                        Glide.with(context).load(avatar).into(ivdAvatar);
                    } catch (Exception e) {
                        Log.d(TAG, e.getMessage().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<PokemonDetail> call, Throwable t) {

            }
        });
    }

    private void setElementIcon(AppCompatImageView view, int icon) {
        Glide.with(context).load(icon).into(view);
    }

    private void initBackButton() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void setActionBarTitle() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Pokemon Detail");
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