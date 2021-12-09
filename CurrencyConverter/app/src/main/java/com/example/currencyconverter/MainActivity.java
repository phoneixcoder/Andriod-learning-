package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void convertCurr(View view){
        EditText userInput = (EditText) findViewById(R.id.userInput);

        String amountInInr = userInput.getText().toString();

        double amountInDollors = Double.parseDouble(amountInInr) + 74;

        String output = Double.toString(amountInDollors);

        Toast.makeText(this, output, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}0