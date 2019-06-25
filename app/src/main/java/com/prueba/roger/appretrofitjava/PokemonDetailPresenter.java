package com.prueba.roger.appretrofitjava;

import android.util.Log;

import com.prueba.roger.appretrofitjava.data.api.RestClient;
import com.prueba.roger.appretrofitjava.data.api.RetrofitUtils;
import com.prueba.roger.appretrofitjava.data.model.AbilityFeed;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetailPresenter {
    private PokemonDetailView view;
    private PokemonDetailPresenter(PokemonDetailView pokemonDetailView)
    {
        this.view = pokemonDetailView;
    }
    public void getDataAbility(final int id){
        RestClient restClient = RetrofitUtils.getInstance().create(RestClient.class);
        Call<AbilityFeed> call = restClient.getDataAbility(id);
        call.enqueue(new Callback<AbilityFeed>(){
            @Override
            public void onResponse(Call<AbilityFeed> call, Response<AbilityFeed> response) {
                switch (response.code()){
                    case 200:
                        AbilityFeed ability = response.body();
                        view.notifyDataSetChanged(ability.getAbilities());
                        Log.e("yeeeh",ability.getAbilities().get(1).getAbility().getName());
                        break;

                        default:
                            break;
                }
            }

            @Override
            public void onFailure(Call<AbilityFeed> call, Throwable t) {
                Log.e("error",t.toString());
            }
        });
    }
}
