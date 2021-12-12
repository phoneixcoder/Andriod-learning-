package com.example.checknumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void checkNumber(View view){
        class Number {
            int number;

            public boolean isTriangular(){
                int x = 1;
                int triangularNumber = 1;

                while(triangularNumber < number){
                    x++;
                    triangularNumber = triangularNumber + x;
                }
                if (triangularNumber == number){
                    return true;
                }else{
                    return false;
                }
            }

            public boolean isSquare(){
                double squareRoot = Math.sqrt(number);
                if (squareRoot == Math.floor(squareRoot)){
                    return true;
                }else{
                    return false;
                }
            }
        }

        EditText editText = (EditText) findViewById(R.id.editText);
        Number num = new Number();
        num.number = Integer.parseInt(editText.getText().toString());
        String message;
        if (num.isTriangular()){
            message = "Triangular";
        }else if (num.isSquare()){
            message = "Square";
        }else{
            message = "Nothing";
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}