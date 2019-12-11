package com.example.accesobd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BDClientes clientes;
    SQLiteDatabase dbClientes;
    ArrayList<Clientes> listaClientes;
    Button añadir, mostrar;
    EditText dni, nombre, apellidos;
    ListView lista;
    AdaptadorClientes adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaClientes = new ArrayList<>();
        clientes = new BDClientes(getBaseContext(), "BDCLIENTES", null , 1);
        dbClientes = clientes.getWritableDatabase();

        añadir = findViewById(R.id.añadir);
        mostrar = findViewById(R.id.mostrar);
        dni = findViewById(R.id.dni);
        nombre= findViewById(R.id.nombre);
        apellidos = findViewById(R.id.apellidos);
        lista = findViewById(R.id.listView);

        seleccionarDatosCodigo(new String[]{"dni", "nombre", "apellidos"}, null , null , "apellidos");


        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter = new AdaptadorClientes(MainActivity.this,R.layout.vista_lista, listaClientes);
                lista.setAdapter(adapter);
            }
        });


        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dbClientes != null) {
                    ContentValues valores = new ContentValues();
                    valores.put("dni", dni.getText().toString());
                    valores.put("nombre", nombre.getText().toString());
                    valores.put("apellidos", apellidos.getText().toString());
                    dbClientes.insert("clientes", null, valores);
                }
            }
        });

    }

    private boolean seleccionarDatosCodigo(String[] columnas, String where, String[] valores, String orderBy)
    {
        dbClientes=clientes.getReadableDatabase();
        if (dbClientes != null)
        {
            Cursor cursor = dbClientes.query("clientes", columnas, where, valores,null,null,orderBy);
            listaClientes = Clientes.getClientes(cursor);

            if (listaClientes == null) return false;
            else return true;
        }
        return false;
    }
}
