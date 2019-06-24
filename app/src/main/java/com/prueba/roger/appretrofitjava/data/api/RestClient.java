package com.prueba.roger.appretrofitjava.data.api;

import com.prueba.roger.appretrofitjava.data.model.PokemonFeed;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RestClient {
    @GET("pokemon")
    Call<PokemonFeed> getData();
}
