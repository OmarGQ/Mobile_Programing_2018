package com.example.omarxv.m2practica11;
//Omar Ildeofnso Godinez Quiñones
//15300515
//6-H
import android.graphics.drawable.AnimationDrawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private AnimationDrawable savingAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
