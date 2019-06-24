package com.prueba.roger.appretrofitjava;
import android.util.Log;

import com.prueba.roger.appretrofitjava.data.api.RestClient;
import com.prueba.roger.appretrofitjava.data.api.RetrofitUtils;
import com.prueba.roger.appretrofitjava.data.model.PokemonFeed;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {
    private MainView view;
    public MainPresenter(MainView mainView)
    {
        this.view = mainView;
    }
    public void getData(){
        RestClient restClient = RetrofitUtils.getInstance().create(RestClient.class);
        Call<PokemonFeed> call = restClient.getData();

        call.enqueue(new Callback<PokemonFeed>() {
            @Override
            public void onResponse(Call<PokemonFeed> call, Response<PokemonFeed> response) {
                switch (response.code())
                {
                    case 200:
                        PokemonFeed data = response.body();
                        view.notifyDataSetChanged(data.getResults());
                        break;
                    case 401:
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onFailure(Call<PokemonFeed> call, Throwable t) {
                Log.e("error",t.toString());
            }
        });
    }
}
