package com.example.accesobd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BDClientes clientes;
    SQLiteDatabase dbClientes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientes = new BDClientes(getBaseContext(), "BDCLIENTES", null , 1);
        dbClientes = clientes.getWritableDatabase();

        if (dbClientes != null)
        {
//            for (int i = 0; i < 10; i++)
//            {
//                String sentencia = "INSERT INTO clientes (dni,nombre, apellidos) VALUES('"+i+"','nombre"+i+"', 'apellido" + i + "' );";
//                dbClientes.execSQL(sentencia);
//            }
//            dbClientes.close();

//            ContentValues valores = new ContentValues();
//            valores.put("dni", "53479841");
//            valores.put("nombre", "Sergio");
//            valores.put("apellidos", "Ramos");
//            dbClientes.insert("clientes", null, valores);

//            ContentValues valore = new ContentValues();
//            valore.put("nombre", "Paula");
//            valore.put("apellidos", "Valero");
//            valore.put("dni", "53697453");
//            dbClientes.update("clientes", valore, "dni = 5", null);

//            ContentValues valroes = new ContentValues();
//            String [] args = {"0","1"};
//            dbClientes.delete("clientes", "dni=? or dni=?", args);
//            dbClientes.close();
        }
    }

    private boolean seleccionarDatosSelect()
    {
        ArrayList<Clientes> listaClientes;
        dbClientes = clientes.getReadableDatabase();

        if (dbClientes != null)
        {
            Cursor cursor = dbClientes.rawQuery("select * from clientes order by apellidos", null);
            listaClientes = Clientes.getClientes(cursor);
            dbClientes.close();
            if (listaClientes == null) return false;
            else return true;
        }
        return false;
    }
}
