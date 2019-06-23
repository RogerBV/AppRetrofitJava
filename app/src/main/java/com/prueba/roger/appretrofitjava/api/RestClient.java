package com.prueba.roger.appretrofitjava.api;

import com.prueba.roger.appretrofitjava.PokemonFeed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestClient {
    @GET("pokemon")
    Call<PokemonFeed> getData();
}
