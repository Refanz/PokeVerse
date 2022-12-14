package com.refanzzzz.pokeverse.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiService {

    private static ApiEndpoint service;
    private static ApiEndpoint service2;

    public static ApiEndpoint getService() {
        if(service == null) {
            String BASE_URL = "https://pokeapi.co/";
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.client(httpClient.build()).build();
            service = retrofit.create(ApiEndpoint.class);
        }
        return  service;
    }

    public static ApiEndpoint getService2() {
        if(service2 == null) {
            String BASE_URL = "https://api.github.com/";
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());
            Retrofit retrofit = builder.client(httpClient.build()).build();
            service2 = retrofit.create(ApiEndpoint.class);
        }
        return service2;
    }

}
