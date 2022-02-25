package com.lau.audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    MediaPlayer player;
    AudioManager manager;
    SeekBar seek;
    SeekBar duration_bar;
    Button btn;
    boolean is_playing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        player = MediaPlayer.create(this, R.raw.english);
        btn = (Button) findViewById(R.id.play);
        manager = (AudioManager) getSystemService(AUDIO_SERVICE);

        int max_volume = manager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int current_volume = manager.getStreamVolume(AudioManager.STREAM_MUSIC);

        seek = (SeekBar) findViewById(R.id.seek);
        seek.setMax(max_volume);
        seek.setProgress(current_volume);

        duration_bar = (SeekBar) findViewById(R.id.duration);
        duration_bar.setMax(player.getDuration());

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                manager.setStreamVolume(AudioManager.STREAM_MUSIC, i, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        duration_bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                player.seekTo(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                player.pause();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                player.start();
            }
        });

        new Timer().scheduleAtFixedRate( new TimerTask(){
            public void run(){
                duration_bar.setProgress(player.getCurrentPosition());
            }
        }, 0, 300);
    }

    public void play(View view){

        if(!is_playing){
            player.start();
            is_playing = true;
            btn.setText("Pause");
        }else{
            player.pause();
            is_playing = false;
            btn.setText("Play");
        }


    }
}