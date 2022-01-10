package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTableListView;
    public void generateTimesTable(int timesTableNumber){
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for (int j = 1; j <= 10; j++){
            timesTableContent.add(Integer.toString(j * timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,timesTableContent);
        timesTableListView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar mySeekBar = findViewById(R.id.mySeekBar);
        timesTableListView = findViewById(R.id.myListView);
        int max = 20;
        int currProgress = 10;

        mySeekBar.setMax(max);
        mySeekBar.setProgress(currProgress);

        generateTimesTable(currProgress);

        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTableNumber;
                if(i < min){
                    timesTableNumber = min;
                    mySeekBar.setProgress(min);
                }
                else{
                    timesTableNumber = i;
                }
                Log.i("Seekbar Value", Integer.toString(timesTableNumber));
                generateTimesTable(timesTableNumber);
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