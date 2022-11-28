package com.refanzzzz.pokeverse.retrofit;

import com.refanzzzz.pokeverse.model.GithubData;
import com.refanzzzz.pokeverse.model.PokemonAbility;
import com.refanzzzz.pokeverse.model.PokemonDetail;
import com.refanzzzz.pokeverse.model.PokemonData;
import com.refanzzzz.pokeverse.model.PokemonElement;
import com.refanzzzz.pokeverse.model.PokemonItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiEndpoint {

    /* Pokemon */
    @GET("/api/v2/pokemon?limit=2000")
    Call<PokemonData> getList();

    @GET("/api/v2/pokemon/{name}/")
    Call<PokemonDetail> getAttribute(@Path("name") String pokemonName);

    @GET("/api/v2/type/")
    Call<PokemonElement> getElement();

    @GET("/api/v2/ability?limit=350")
    Call<PokemonAbility> getAbility();

    @GET("/api/v2/ability/{name}/")
    Call<PokemonAbility.AbilityDetail> getAbility(@Path("name") String abilityName);

    @GET("/api/v2/item?limit=1700")
    Call<PokemonItem> getItem();

    @GET("/api/v2/item/{name}/")
    Call<PokemonItem.Item> getItem(@Path("name") String itemName);


    /*Github*/
    @GET("/users/refanz")
    Call<GithubData> getGithub();


}
