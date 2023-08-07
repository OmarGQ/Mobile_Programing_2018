package com.example.omarxv.m2integrador3;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class p3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p3);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void Alert(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("informacion");
        builder.setMessage("Alerta");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        Dialog dialog=builder.create();
        dialog.show();
    }

    public void confirmacion(View v){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Confirmacion");
        builder.setMessage("Confirmar la opcion seleccionada");

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("Dialogos","Confirmacion Aceptada");
                Toast.makeText(p3.this,"Confirmado",Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.i("Dialogos","Confirmacion Cancelada");
                Toast.makeText(p3.this,"Cancelado",Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
        Dialog dialog=builder.create();
        dialog.show();
    }

    public  void seleccion(View v){
        final String[] items={"Espanol","Ingles","Frances"};
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Selecccion");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Log.i("Dialogos","Opcion elegida"+items[i]);
                dialog.cancel();
            }
        });
        Dialog dialog=builder.create();
        dialog.show();
    }
}
