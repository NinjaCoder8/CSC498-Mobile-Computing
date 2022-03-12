package com.lau.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Intent y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent x = getIntent();
        String name = x.getStringExtra("first_name");
        String major = x.getStringExtra("his_major");
        Toast.makeText(getApplicationContext(), name + "-" + major, Toast.LENGTH_LONG).show();

    }

    public void pageOne(View view){
        Intent intent = new Intent(getApplicationContext(), Page2Activity.class);
        startActivity(intent);
    }
}