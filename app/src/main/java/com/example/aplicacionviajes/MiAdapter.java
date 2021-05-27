package com.example.aplicacionviajes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MiAdapter extends ArrayAdapter {

    Context context;
    int itemLayout;
    ArrayList<Visita> visitas;

    public MiAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Visita> objects) {
        super(context, resource, objects);
        this.context = context;
        itemLayout = resource;
        visitas = objects;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(itemLayout, parent, false);
        }
        TextView tv_lugar = convertView.findViewById(R.id.tv_lugar);
        tv_lugar.setText(visitas.get(position).lugar);
        TextView tv_descripcion = convertView.findViewById(R.id.tv_descripcion);
        tv_descripcion.setText(visitas.get(position).descripcion);
        return convertView;
    }
}
