package com.refanzzzz.pokeverse.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.refanzzzz.pokeverse.R;
import com.refanzzzz.pokeverse.model.PokemonAttribute;
import com.refanzzzz.pokeverse.model.PokemonItem;
import com.refanzzzz.pokeverse.model.PokemonType;
import com.refanzzzz.pokeverse.retrofit.ApiService;
import com.refanzzzz.pokeverse.util.Util;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonAdapterRecyclerView extends RecyclerView.Adapter<PokemonAdapterRecyclerView.ViewHolder> {

    private List<PokemonItem> pokemonItemList;
    private final Context context;

    public PokemonAdapterRecyclerView(Context context, List<PokemonItem> pokemonItemList) {
        this.pokemonItemList = pokemonItemList;
        this.context = context;
    }

    public void setFilteredPokemonItemList(List<PokemonItem> filteredPokemonItemList) {
        this.pokemonItemList = filteredPokemonItemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonAdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAdapterRecyclerView.ViewHolder holder, int position) {
        getDataPokemon(holder, position);
    }

    @Override
    public int getItemCount() {
        return pokemonItemList.size();
    }

    private void getDataPokemon(PokemonAdapterRecyclerView.ViewHolder holder, int position) {
        ApiService.getService().getAttribute(pokemonItemList.get(position).getName()).enqueue(new Callback<PokemonAttribute>() {
            @Override
            public void onResponse(Call<PokemonAttribute> call, Response<PokemonAttribute> response) {
                if (response.body() != null) {
                    int pokemonId = response.body().getId();
                    String pokemonName = response.body().getName();
                    double pokemonWeight = response.body().getWeight() / (double) 10;
                    String pokemonUrlIcon = response.body().getPokemonSpriteList().getFrontDefault();
                    int totalType = response.body().getPokemonTypeList().size();
                    List<PokemonType.Type> pokemonType = new ArrayList<>();
                    String type1 = "";
                    String type2 = "";

                    for (int i = 0; i < totalType; i++) {
                        pokemonType.add(response.body().getPokemonTypeList().get(i).getType());
                    }

                    if (totalType == 1) {
                        type1 = pokemonType.get(0).getName();
                    } else {
                        type1 = pokemonType.get(0).getName();
                        type2 = pokemonType.get(1).getName();
                    }

                    switch (type1) {
                        case "normal":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_normal).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "fighting":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_fighting).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "flying":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_flying).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "poison":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_poison).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "ground":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_ground).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "rock":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_rock).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "bug":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_bug).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "ghost":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_ghost).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "steel":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_steel).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "fire":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_fire).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "water":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_water).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "grass":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_grass).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "electric":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_electric).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "psychic":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_psychic).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "ice":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_ice).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "dragon":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_dragon).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "dark":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_dark).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        case "fairy":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_fairy).into(holder.ivPokemonType1);
                            Glide.with(context).load("").into(holder.ivPokemonType2);
                            break;
                        default:
                            break;
                    }

                    switch (type2) {
                        case "normal":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_normal).into(holder.ivPokemonType2);
                            break;
                        case "fighting":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_fighting).into(holder.ivPokemonType2);
                            break;
                        case "flying":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_flying).into(holder.ivPokemonType2);
                            break;
                        case "poison":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_poison).into(holder.ivPokemonType2);
                            break;
                        case "ground":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_ground).into(holder.ivPokemonType2);
                            break;
                        case "rock":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_rock).into(holder.ivPokemonType2);
                            break;
                        case "bug":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_bug).into(holder.ivPokemonType2);
                            break;
                        case "ghost":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_ghost).into(holder.ivPokemonType2);
                            break;
                        case "steel":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_steel).into(holder.ivPokemonType2);
                            break;
                        case "fire":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_fire).into(holder.ivPokemonType2);
                            break;
                        case "water":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_water).into(holder.ivPokemonType2);
                            break;
                        case "grass":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_grass).into(holder.ivPokemonType2);
                            break;
                        case "electric":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_electric).into(holder.ivPokemonType2);
                            break;
                        case "psychic":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_psychic).into(holder.ivPokemonType2);
                            break;
                        case "ice":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_ice).into(holder.ivPokemonType2);
                            break;
                        case "dragon":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_dragon).into(holder.ivPokemonType2);
                            break;
                        case "dark":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_dark).into(holder.ivPokemonType2);
                            break;
                        case "fairy":
                            Glide.with(context).load(R.drawable.ic_pokemon_type_fairy).into(holder.ivPokemonType2);
                            break;
                    }

                    holder.txtPokemonId.setText("#" + String.valueOf(pokemonId));
                    holder.txtPokemonName.setText(Util.capitalize(pokemonName));
                    holder.txtPokemonWeight.setText(String.valueOf(pokemonWeight) + "kg");
                    Glide.with(context).load(pokemonUrlIcon).into(holder.ivPokemonIcon);
                }
            }

            @Override
            public void onFailure(Call<PokemonAttribute> call, Throwable t) {

            }
        });
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtPokemonName, txtPokemonWeight, txtPokemonId;
        CircleImageView ivPokemonIcon;
        AppCompatImageView ivPokemonType1, ivPokemonType2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtPokemonId = itemView.findViewById(R.id.tv_pokemon_id);
            txtPokemonName = itemView.findViewById(R.id.txt_pokemon_name);
            txtPokemonWeight = itemView.findViewById(R.id.txt_pokemon_weight);
            ivPokemonIcon = itemView.findViewById(R.id.iv_pokemon_icon);
            ivPokemonType1 = itemView.findViewById(R.id.iv_pokemon_type_1);
            ivPokemonType2 = itemView.findViewById(R.id.iv_pokemon_type_2);
        }
    }

}
