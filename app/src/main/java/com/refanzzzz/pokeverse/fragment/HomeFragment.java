package com.refanzzzz.pokeverse.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.refanzzzz.pokeverse.AbilityActivity;
import com.refanzzzz.pokeverse.ElementActivity;
import com.refanzzzz.pokeverse.ItemActivity;
import com.refanzzzz.pokeverse.PokemonActivity;
import com.refanzzzz.pokeverse.R;

public class HomeFragment extends Fragment {

    private View view;
    private AppCompatImageView ivPokedex, ivItem, ivAbility, ivElement, ivMove;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_home, container, false);

        hideActionBar();

        init();

        setEventClick();

        return view;
    }

    void init() {
        ivPokedex = view.findViewById(R.id.iv_pokedex);
        ivItem = view.findViewById(R.id.iv_item);
        ivAbility = view.findViewById(R.id.iv_ability);
        ivElement = view.findViewById(R.id.iv_element);
    }

    void hideActionBar() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    void setEventClick() {
        ivPokedex.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), PokemonActivity.class);
            startActivity(intent);
        });

        ivElement.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ElementActivity.class);
            startActivity(intent);
        });

        ivAbility.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), AbilityActivity.class);
            startActivity(intent);
        });

        ivItem.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ItemActivity.class);
            startActivity(intent);
        });
    }
}