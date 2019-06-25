package com.prueba.roger.appretrofitjava;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.prueba.roger.appretrofitjava.data.model.Ability;

import java.util.ArrayList;
import java.util.List;

public class PokemonDetailAdapter extends RecyclerView.Adapter<PokemonDetailAdapter.PokemonViewHolder> {
    private List<Ability> list;
    private Context context;
    private PokemonDetailView view;

    public PokemonDetailAdapter(Context context, PokemonDetailView view)
    {
        this.list = new ArrayList<>();
        this.context = context;
        this.view = view;
    }
    public void swap(List<Ability> newList)
    {
        list.clear();
        list.addAll(newList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PokemonViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_ability_item,parent,false));
    }

    @Override
    public void onBindViewHolder(PokemonViewHolder holder, int position) {
        final Ability ability = list.get(position);
        Log.d("size",String.valueOf(list.size()));
        holder.tvAbility.setText(ability.getAbility().getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder{
        TextView tvAbility;
        public PokemonViewHolder(View itemView){
            super(itemView);
            tvAbility = (TextView)itemView.findViewById(R.id.tv_ability);
        }
    }
}
