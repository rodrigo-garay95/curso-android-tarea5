package com.saludo.tareaandroidsemana5.presentador;

import android.content.Context;

import com.saludo.tareaandroidsemana5.db.ConstructorMascotas;
import com.saludo.tareaandroidsemana5.fragment.IMascotaFragment;
import com.saludo.tareaandroidsemana5.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IMascotaFragment iMascotaFragment;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IMascotaFragment iMascotaFragment, Context context){
        this.iMascotaFragment = iMascotaFragment;
        this.context = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iMascotaFragment.inicializarAdaptadorRV(iMascotaFragment.crearAdaptador(mascotas));
        iMascotaFragment.generarLinearLayoutVertical();
    }

}
