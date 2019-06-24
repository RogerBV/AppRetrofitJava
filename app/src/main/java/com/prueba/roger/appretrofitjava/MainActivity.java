package com.prueba.roger.appretrofitjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prueba.roger.appretrofitjava.data.api.RestClient;
import com.prueba.roger.appretrofitjava.data.model.PokemonFeed;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MainView {

    private RecyclerView recyclerView;
    private MainPresenter presenter;
    private MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter = new MainPresenter(this);
        presenter.getData();
    }

    @Override
    public void notifyDataSetChanged(List<Result> pokemon) {
        adapter.swap(pokemon);
    }

    @Override
    public void navigateToDetails(int idPokemon) {
        startActivity(new Intent(this,PokemonDetailActivity.class).putExtra("idpokemon",idPokemon));
    }
}
