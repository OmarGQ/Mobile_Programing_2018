package com.example.omarxv.m2integrador3;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class p10 extends Activity {

    TextView texto;
    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p10);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        texto = (TextView) findViewById(R.id.texto);

        sensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);

        List<Sensor> mList=sensorManager.getSensorList(Sensor.TYPE_ALL);

        for(int i=1; i<mList.size(); i++){
            texto.append("\n\nSensor: "+mList.get(i).getName()+"\nEmpresa: "+ mList.get(i).getVendor()+"\nVersion: "+mList.get(i).getVersion());
        }
    }
}
