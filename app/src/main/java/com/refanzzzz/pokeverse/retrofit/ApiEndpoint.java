package com.refanzzzz.pokeverse.retrofit;

import com.refanzzzz.pokeverse.model.PokemonAttribute;
import com.refanzzzz.pokeverse.model.PokemonData;
import com.refanzzzz.pokeverse.model.PokemonElement;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ApiEndpoint {

    @GET("/api/v2/pokemon?limit=2000&offset=0")
    Call<PokemonData> getList();

    @GET("/api/v2/pokemon/{name}/")
    Call<PokemonAttribute> getAttribute(@Path("name") String pokemonName);

    @GET("/api/v2/type")
    Call<PokemonElement> getElement();

}
