package com.example.omarxv.practica1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Omar Ildefonso Godinez Quiñones
    //15300515
    //6-H
    int notificationID=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void notificacion(View v){
        displayNotification();
    }

    protected  void displayNotification(){
        Intent i=new Intent(this,MainActivity.class);
        i.putExtra("notificationID",notificationID);

        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,i,0);
        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        CharSequence tiker="Nueva Entrada";
        CharSequence contentTitle="System";
        CharSequence contentText="Visita ahora System!";

        Notification noti=new NotificationCompat.Builder(this)
                .setContentIntent(pendingIntent)
                .setTicker(tiker)
                .setContentTitle(contentTitle)
                .setContentText(contentText)
                .setSmallIcon(android.R.drawable.stat_sys_warning)
                .addAction(android.R.drawable.stat_sys_warning, tiker, pendingIntent)
                .setVibrate(new long[]{100,250,100,500})
                .build();

        nm.notify(notificationID,noti);
    }
}
