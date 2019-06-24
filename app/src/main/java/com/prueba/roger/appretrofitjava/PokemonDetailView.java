package com.prueba.roger.appretrofitjava;
import java.util.List;
import com.prueba.roger.appretrofitjava.data.model.Ability;

public interface PokemonDetailView {
    void notifyDataSetChanged(List<Ability> ability);
}
