package com.example.omarxv.m2integrador3;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class p13 extends Activity {

    private ImageView imageView;
    private AnimationDrawable savingAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p13);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        imageView=(ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(0);
        imageView.setBackgroundResource(R.drawable.animacion);
        savingAnimation=(AnimationDrawable) imageView.getBackground();
    }
    public void iniciar(View v){
        savingAnimation.start();
    }

    public void detener(View v){
        if(savingAnimation.isRunning()){
            savingAnimation.stop();
            savingAnimation.selectDrawable(0);
        }
    }
}
