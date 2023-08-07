package com.example.omarxv.pract_10_oigq;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void crear(View v){
        Intent mainIntent =new Intent().setClass(Main2Activity.this, MainActivity.class);
        startActivity(mainIntent);
    }
    public void p11(View v){
        Intent pra =new Intent().setClass(Main2Activity.this, practica11.class);
        startActivity(pra);
    }
    public void practica12(View v){
        Intent intent =new Intent().setClass(Main2Activity.this, practica12.class);
        startActivity(intent);
    }
}
