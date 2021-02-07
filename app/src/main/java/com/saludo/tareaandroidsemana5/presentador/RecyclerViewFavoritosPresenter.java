package com.saludo.tareaandroidsemana5.presentador;

import android.content.Context;

import com.saludo.tareaandroidsemana5.activity.FavoritosActivity;
import com.saludo.tareaandroidsemana5.activity.IFavoritosActivity;
import com.saludo.tareaandroidsemana5.db.ConstructorMascotas;
import com.saludo.tareaandroidsemana5.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFavoritosPresenter implements IRecyclerViewFavoritostPresenter {

    private IFavoritosActivity iFavoritosActivity;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFavoritosPresenter(IFavoritosActivity iFavoritosActivity, Context context){
        this.iFavoritosActivity = iFavoritosActivity;
        this.context = context;
        obtenerRankingBaseDatos();
    }

    @Override
    public void obtenerRankingBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerRanking();
        mostrarRankingRV();
    }

    @Override
    public void mostrarRankingRV() {
        iFavoritosActivity.inicializarAdaptadorRV(iFavoritosActivity.crearAdaptador(mascotas));
        iFavoritosActivity.generarLinearLayoutVertical();
    }

}
