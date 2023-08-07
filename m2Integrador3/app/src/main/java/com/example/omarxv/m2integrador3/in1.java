package com.example.omarxv.m2integrador3;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class in1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in1);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }
    public void iniciar(View v){
        startService(new Intent(in1.this, ServicioMusica.class));
    }

    public void detener(View v){
        stopService(new Intent(in1.this, ServicioMusica.class));
    }
}
