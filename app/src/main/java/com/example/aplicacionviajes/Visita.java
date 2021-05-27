package com.example.aplicacionviajes;

import com.google.gson.Gson;

public class Visita {

    String lugar;
    String descripcion;

    public Visita(String lugar, String descripcion) {
        this.lugar = lugar;
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String toJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public Visita fromJson(String json) {
        Gson gson = new Gson();
        Visita visita = gson.fromJson(json, Visita.class);
        return visita;
    }

}
