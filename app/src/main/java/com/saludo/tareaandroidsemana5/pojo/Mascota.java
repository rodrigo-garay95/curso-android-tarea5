package com.saludo.tareaandroidsemana5.pojo;

public class Mascota {
    private int id;
    private String nombre;
    private int foto;
    private int cantidad_like;

    public Mascota(String nombre, int foto, int cantidad_like) {
        this.nombre = nombre;
        this.foto = foto;
        this.cantidad_like = cantidad_like;
    }

    public Mascota() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getCantidad_like() {
        return cantidad_like;
    }

    public void setCantidad_like(int cantidad_like) {
        this.cantidad_like = cantidad_like;
    }
}
