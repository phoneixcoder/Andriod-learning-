package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void loginFunction(View view){
        EditText userName = (EditText) findViewById(R.id.userName);
        EditText userPassword = (EditText) findViewById(R.id.userPassword);

        Log.i("Info" , "Click!");
        Log.i("Values" , userName.getText().toString());
        Log.i("Values" , userPassword.getText().toString());

        Toast.makeText(this, "Hii there!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}