package com.refanzzzz.pokeverse.recycler;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.refanzzzz.pokeverse.R;
import com.refanzzzz.pokeverse.model.PokemonAbility;
import com.refanzzzz.pokeverse.retrofit.ApiService;
import com.refanzzzz.pokeverse.util.Util;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonAbilityAdapterRecyclerView extends RecyclerView.Adapter<PokemonAbilityAdapterRecyclerView.ViewHolder> {

    private final Context context;
    private List<PokemonAbility.Ability> pokemonAbilityDetailList;

    public PokemonAbilityAdapterRecyclerView(Context context, List<PokemonAbility.Ability> pokemonAbilityDetailList) {
        this.pokemonAbilityDetailList = pokemonAbilityDetailList;
        this.context = context;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setFilteredAbilityList(List<PokemonAbility.Ability> filteredPokemonAbilityList) {
        this.pokemonAbilityDetailList = filteredPokemonAbilityList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonAbilityAdapterRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.ability_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonAbilityAdapterRecyclerView.ViewHolder holder, int position) {
        ApiService.getService().getAbility(pokemonAbilityDetailList.get(position).getName()).enqueue(new Callback<PokemonAbility.AbilityDetail>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<PokemonAbility.AbilityDetail> call, @NonNull Response<PokemonAbility.AbilityDetail> response) {
                if (response.body() != null) {
                    String name = response.body().getName();
                    int id = response.body().getId();

                    holder.tvAbilityId.setText("#" + id);
                    holder.tvAbilityName.setText(Util.capitalize(name));
                }
            }

            @Override
            public void onFailure(@NonNull Call<PokemonAbility.AbilityDetail> call, @NonNull Throwable t) {
                System.out.println(t.getMessage());
            }
        });


    }

    @Override
    public int getItemCount() {
        return (pokemonAbilityDetailList != null) ? pokemonAbilityDetailList.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final AppCompatTextView tvAbilityId;
        private final AppCompatTextView tvAbilityName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvAbilityId = itemView.findViewById(R.id.tv_ability_id);
            tvAbilityName = itemView.findViewById(R.id.tv_ability_name);
        }
    }

}
