package com.prueba.roger.appretrofitjava;

import com.prueba.roger.appretrofitjava.data.api.RestClient;
import com.prueba.roger.appretrofitjava.data.api.RetrofitUtils;
import com.prueba.roger.appretrofitjava.data.model.AbilityFeed;

import retrofit2.Call;

public class PokemonDetailPresenter {
    private PokemonDetailView view;
    private PokemonDetailPresenter(PokemonDetailView pokemonDetailView)
    {
        this.view = pokemonDetailView;
    }
    public void getDataAbility(){
        RestClient restClient = RetrofitUtils.getInstance().create(RestClient.class);
        Call<AbilityFeed> call = restClient.getDataAbility(id);
    }
}
