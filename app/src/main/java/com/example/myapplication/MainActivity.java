package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void clickME(View view){
        EditText userName = (EditText) findViewById(R.id.userName);
        Log.i("Info", "Button-Pressed");
        Log.i("Username: " , userName.getText().toString());
//        Toast.makeText(this, "Hii"userName.getText().toString(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "Hii " + userName.getText().toString() + "!!", Toast.LENGTH_SHORT).show();
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}