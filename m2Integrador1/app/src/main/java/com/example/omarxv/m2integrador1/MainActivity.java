package com.example.omarxv.m2integrador1;
//Omar Ildefonso Godinez Quiñones
//15300515
//6-H
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void iniciar(View v){
        startService(new Intent(MainActivity.this, ServicioMusica.class));
    }

    public void detener(View v){
        stopService(new Intent(MainActivity.this, ServicioMusica.class));
    }
}
