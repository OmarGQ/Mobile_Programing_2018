package com.example.omarxv.practica6;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class Splash extends Activity {

    private static final long SPLASH_SCREEN_DELAY = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.OnCreate(savedInstanceState);
        setRecuestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        recuestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.splash);
        TimerTask task = new TimerTask(){
            @Override
            public void run (){
                Intent mainIntent = new Intent().setClass(Splash.this, MainActivity.calss);
                startActivity(mainIntent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DEALY);
}
