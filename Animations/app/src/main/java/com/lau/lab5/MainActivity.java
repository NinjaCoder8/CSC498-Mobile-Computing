package com.lau.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void animate(View view){

        ImageView img1 = (ImageView) findViewById(R.id.img1);
        ImageView img2 = (ImageView) findViewById(R.id.img2);

        if(img1.getAlpha() == 1){
            img1.animate().alpha(0).setDuration(2000);
            img2.animate().alpha(1).setDuration(2000);
        }else{
            img1.animate().alpha(1).setDuration(2000);
            img2.animate().alpha(0).setDuration(2000);
        }

    }


    public void doSmthgElse(View view){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView img1 = (ImageView) findViewById(R.id.img1);
        img1.setX(-1000);
        img1.animate().translationXBy(1000).rotation(3600).setDuration(2000);

    }
}
