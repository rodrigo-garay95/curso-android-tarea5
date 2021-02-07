package com.saludo.tareaandroidsemana5.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.saludo.tareaandroidsemana5.R;
import com.saludo.tareaandroidsemana5.adapter.MascotaAdaptador;
import com.saludo.tareaandroidsemana5.db.BaseDatos;
import com.saludo.tareaandroidsemana5.db.ConstructorMascotas;
import com.saludo.tareaandroidsemana5.fragment.IMascotaFragment;
import com.saludo.tareaandroidsemana5.pojo.Mascota;
import com.saludo.tareaandroidsemana5.presentador.IRecyclerViewFavoritostPresenter;
import com.saludo.tareaandroidsemana5.presentador.IRecyclerViewFragmentPresenter;
import com.saludo.tareaandroidsemana5.presentador.RecyclerViewFavoritosPresenter;
import com.saludo.tareaandroidsemana5.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class FavoritosActivity extends AppCompatActivity implements IFavoritosActivity {

    private Toolbar miActionBar;
    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotasFav;
    public MascotaAdaptador adaptador;
    private IRecyclerViewFavoritostPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        miActionBar = (Toolbar) findViewById(R.id.miActionBarFavoritos);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Kodi", R.drawable.kodi, 4));
        mascotas.add(new Mascota("Lobi", R.drawable.lobi, 3));
        mascotas.add(new Mascota("Bali", R.drawable.bali, 2));
        mascotas.add(new Mascota("Say", R.drawable.say, 2));
        mascotas.add(new Mascota("Boss", R.drawable.boss, 1));

        RecyclerView rvMascotasFav = (RecyclerView) findViewById(R.id.rvMascotasFav);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFav.setLayoutManager(llm);

        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(mascotas, this);
        rvMascotasFav.setAdapter(mascotaAdaptador);*/

        //View v = inflater.inflate(R.layout.actionbar_favoritos, container, false);
        rvMascotasFav = (RecyclerView) findViewById(R.id.rvMascotasFav);
        presenter = new RecyclerViewFavoritosPresenter(this, getApplicationContext());
        //return v;

    }

    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFav.setLayoutManager(llm);
    }


    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }


    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        rvMascotasFav.setAdapter(adaptador);
    }
}