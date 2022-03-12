package com.lau.randomnumbers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rand;
    ListView my_list;

    public void populate (int x){
        ArrayList<String> random_numbers = new ArrayList<String>();
        double random_value = 0;
        for(int i=0; i<10; i++){
            DecimalFormat formatter = new DecimalFormat(".##");
            random_value = rand.nextDouble() * x;
            random_numbers.add( formatter.format(random_value));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, random_numbers);
        my_list.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rand = new Random();
        my_list = findViewById(R.id.my_list);
        SeekBar my_seek = findViewById(R.id.my_seek);

        my_seek.setMax(20);
        my_seek.setProgress(10);

        populate(10);

        my_seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                populate(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}