package com.example.imagestest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void switchCat(View view){
        Log.i("Info" , "Pressed!");
        ImageView imageview = (ImageView) findViewById(R.id.catOne);
        imageview.setImageResource(R.drawable.wolf_silhouette_moon_night_118727_2560x1440);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}