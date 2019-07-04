package com.example.mordeshop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class FragmentTabNuevos extends Fragment {
    private RecyclerView recyclerViewPopular;
    private RecyclerViewAdaptador adaptadorPopular;
    ArrayList<Populares> popular;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View vista=inflater.inflate(R.layout.fragment_tab_nuevos, container, false);
        popular=new ArrayList<>();
        recyclerViewPopular=vista.findViewById(R.id.RecyclerViewNuevos);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(getContext()));
        Obtener();
        adaptadorPopular=new RecyclerViewAdaptador(popular);
        recyclerViewPopular.setAdapter(adaptadorPopular);
        return vista;
    }

    private void Obtener() {
        popular.add(new Populares("","",R.drawable.numeroseis));
    }

}
