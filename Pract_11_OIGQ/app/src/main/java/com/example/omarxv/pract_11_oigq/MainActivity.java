package com.example.omarxv.pract_11_oigq;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color; import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle; import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    private int contador;
    private LinearLayout contenedor;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = 0;
        contenedor = (LinearLayout) findViewById(R.id.milistado);
    }

    public void listarproyectos(View v) {
        AdminSQLite admin = new AdminSQLite(this, "admin", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        Cursor fila = db.rawQuery("select * from proyectos", null);
        if (fila.moveToFirst()) {
            do {
                TextView nuevo = new TextView(this);
                nuevo.setId(contador);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.WRAP_CONTENT);
                nuevo.setText(fila.getString(1) + "     " + fila.getString(2) + "    " + fila.getString(3) + "      " + fila.getString(4));
                nuevo.setTextColor(Color.BLUE);
                nuevo.setTextSize(14);

                contenedor.addView(nuevo, lp);
                contador = contador + 1;
            } while (fila.moveToNext());
        } else {
            Toast.makeText(this, "No existen proyectos en la tabla", Toast.LENGTH_SHORT).show();

        }
        db.close();
    }

    public void regresar(View v) {
        finish();
    }
}