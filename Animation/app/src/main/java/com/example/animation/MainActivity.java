package com.example.animation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    boolean flag = true;

    public void fader(View view){
        ImageView bartImg = (ImageView) findViewById(R.id.bartImg);
        ImageView homeImg = (ImageView) findViewById(R.id.homeImg);

        if (flag == true){
            flag = false;
            bartImg.animate().alpha(0).setDuration(2000);
            homeImg.animate().alpha(1).setDuration(2000);
        }else{
            flag = true;
            bartImg.animate().alpha(1).setDuration(2000);
            homeImg.animate().alpha(0).setDuration(2000);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}