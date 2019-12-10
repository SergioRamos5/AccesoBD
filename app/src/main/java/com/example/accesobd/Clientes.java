package com.example.accesobd;

import android.database.Cursor;

import java.util.ArrayList;

public class Clientes {

    private String dni;
    private String nombre;
    private String apellidos;

    public Clientes() {
    }

    public Clientes(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public static ArrayList<Clientes> getClientes(Cursor cursor)
    {
        ArrayList<Clientes> listaClientes;
        Clientes cliente;
        cursor.moveToFirst();
        if (!cursor.isAfterLast())
        {
            listaClientes = new ArrayList<Clientes>();

            while (!cursor.isAfterLast())
            {
                cliente = new Clientes(cursor.getString(0),cursor.getString(1), cursor.getString(2));
                listaClientes.add(cliente);
                cursor.moveToNext();
            }
            return listaClientes;
        }
        return null;
    }
}
