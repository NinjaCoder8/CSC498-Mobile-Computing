package com.lau.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try{

            SQLiteDatabase sql = this.openOrCreateDatabase("laudb", MODE_PRIVATE, null);
            sql.execSQL("CREATE Table IF NOT EXISTS students (first_name VARCHAR, last_name VARCHAR)");
            //sql.execSQL("INSERT INTO students(first_name, last_name) VALUES ('John', 'Doe')");
            //sql.execSQL("INSERT INTO students(first_name, last_name) VALUES ('Charbel', 'Daoud')");

            sql.execSQL("DELETE FROM students where first_name = 'John'");


            Cursor c = sql.rawQuery("Select * from students", null);
            int fnameIndex = c.getColumnIndex("first_name");
            int lnameIndex = c.getColumnIndex("last_name");
            c.moveToFirst();

            while(c!= null){
                String name = c.getString(fnameIndex) + " " + c.getString(lnameIndex);
                Toast.makeText(getApplicationContext(), name, Toast.LENGTH_LONG).show();
                c.moveToNext();
            }
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}