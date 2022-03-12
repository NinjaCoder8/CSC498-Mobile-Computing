package com.lau.lists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    ListView my_list;
    ArrayList<String> the_list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        my_list = (ListView) findViewById(R.id.myList);

        /*the_list = new ArrayList<String>();
        the_list.add("Mobile Computing");
        the_list.add("Database Management Systems");
        the_list.add("Software Engineering");*/

        the_list = new ArrayList<String>(Arrays.asList("Mobile Computing", "Database Management Systems", "Software Engineering"));

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, the_list);
        my_list.setAdapter(adapter);

        my_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), the_list.get(i), Toast.LENGTH_LONG).show();
            }
        });

    }

    public void addList(View view){
        the_list.add("I'm adding from JAVA");
        my_list.setAdapter(adapter);
    }


}