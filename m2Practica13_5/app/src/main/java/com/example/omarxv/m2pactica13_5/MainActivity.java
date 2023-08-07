package com.example.omarxv.m2pactica13_5;
//Omar Ildefonso Godinez Quiñones
//15300515
//6-H
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private int position = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        videoView = (VideoView) findViewById(R.id.videoView);
        setUpVideoView();
    }

    private void setUpVideoView() {
        String uriPath = "android.resource://" + getPackageName()+"/" + R.raw.re;
        Uri uri = Uri.parse(uriPath);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        try {
            videoView.setVideoURI(uri);
            videoView.requestFocus();
        } catch (Exception e) {
        }
        videoView.setOnPreparedListener(videoViewListener);
    }

    private MediaPlayer.OnPreparedListener videoViewListener = new
            MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.setLooping(true);
                    if (position == 0) {
                        videoView.start();
                    } else {
                        videoView.pause();
                    }
                }
            };
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("Position",videoView.getCurrentPosition());
        videoView.pause();
    }
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("Position");
        videoView.seekTo(position);
    }
}