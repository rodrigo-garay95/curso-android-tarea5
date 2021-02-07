package com.saludo.tareaandroidsemana5.fragment;

import com.saludo.tareaandroidsemana5.adapter.MascotaAdaptador;
import com.saludo.tareaandroidsemana5.adapter.MascotaAdaptador;
import com.saludo.tareaandroidsemana5.pojo.Mascota;
import com.saludo.tareaandroidsemana5.pojo.Mascota;

import java.util.ArrayList;

public interface IMascotaFragment {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
