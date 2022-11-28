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
import com.refanzzzz.pokeverse.model.PokemonItem;
import com.refanzzzz.pokeverse.retrofit.ApiService;
import com.refanzzzz.pokeverse.util.Util;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonItemAdapterRecyclerView extends RecyclerView.Adapter<PokemonItemAdapterRecyclerView.ViewHolder> {

    private List<PokemonItem.Item> pokemonItemList;
    private Context context;
    private RecyclerView recyclerView;

    public PokemonItemAdapterRecyclerView(Context context, List<PokemonItem.Item> pokemonItemList) {
        this.pokemonItemList = pokemonItemList;
        this.context = context;
    }

    public void setFilteredPokemonItemList(List<PokemonItem.Item> filteredPokemonItemList) {
        this.pokemonItemList = filteredPokemonItemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonItemAdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_item, parent, false);
        return new PokemonItemAdapterRecyclerView.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonItemAdapterRecyclerView.ViewHolder holder, int position) {
        ApiService.getService().getItem(pokemonItemList.get(position).getName()).enqueue(new Callback<PokemonItem.Item>() {
            @Override
            public void onResponse(Call<PokemonItem.Item> call, Response<PokemonItem.Item> response) {
                if (response.body() != null) {
                    try {
                        int id = response.body().getId();
                        String name = response.body().getName();
                        int cost = response.body().getCost();
                        String url = response.body().getItemSprite().getUrl();

                        holder.tvIdItem.setText("#"+String.valueOf(id));
                        holder.tvItemName.setText(Util.capitalize(name));
                        holder.tvItemCost.setText(String.valueOf(cost));
                        Glide.with(context).load(url).into(holder.ivItem);

                    } catch (Exception e) {
                        System.out.println(e.getMessage().toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<PokemonItem.Item> call, Throwable t) {
                System.out.println(t.getMessage().toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return (pokemonItemList != null)? pokemonItemList.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private AppCompatTextView tvIdItem, tvItemName, tvItemCost;
        private AppCompatImageView ivItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvIdItem = itemView.findViewById(R.id.tv_id_item);
            tvItemName = itemView.findViewById(R.id.tv_item_name);
            tvItemCost = itemView.findViewById(R.id.tv_item_cost);
            ivItem = itemView.findViewById(R.id.iv_pokemon_item);
        }
    }
}
