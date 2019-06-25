package com.prueba.roger.appretrofitjava.data.api;

import com.prueba.roger.appretrofitjava.data.model.Ability;
import com.prueba.roger.appretrofitjava.data.model.AbilityFeed;
import com.prueba.roger.appretrofitjava.data.model.PokemonFeed;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestClient {
    @GET("pokemon")
    Call<PokemonFeed> getData();

    @GET("pokemon/{id}")
    Call<AbilityFeed> getDataAbility(@Path("id") int id);
}
