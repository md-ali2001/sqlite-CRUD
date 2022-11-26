package com.alimasood.attendance_system;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        databaseHandler=new DatabaseHandler(this);
        databaseHandler.add("lllll");



        ArrayList<readdata> names= databaseHandler.get();

       for(int i=0;i<names.size();i++)
        Log.d("returned",names.get(i).name);



    }

    public void adddata(String newitem){


    }
}