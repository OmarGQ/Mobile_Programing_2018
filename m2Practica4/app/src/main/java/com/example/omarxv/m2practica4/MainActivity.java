package com.example.omarxv.m2practica4;
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
        findViewById(R.id.bt1).setOnClickListener(mClickListener);
        findViewById(R.id.bt2).setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.bt1:
                    startService(new Intent(MainActivity.this, MyService.class));
                    break;
                case R.id.bt2:
                    stopService(new Intent(MainActivity.this, MyService.class));
                    break;
            }
        }
    };
}
