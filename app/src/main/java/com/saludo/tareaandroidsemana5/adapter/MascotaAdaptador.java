package com.saludo.tareaandroidsemana5.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.saludo.tareaandroidsemana5.activity.ContactoActivity;
import com.saludo.tareaandroidsemana5.db.ConstructorMascotas;
import com.saludo.tareaandroidsemana5.pojo.Mascota;
import com.saludo.tareaandroidsemana5.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity actividad;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity actividad) {
        this.mascotas = mascotas;
        this.actividad = actividad;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascota_cardview, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgMascota.setImageResource(mascota.getFoto());
        holder.txtNombre.setText(mascota.getNombre());
        holder.txtLike.setText(String.valueOf(mascota.getCantidad_like()) + " Likes");

        holder.imgMascota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(actividad, mascota.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(actividad, ContactoActivity.class);
                intent.putExtra("nombre", mascota.getNombre());
                intent.putExtra("foto", mascota.getFoto());
                intent.putExtra("cantidad_like", mascota.getCantidad_like());
                actividad.startActivity(intent);
            }
        });


        holder.imgAbajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "+1 Like para " + mascota.getNombre(), Snackbar.LENGTH_LONG)
                        .setBackgroundTint(v.getResources().getColor(R.color.green_light))
                        .setTextColor(v.getResources().getColor(R.color.black))
                        .setActionTextColor(v.getResources().getColor(R.color.black))
                        .setAction("Deshacer", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Snackbar.make(v, "Like revertido", Snackbar.LENGTH_SHORT)
                                        .setBackgroundTint(v.getResources().getColor(R.color.red_light))
                                        .setActionTextColor(v.getResources().getColor(R.color.black)).
                                        show();
                                ConstructorMascotas constructorMascotas = new ConstructorMascotas(actividad);
                                constructorMascotas.RevertirLikeMascota(mascota);
                                holder.txtLike.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)) + " Likes");
                            }
                        })
                        .show();

                        ConstructorMascotas constructorMascotas = new ConstructorMascotas(actividad);
                        constructorMascotas.darLikeMascota(mascota);

                        holder.txtLike.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)) + " Likes");
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgMascota, imgArriba, imgAbajo;
        private TextView txtNombre, txtLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgMascota = (ImageView) itemView.findViewById(R.id.imgMascota);
            imgArriba = (ImageView) itemView.findViewById(R.id.imgArriba);
            imgAbajo = (ImageView) itemView.findViewById(R.id.imgAbajo);
            txtNombre = (TextView) itemView.findViewById(R.id.txtNombre);
            txtLike = (TextView) itemView.findViewById(R.id.txtLike);
        }
    }

}
