package com.example.aplicacionviajes;

import com.google.gson.Gson;

import java.util.ArrayList;

public class ListaVisitas {

    public ArrayList<Visita> visitas;


    public ListaVisitas() {
        visitas = new ArrayList<>();
    }

    public String toJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public ListaVisitas fromJson(String json) {
        Gson gson = new Gson();
        ListaVisitas listaVisitas = gson.fromJson(json, ListaVisitas.class);
        return listaVisitas;
    }
}
