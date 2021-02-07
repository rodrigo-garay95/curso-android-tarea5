package com.saludo.tareaandroidsemana5.activity;

import com.saludo.tareaandroidsemana5.adapter.MascotaAdaptador;
import com.saludo.tareaandroidsemana5.pojo.Mascota;

import java.util.ArrayList;

public interface IFavoritosActivity {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
