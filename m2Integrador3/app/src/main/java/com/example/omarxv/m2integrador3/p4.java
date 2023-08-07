package com.example.omarxv.m2integrador3;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class p4 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p4);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        findViewById(R.id.bt1).setOnClickListener(mClickListener);
        findViewById(R.id.bt2).setOnClickListener(mClickListener);
    }

    View.OnClickListener mClickListener =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.bt1:
                    startService(new Intent(p4.this, MyService.class));
                    break;
                case R.id.bt2:
                    stopService(new Intent(p4.this, MyService.class));
                    break;
            }
        }
    };
}
