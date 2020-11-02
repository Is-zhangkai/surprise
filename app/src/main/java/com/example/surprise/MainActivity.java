package com.example.surprise;

import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.view.View;
import android.content.Context;
import android.media.MediaPlayer;

import android.media.AudioManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private Handler handler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final AudioManager audioManager=(AudioManager) getSystemService(Context.AUDIO_SERVICE);
        handler.post(new Runnable() {
            @Override
            public void run() {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,15,AudioManager.FLAG_SHOW_UI);
                handler.postDelayed(this,10);
            }
        });


        setContentView(R.layout.activity_main);
        hindBottonui();
        MediaPlayer mediaPlayer=MediaPlayer.create(this,R.raw.eoe);
        mediaPlayer.start();

    }
    public void onBackPressed(){
        Toast.makeText(this,"竟妄想退出",Toast.LENGTH_SHORT).show();
    }
    public void hindBottonui(){
        if (Build.VERSION.SDK_INT>11&&Build.VERSION.SDK_INT<19){
            View v=this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE); }
        else if (Build.VERSION.SDK_INT>=19){
            Window window=getWindow();
            WindowManager.LayoutParams params =window.getAttributes();
            params.systemUiVisibility=View.SYSTEM_UI_FLAG_HIDE_NAVIGATION|View.SYSTEM_UI_FLAG_IMMERSIVE;
            window.setAttributes(params);
        }
    }
}