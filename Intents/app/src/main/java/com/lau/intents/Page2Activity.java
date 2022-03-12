package com.lau.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Page2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
    }

    public void goToPage2(View view){
        String name = "Charbel";
        String major = "CSC";
        Intent obj = new Intent(getApplicationContext(), MainActivity.class);
        obj.putExtra("first_name", name);
        obj.putExtra("his_major", major);
        startActivity(obj);

    }
}