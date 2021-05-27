package com.example.aplicacionviajes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class LugaresVisitados extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView lista;
    ListaVisitas listaVisitas;
    SharedPreferences sharedpreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares_visitados);


        Intent lugarObtenido = getIntent();
        String lugar = lugarObtenido.getStringExtra("Lugar");
        Intent descripObtenida = getIntent();
        String descripcion = descripObtenida.getStringExtra("Descripcion");


        sharedpreferences = getSharedPreferences("listado", MODE_PRIVATE);
        String json = sharedpreferences.getString("lista", "");
        if (!json.isEmpty()) {
            listaVisitas = new ListaVisitas();
            listaVisitas = listaVisitas.fromJson(json);

        } else {
            listaVisitas = new ListaVisitas();

        }

        if (!(lugar == null) && !(descripcion == null)) {
            Visita visita = new Visita(lugar, descripcion);
            listaVisitas.visitas.add(visita);
        }


        lista = findViewById(R.id.lista);
        MiAdapter adapter = new MiAdapter(this, R.layout.item, listaVisitas.visitas);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(this);


    }

    @Override
    protected void onDestroy() {
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("lista", listaVisitas.toJson());
        editor.apply();

        super.onDestroy();
    }

    public void volver(View view) {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        listaVisitas.visitas.remove(position);
        ArrayAdapter adapter = (ArrayAdapter) lista.getAdapter();
        adapter.notifyDataSetChanged();
    }
}
