package com.prueba.roger.appretrofitjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prueba.roger.appretrofitjava.api.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MainPresenter presenter;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews(){
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        loadJSON();
    }
    private void loadJSON(){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        RestClient restClient = retrofit.create(RestClient.class);
        Call<PokemonFeed> call = restClient.getData();

        call.enqueue(new Callback<PokemonFeed>() {
            @Override
            public void onResponse(Call<PokemonFeed> call, Response<PokemonFeed> response) {
                switch (response.code()) {
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
                //Log.e("error", t.toString());
            }
        });
    }



}
