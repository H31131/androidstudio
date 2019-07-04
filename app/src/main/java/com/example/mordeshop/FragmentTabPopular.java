package com.example.mordeshop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class FragmentTabPopular extends Fragment {
    private RecyclerView recyclerViewPopular;
    private RecyclerViewAdaptador adaptadorPopular;
    ArrayList<Populares> popular;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vista=inflater.inflate(R.layout.fragment_tab_populares, container, false);
        popular=new ArrayList<>();
        recyclerViewPopular=vista.findViewById(R.id.recyclerPopular);
        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(getContext()));
        Obtener();
        adaptadorPopular= new RecyclerViewAdaptador(popular);
        recyclerViewPopular.setAdapter(adaptadorPopular);

        return vista;


    }

    private void Obtener() {
        popular.add(new Populares("Camiseta Clan Uzumaki","$50.000",R.drawable.numerouno));
        popular.add(new Populares("Buzo Akatsuki","$50.000",R.drawable.numerodos));
        popular.add(new Populares("Buzo Marshmello","$50.000",R.drawable.numerotres));
        popular.add(new Populares("Camiseta Tokyo Ghoul","$50.000",R.drawable.numerocuatro));
        popular.add(new Populares("Camiseta PUBG","$50.000",R.drawable.numerocinco));
        popular.add(new Populares("Camiseta LOL","$50.000",R.drawable.numeroseis));
        popular.add(new Populares("Buzo Lobo","$50.000",R.drawable.numerosiete));
        popular.add(new Populares("Camiseta End Game","$50.000",R.drawable.numeroocho));
        popular.add(new Populares("Camiseta End Game","$50.000",R.drawable.numeronueve));
    }


}
