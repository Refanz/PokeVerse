package com.refanzzzz.pokeverse.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.refanzzzz.pokeverse.R;
import com.refanzzzz.pokeverse.model.PokemonElement;
import com.refanzzzz.pokeverse.util.Util;

import java.util.List;

public class PokemonElementAdapterRecyclerView extends RecyclerView.Adapter<PokemonElementAdapterRecyclerView.ViewHolder> {

    private List<PokemonElement.Element> pokemonELementList;
    private final Context context;

    public PokemonElementAdapterRecyclerView(Context context, List<PokemonElement.Element> pokemonELementList) {
        this.context = context;
        this.pokemonELementList = pokemonELementList;
    }

    public void setFilteredPokemonElementList(List<PokemonElement.Element> filteredPokemonELementList) {
        this.pokemonELementList = filteredPokemonELementList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonElementAdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.element_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonElementAdapterRecyclerView.ViewHolder holder, int position) {
        String pokemonType = pokemonELementList.get(position).getName();

        switch (pokemonType) {
            case "normal":
                setElementIcon(holder, R.drawable.ic_pokemon_type_normal);
                break;
            case "fighting":
                setElementIcon(holder, R.drawable.ic_pokemon_type_fighting);
                break;
            case "flying":
                setElementIcon(holder, R.drawable.ic_pokemon_type_flying);
                break;
            case "poison":
                setElementIcon(holder, R.drawable.ic_pokemon_type_poison);
                break;
            case "ground":
                setElementIcon(holder, R.drawable.ic_pokemon_type_ground);
                break;
            case "rock":
                setElementIcon(holder, R.drawable.ic_pokemon_type_rock);
                break;
            case "bug":
                setElementIcon(holder, R.drawable.ic_pokemon_type_bug);
                break;
            case "ghost":
                setElementIcon(holder, R.drawable.ic_pokemon_type_ghost);
                break;
            case "steel":
                setElementIcon(holder, R.drawable.ic_pokemon_type_steel);
                break;
            case "fire":
                setElementIcon(holder, R.drawable.ic_pokemon_type_fire);
                break;
            case "water":
                setElementIcon(holder, R.drawable.ic_pokemon_type_water);
                break;
            case "grass":
                setElementIcon(holder, R.drawable.ic_pokemon_type_grass);
                break;
            case "electric":
                setElementIcon(holder, R.drawable.ic_pokemon_type_electric);
                break;
            case "psychic":
                setElementIcon(holder, R.drawable.ic_pokemon_type_psychic);
                break;
            case "ice":
                setElementIcon(holder, R.drawable.ic_pokemon_type_ice);
                break;
            case "dragon":
                setElementIcon(holder, R.drawable.ic_pokemon_type_dragon);
                break;
            case "dark":
                setElementIcon(holder, R.drawable.ic_pokemon_type_dark);
                break;
            case "fairy":
                setElementIcon(holder, R.drawable.ic_pokemon_type_fairy);
                break;
            default:
                setElementIcon(holder, R.drawable.ic_unspecified);
                break;
        }

        holder.tvPokemonType.setText(Util.capitalize(pokemonType));
    }

    @Override
    public int getItemCount() {
        if(pokemonELementList != null) return pokemonELementList.size();

        return 0;
    }

    void setElementIcon(PokemonElementAdapterRecyclerView.ViewHolder holder, int icon){
        Glide.with(context).load(icon).into(holder.ivPokemonType);
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        AppCompatTextView tvPokemonType;
        AppCompatImageView ivPokemonType;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvPokemonType = itemView.findViewById(R.id.tv_pokemon_type);
            ivPokemonType = itemView.findViewById(R.id.iv_pokemon_element);
        }
    }
}
