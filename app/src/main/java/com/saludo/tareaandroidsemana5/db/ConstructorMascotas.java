package com.saludo.tareaandroidsemana5.db;

import android.content.ContentValues;
import android.content.Context;

import com.saludo.tareaandroidsemana5.R;
import com.saludo.tareaandroidsemana5.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context context;

    public ConstructorMascotas(Context context){
        this.context = context;
    }


    public ArrayList<Mascota> obtenerDatos(){
        BaseDatos db = new BaseDatos(context);
        insertarCinctoMascotas(db);
        return db.obtenerTodosLasMascotas();
    }

    public void insertarCinctoMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Bali");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.bali);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE, "2");

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Kodi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.kodi);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE, "4");

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Sady");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.say);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE, "2");

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Lobi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.lobi);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE, "3");

        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "Boss");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.boss);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE, "1");

        db.insertarMascota(contentValues);

    }

    public void darLikeMascota(Mascota mascota){
        ContentValues contentValues = new ContentValues();
        BaseDatos db = new BaseDatos(context);
        int cantidad = db.obtenerLikesMascota(mascota);
        cantidad = cantidad + 1;
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE, cantidad);
        db.actualizarLikeNuevoMascota(contentValues, mascota);
    }

    public void RevertirLikeMascota(Mascota mascota){
        ContentValues contentValues = new ContentValues();
        BaseDatos db = new BaseDatos(context);
        int cantidad = db.obtenerLikesMascota(mascota);
        cantidad = cantidad - 1;
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_CANTIDAD_LIKE, cantidad);
        db.actualizarLikeRevertidoMascota(contentValues, mascota);
    }

    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesMascota(mascota);
    }

    public ArrayList<Mascota> obtenerRanking(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerRankingMascotas();
    }

}
