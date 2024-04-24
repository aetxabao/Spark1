package com.masanz.da.sp.dto;

public class Producto {

    private String nombre;
    private String url;

    public Producto() {
        this("", "" );
    }

    public Producto(String nombre, String url) {
        this.nombre = nombre;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}