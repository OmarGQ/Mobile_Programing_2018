package com.example.omarxv.m2practica2;
//Omar Ildefonso Godinez Quiñones
//15300515
//6-H
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt=(Button)findViewById(R.id.btn);
        bt.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                NotificationManager mNotifyMgr=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                int  icono = R.mipmap.ic_launcher;

                Intent i=new Intent(MainActivity.this, MensageActivity.class);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,i,0);

                Notification mBuilder = new NotificationCompat.Builder(getApplicationContext())
                        .setContentIntent(pendingIntent)
                        .setSmallIcon(icono)
                        .setContentTitle("Titulo")
                        .setContentText("Texto")
                        .setVibrate(new long[]{100,250,100,500})
                        .setAutoCancel(true)
                        .build();
                mNotifyMgr.notify(1,mBuilder);
            }
        });
    }
    }


