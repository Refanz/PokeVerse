package com.refanzzzz.pokeverse.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.refanzzzz.pokeverse.R;
import com.refanzzzz.pokeverse.model.PokemonAttribute;
import com.refanzzzz.pokeverse.util.Util;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PokemonNameAdapterRecyclerView extends RecyclerView.Adapter<PokemonNameAdapterRecyclerView.ViewHolder> {

    private final List<PokemonAttribute> pokemonAttributeList;
    private final Context context;

    public PokemonNameAdapterRecyclerView(Context context, List<PokemonAttribute> pokemonAttributeList) {
        this.context = context;
        this.pokemonAttributeList = pokemonAttributeList;
    }

    @NonNull
    @Override
    public PokemonNameAdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonNameAdapterRecyclerView.ViewHolder holder, int position) {
        int pokemonId = pokemonAttributeList.get(position).getId();
        String pokemonName = pokemonAttributeList.get(position).getName();
        double pokemonWeight = pokemonAttributeList.get(position).getWeight() / (double) 10;
        String pokemonUrlIcon = pokemonAttributeList.get(position).getPokemonSpriteList().getFrontDefault();

        holder.txtPokemonId.setText("#"+String.valueOf(pokemonId));
        holder.txtPokemonName.setText(Util.capitalize(pokemonName));
        holder.txtPokemonWeight.setText(String.valueOf(pokemonWeight) + "kg");
        Glide.with(context).load(pokemonUrlIcon).into(holder.ivPokemonIcon);
    }

    @Override
    public int getItemCount() {
        return pokemonAttributeList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtPokemonName, txtPokemonWeight, txtPokemonId;
        CircleImageView ivPokemonIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtPokemonId = itemView.findViewById(R.id.tv_pokemon_id);
            txtPokemonName = itemView.findViewById(R.id.txt_pokemon_name);
            txtPokemonWeight = itemView.findViewById(R.id.txt_pokemon_weight);
            ivPokemonIcon = itemView.findViewById(R.id.iv_pokemon_icon);
        }
    }
}
