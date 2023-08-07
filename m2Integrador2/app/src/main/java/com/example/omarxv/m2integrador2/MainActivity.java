package com.example.omarxv.m2integrador2;
//Omar Ildefonso Godinez Quiñones
//15300515
//6-H
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button ubicar;
    private EditText lat1, latDe, lon1, lonDe;
    String d1, d2, d3, d4;
    double latU, lonU, latD, lonD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lat1=(EditText)findViewById(R.id.lat1);
        latDe=(EditText)findViewById(R.id.lat2);
        lon1=(EditText)findViewById(R.id.long1);
        lonDe=(EditText)findViewById(R.id.long2);
        ubicar=(Button)findViewById(R.id.btn);
        ubicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d1=lat1.getText().toString();
                d2=latDe.getText().toString();
                d3=lon1.getText().toString();
                d4=lonDe.getText().toString();
                latU=Double.parseDouble(d1);
                latD=Double.parseDouble(d2);
                lonU=Double.parseDouble(d3);
                lonD=Double.parseDouble(d4);
                Intent intent=new Intent(MainActivity.this, MapsActivity.class);
                intent.putExtra("longitudeU", lonU);
                intent.putExtra("latitudeU", latU);
                intent.putExtra("longitudeD", lonD);
                intent.putExtra("latitudeD", latD);
                startActivity(intent);
            }
        });
    }
}
