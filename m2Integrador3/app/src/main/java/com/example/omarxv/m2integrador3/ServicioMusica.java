package com.example.omarxv.m2integrador3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

public class ServicioMusica extends Service {
    private MediaPlayer reproductor;
    private NotificationManager nm;
    private static final int ID_NOTIFICACION_CREADA = 1;
    CharSequence titulo ="Servicio con reproduccion de sonido";
    CharSequence tiker = "The future is now";
    CharSequence texto = "The future is now";

    public void onCreate(){
        Toast.makeText(this,"Servicio creado", Toast.LENGTH_SHORT).show();
        nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        Intent i=new Intent(ServicioMusica.this, MainActivity.class);
        PendingIntent pintent = PendingIntent.getActivity(ServicioMusica.this, 0, i,0);
        Notification notification = new NotificationCompat.Builder(this)
                .setContentIntent(pintent)
                .setTicker(tiker)
                .setContentTitle(titulo)
                .setContentText(texto)
                .setSmallIcon(R.mipmap.ic_launcher)
                .addAction(android.R.drawable.stat_sys_warning, tiker, pintent)
                .build();
        notification.defaults |=Notification.DEFAULT_SOUND;//reproducir sonido por defecto
        long[] vibrate={100,250,100,500};
        notification.vibrate=vibrate;
        notification.ledARGB = 0xff00ffff;
        notification.ledOnMS = 300;
        notification.ledOffMS = 1000;
        notification.flags |=Notification.FLAG_SHOW_LIGHTS;
        reproductor = MediaPlayer.create(this, R.raw.now);
        nm.notify(ID_NOTIFICACION_CREADA, notification);
    }

    public int onStartCommand(Intent intent, int band, int idArranque){
        Toast.makeText(this, "Servicio iniciado"+idArranque,Toast.LENGTH_SHORT).show();
        reproductor.start();
        return START_STICKY;
    }

    public void onDestroy(){
        Toast.makeText(this, "Servicio detenido", Toast.LENGTH_SHORT).show();
        reproductor.stop();
        nm.cancel(ID_NOTIFICACION_CREADA);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
