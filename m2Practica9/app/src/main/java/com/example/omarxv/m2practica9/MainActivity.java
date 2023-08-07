package com.example.omarxv.m2practica9;
//Omar Ildefonso Godinez Quiñones
//15300515
//6-H
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView texto;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.texto);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        List<Sensor>mList=sensorManager.getSensorList(Sensor.TYPE_ALL);

        for(int i=1; i<mList.size(); i++){
            texto.append("\n\nSensor: "+mList.get(i).getName()+"\nEmpresa: "+ mList.get(i).getVendor()+"\nVersion: "+mList.get(i).getVersion());
        }
    }
}
