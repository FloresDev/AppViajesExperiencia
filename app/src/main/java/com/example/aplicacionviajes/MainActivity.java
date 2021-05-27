package com.example.aplicacionviajes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_lugar;
    EditText et_descripcion;
    SharedPreferences preferences;
    ListaVisitas listaVisitas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_lugar = findViewById(R.id.et_lugar);
        et_descripcion = findViewById(R.id.et_descrip);





        preferences = getSharedPreferences("datosMain", MODE_PRIVATE);
        String lugarGuardado = preferences.getString("lugarVisitado", "");
        String descripcionGuardada = preferences.getString("lugarDescrito", "");


        et_lugar.setText(lugarGuardado);
        et_descripcion.setText(descripcionGuardada);

    }

    @Override
    protected void onDestroy() {
        String lugarGuardado = et_lugar.getText().toString();
        String descripcionGuardada = et_descripcion.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("lugarVisitado", lugarGuardado);
        editor.putString("lugarDescrito", descripcionGuardada);
        editor.apply();


        super.onDestroy();
    }

    public void guardarVisita(View view){
        //Pongo dos ifs para que en caso de que se cumplan ambas condiciones, nos muestre ambos Toasts.
        if (et_lugar.getText().toString().isEmpty()){
            Toast.makeText(this, "Debes rellenar el campo del lugar para poderlo añadir",Toast.LENGTH_SHORT).show();
        }
        if (et_descripcion.getText().toString().isEmpty()){
            Toast.makeText(this, "Debes rellenar el campo de la descripción  para poderlo añadir",Toast.LENGTH_SHORT).show();
        }else if (!et_lugar.getText().toString().isEmpty() && !et_descripcion.getText().toString().isEmpty()) {
            String lugar = et_lugar.getText().toString();
            String descripcion = et_descripcion.getText().toString();
            Intent intent = new Intent(this, LugaresVisitados.class);
            intent.putExtra("Lugar", lugar);
            intent.putExtra("Descripcion", descripcion);
            startActivity(intent);


        }


    }
    public void abrirLugaresVisitados(View view){
        Intent intent = new Intent(this, LugaresVisitados.class);
        startActivity(intent);
    }


}



