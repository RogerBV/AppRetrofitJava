package com.prueba.roger.appretrofitjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.prueba.roger.appretrofitjava.data.model.Ability;

import java.util.List;

public class PokemonDetailActivity extends AppCompatActivity implements PokemonDetailView {

    private RecyclerView recyclerView;
    private PokemonDetailPresenter presenter;
    private PokemonDetailAdapter adapter;
    private int idPokemon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);
        idPokemon = getIntent().getIntExtra("idpokemon",0);
        recyclerView = (RecyclerView)findViewById(R.id.mi_recicler2);
        adapter = new PokemonDetailAdapter(PokemonDetailActivity.this,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter = new PokemonDetailPresenter(this);
        presenter.getDataAbility(idPokemon);
    }

    @Override
    public void notifyDataSetChanged(List<Ability> ability) {
        adapter.swap(ability);
    }
}
