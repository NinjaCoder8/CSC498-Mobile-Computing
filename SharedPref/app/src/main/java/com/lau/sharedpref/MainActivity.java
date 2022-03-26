package com.lau.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences shared = this.getSharedPreferences("com.lau.shared", Context.MODE_PRIVATE);
        shared.edit().putString("token_a", "e123dewsqa");

        String token = shared.getString("token_a", "") + "/";
        Toast.makeText(getApplicationContext(), token, Toast.LENGTH_LONG).show();


    }
}