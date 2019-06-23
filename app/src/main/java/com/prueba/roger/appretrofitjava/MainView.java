package com.prueba.roger.appretrofitjava;

import java.util.List;

public interface MainView {
    void notifyDataSetChanged(List<Result> pokemon);
    void navigateToDetails(int idPokemon);
}
