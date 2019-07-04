package com.example.mordeshop;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdaptador
        extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder>
        {


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        private TextView nombre,precio;
        ImageView Imagen;
        Button btnComprar;

        public ViewHolder( View itemView) {
            super(itemView);
            context = itemView.getContext();
            nombre=(TextView)itemView.findViewById(R.id.nombre);
            precio=(TextView)itemView.findViewById(R.id.precio);
            Imagen=(ImageView)itemView.findViewById(R.id.imgUno);
            btnComprar =(Button) itemView.findViewById(R.id.btnComprar);

        }
        void setOnClickListeners(){
            btnComprar.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnComprar:
                Intent intent = new Intent(context,ActivityCompra.class);
                context.startActivity(intent);
            }
        }
    }
    public List<Populares> PopularesLista;

    public RecyclerViewAdaptador(List<Populares> popularesLista) {
        PopularesLista = popularesLista;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_popular,viewGroup, false);

        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int i) {
        viewHolder.nombre.setText(PopularesLista.get(i).getNombre());
        viewHolder.precio.setText(PopularesLista.get(i).getPrecio());
        viewHolder.Imagen.setImageResource(PopularesLista.get(i).getImagen());
        viewHolder.setOnClickListeners();

    }

    @Override
    public int getItemCount() {
        return PopularesLista.size();
    }



}

