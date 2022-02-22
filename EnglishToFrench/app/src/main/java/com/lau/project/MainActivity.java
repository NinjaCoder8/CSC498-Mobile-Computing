package com.lau.project;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playMe(View view){

        Button btn = (Button) view;
        String tag = btn.getTag().toString();

        MediaPlayer player = MediaPlayer.create(this, getResources().getIdentifier(tag, "raw", getPackageName()));
        player.start();

    }
}