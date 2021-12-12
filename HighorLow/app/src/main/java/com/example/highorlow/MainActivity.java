package com.example.highorlow;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int i1;

    public void generateRandom(){
        Random r = new Random();
        i1 = (r.nextInt(20) + 0);
    }

    public void checkNumber(View view){
        EditText editText = (EditText) findViewById(R.id.editText);
        int num = Integer.parseInt(editText.getText().toString());
        String message;
        if (i1 > num){
            message = "High";
        }
        else if (i1 < num){
            message = "Low";
        }
        else{
            message = "Congratulations! Start again.";
            generateRandom();
        }

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRandom();
    }
}