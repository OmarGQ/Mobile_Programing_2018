package com.example.omarxv.pract_10_oigq;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class practica11 extends AppCompatActivity {
    private int contador;
    private LinearLayout contenedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practica11);
        contador = 0;
        contenedor = (LinearLayout) findViewById(R.id.milistado);
    }
    public void listarproyectos(View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "admin", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor fila = db.rawQuery("select * from articulos", null);
        if (fila.moveToFirst()) {
            do {
                TextView nuevo = new TextView(this);
                nuevo.setId(contador);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                nuevo.setText(fila.getInt(1) + "     " + fila.getString(2) + "    " + fila.getFloat(3));
                nuevo.setTextColor(Color.BLUE);
                nuevo.setTextSize(14);

                contenedor.addView(nuevo, lp);
                contador = contador + 1;
            } while (fila.moveToNext());
        } else {
            Toast.makeText(this, "No existen articulos en la tabla", Toast.LENGTH_SHORT).show();

        }
        db.close();
    }

    public void regresar(View v) {
        finish();
    }
}
