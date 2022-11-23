package com.refanzzzz.pokeverse.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class PokemonAttribute {

    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("height")
    private int height;
    @SerializedName("weight")
    private int weight;
    @SerializedName("sprites")
    private PokemonSprite pokemonSpriteList;
    @SerializedName("types")
    private List<PokemonType> pokemonTypeList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public PokemonSprite getPokemonSpriteList() {
        return pokemonSpriteList;
    }

    public void setPokemonSpriteList(PokemonSprite pokemonSpriteList) {
        this.pokemonSpriteList = pokemonSpriteList;
    }

    public List<PokemonType> getPokemonTypeList() {
        return pokemonTypeList;
    }

    public void setPokemonTypeList(List<PokemonType> pokemonTypeList) {
        this.pokemonTypeList = pokemonTypeList;
    }

    @Override
    public String toString() {
        return "PokemonAttribute{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", pokemonSpriteList=" + pokemonSpriteList +
                ", pokemonTypeList=" + pokemonTypeList +
                '}';
    }
}
