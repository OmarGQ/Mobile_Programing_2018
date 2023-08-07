package com.example.omarxv.m2integrador3;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class Audio extends Service{
    private Context thisContext=this;
    private MediaPlayer mediaPlayer;
    @Override
    public void onCreate()
    {
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int idProcess)
    {
        mediaPlayer=new MediaPlayer();
        mediaPlayer = MediaPlayer.create(thisContext,R.raw.rh);
        mediaPlayer.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy()
    {
        mediaPlayer.stop();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}