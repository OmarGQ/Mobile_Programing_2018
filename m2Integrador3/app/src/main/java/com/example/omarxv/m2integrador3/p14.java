package com.example.omarxv.m2integrador3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class p14 extends Activity implements
        View.OnClickListener {
    private Context thisContext=this;
    private Button btnIniciar;
    private Button btnDetener;
    private Button btnSonido;
    MediaPlayer mediaPlayer;
    SoundPool soundPool;
    int carga;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p14);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        btnIniciar=(Button) findViewById(R.id.btnIniciar);
        btnDetener=(Button) findViewById(R.id.btnDetener);
        btnSonido=(Button) findViewById(R.id.btnSonido);

        btnIniciar.setOnClickListener(this);
        btnDetener.setOnClickListener(this);
        btnSonido.setOnClickListener(this);

        soundPool=new SoundPool(8, AudioManager.STREAM_MUSIC,0);
        //Trabajar con el Audio del Volumen de la Musica
        this.setVolumeControlStream(AudioManager.STREAM_MUSIC);

        carga=soundPool.load(this,R.raw.mirai,1);
        mediaPlayer=new MediaPlayer();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btnIniciar:
                // play_mp();
                startService(new Intent(thisContext, Audio.class));
                break;
            case R.id.btnDetener:
                // mediaPlayer.stop();
                stopService(new Intent(thisContext,Audio.class));
                break;
            case R.id.btnSonido:
                soundPool.play(carga,1,1,0,0,1);
                break;
            default:
                break;
        }
    }
    private void play_mp()
    {
        Thread playThread = new Thread() {
            public void run()
            {
                mediaPlayer = MediaPlayer.create(p14.this,R.raw.mirai);
                mediaPlayer.start();
            }
        };
        playThread.start();
    }
}