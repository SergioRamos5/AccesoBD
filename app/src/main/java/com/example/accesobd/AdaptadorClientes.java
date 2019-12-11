package com.example.accesobd;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class AdaptadorClientes extends ArrayAdapter {
    Activity activity;
    ArrayList<Clientes> lista;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista = convertView;
        if (vista == null)
        {
            LayoutInflater inflater = activity.getLayoutInflater();
            vista = inflater.inflate(R.layout.vista_lista, null);
            ((TextView)vista.findViewById(R.id.tV_dni)).setText(lista.get(position).getDni());
            ((TextView)vista.findViewById(R.id.tV_nombre)).setText(lista.get(position).getNombre());
            ((TextView)vista.findViewById(R.id.tV_apellido)).setText(lista.get(position).getApellidos());
        }
        return vista;
    }

    public AdaptadorClientes(Activity context, int resource, ArrayList objects) {
        super(context, resource, objects);
        activity = context;
        this.lista = objects;
    }
}
