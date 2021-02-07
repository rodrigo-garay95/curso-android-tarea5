package com.saludo.tareaandroidsemana5.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.saludo.tareaandroidsemana5.pojo.Mascota;
import com.saludo.tareaandroidsemana5.R;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity actividad;

    public PerfilAdaptador(ArrayList<Mascota> mascotas, Activity actividad) {
        this.mascotas = mascotas;
        this.actividad = actividad;
    }

    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.perfil_cardview, parent, false);
        return new PerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PerfilViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgMascota.setImageResource(mascota.getFoto());
        holder.txtNombre.setText(mascota.getNombre());
        holder.txtLike.setText(String.valueOf(mascota.getLike()));
        holder.imgAbajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mascota.setLike(mascota.getLike() + 1);
                holder.txtLike.setText(String.valueOf(mascota.getLike()));
                Snackbar.make(v, "+1 Like para " + mascota.getNombre(), Snackbar.LENGTH_LONG)
                        .setBackgroundTint(v.getResources().getColor(R.color.green_light))
                        .setTextColor(v.getResources().getColor(R.color.black))
                        .setActionTextColor(v.getResources().getColor(R.color.black))
                        .setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                mascota.setLike(mascota.getLike() - 1);
                                Snackbar.make(v, "Like revertido", Snackbar.LENGTH_SHORT)
                                        .setBackgroundTint(v.getResources().getColor(R.color.red_light))
                                        .setActionTextColor(v.getResources().getColor(R.color.black)).
                                        show();
                                holder.txtLike.setText(String.valueOf(mascota.getLike()));
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class PerfilViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMascota, imgArriba, imgAbajo;
        private TextView txtNombre, txtLike;

        public PerfilViewHolder(View itemView) {
            super(itemView);
            imgMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            imgArriba = (ImageView) itemView.findViewById(R.id.imgArriba);
            imgAbajo = (ImageView) itemView.findViewById(R.id.imgAbajo);
            txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            txtLike = (TextView) itemView.findViewById(R.id.txtLike);
        }
    }

}
