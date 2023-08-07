package com.example.omarxv.m2integrador3;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    public void pra1(View v){
        Intent i=new Intent(this, p1.class);
        startActivity(i);
    }

    public void pra2(View v){
        Intent i=new Intent(this, p2.class);
        startActivity(i);
    }

    public void pra3(View v){
        Intent i=new Intent(this, p3.class);
        startActivity(i);
    }

    public void pra4(View v){
        Intent i=new Intent(this, p4.class);
        startActivity(i);
    }

    public void pra5(View v){
        Intent i=new Intent(this, p5.class);
        startActivity(i);
    }

    public void pra6(View v){
        Intent i=new Intent(this, p6.class);
        startActivity(i);
    }

    public void pra7(View v){
        Intent i=new Intent(this, p7.class);
        startActivity(i);
    }

    public void pra8(View v){
        Intent i=new Intent(this, p8.class);
        startActivity(i);
    }

    public void pra10(View v){
        Intent i=new Intent(this, p10.class);
        startActivity(i);
    }

    public void pra11(View v){
        Intent i=new Intent(this, p11.class);
        startActivity(i);
    }

    public void pra12(View v){
        Intent i=new Intent(this, p12.class);
        startActivity(i);
    }

    public void pra13(View v){
        Intent i=new Intent(this, p13.class);
        startActivity(i);
    }

    public void pra14(View v){
        Intent i=new Intent(this, p14.class);
        startActivity(i);
    }

    public void pra15(View v){
        Intent i=new Intent(this, p15.class);
        startActivity(i);
    }

    public void prain1(View v){
        Intent i=new Intent(this, in1.class);
        startActivity(i);
    }

    public void prain2(View v){
        Intent i=new Intent(this, in2.class);
        startActivity(i);
    }

    public void salir(View v){
        finish();
    }
}
