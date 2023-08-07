package com.example.omarxv.pract_7_oigq;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Bundle datos = this.getIntent().getExtras();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView boi = (TextView)findViewById(R.id.etEr);
        boi.setText(datos.getString("error"));
    }
}
