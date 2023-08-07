package com.example.omarxv.pract_7_oigq;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_principal);
    }
    public void buscar(View v){
        Intent mainIntent =new Intent().setClass(principal.this, Buscar.class);
        startActivity(mainIntent);
    }
    public void captura(View v){
        Intent mainIntent =new Intent().setClass(principal.this, Capturar.class);
        startActivity(mainIntent);
    }
    public void eli(View v){
        Intent mainIntent =new Intent().setClass(principal.this, Eliminar.class);
        startActivity(mainIntent);
    }
    public void act(View v){
        Intent mainIntent =new Intent().setClass(principal.this, Actualizar.class);
        startActivity(mainIntent);
    }
    public void salir (View v){
        finish();
    }
}
