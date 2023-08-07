package com.example.omarxv.pract_10_oigq;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    private ListView miLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
    public void listado(View v){
        ArrayList<String> Coleccion=new ArrayList<String>();
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this,"administracion", null, 1);
        SQLiteDatabase bd=admin.getWritableDatabase();
        Cursor fila=bd.rawQuery("select * from articulos where 1", null);
        if(fila.moveToFirst()){
            do{
                Coleccion.add(fila.getString(0)+"/"+fila.getString(1)+"/"+fila.getString(2));
            }while(fila.moveToNext());
        }
        else
        {
            Toast.makeText(this, "No existen articulos en la tabla", Toast.LENGTH_SHORT).show();
        }
        bd.close();
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,Coleccion);
        miLista.setAdapter(adaptador);
    }
}
