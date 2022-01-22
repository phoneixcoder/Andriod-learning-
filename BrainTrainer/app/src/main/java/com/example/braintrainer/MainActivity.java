package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button goButton;
    TextView sumTextView;
    ArrayList<Integer> answers = new ArrayList<Integer>();
    int locationOfCorrectAnswer;
    TextView resultTextView;
    int score = 0;
    int numberOfQuestion = 0;
    TextView scoreTextView;
    Button button0;
    Button button1;
    Button button2;
    Button button3;
    TextView timerTextView;
    Button playAgainButton;
    ConstraintLayout constraintLayout;

    @SuppressLint("SetTextI18n")
    public void playAgain(View view){
        score = 0;
        numberOfQuestion = 0;
        timerTextView.setText("30s");
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestion));
        button0.setEnabled(true);
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        resultTextView.setText("");
        newQuestion();
        playAgainButton.setVisibility(View.INVISIBLE);
        new CountDownTimer(30100, 1000){

            @Override
            public void onTick(long l) {
                timerTextView.setText(String.valueOf(l/1000) + "s");
            }

            @Override
            public void onFinish() {
                resultTextView.setText("Done!");
                playAgainButton.setVisibility(View.VISIBLE);
                button0.setEnabled(false);
                button1.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.dj);
                mediaPlayer.start();
            }
        }.start();

    }

    @SuppressLint("SetTextI18n")
    public void chooseAnswer(View view){
        if (Integer.toString(locationOfCorrectAnswer).equals(view.getTag().toString())){
            Log.i("Correct", "You got it!");
            resultTextView.setText("Correct :)");
            score++;
        }else{
            Log.i("Incorrect", "You didn't get it!");
            resultTextView.setText("Wrong :(");

        }
        numberOfQuestion++;
        scoreTextView.setText(Integer.toString(score) + "/" + Integer.toString(numberOfQuestion));
        newQuestion();
    }

    public void start(View view){
        goButton.setVisibility(View.INVISIBLE);
        playAgain(findViewById(R.id.timerTextView));
        constraintLayout.setVisibility(View.VISIBLE);
    }

    @SuppressLint("SetTextI18n")
    public void newQuestion(){
        Random rand = new Random();
        int a = rand.nextInt(41);
        int b = rand.nextInt(41);

        sumTextView.setText(Integer.toString(a)+ " + " + Integer.toString(b));

        locationOfCorrectAnswer = rand.nextInt(4);

        answers.clear();

        for (int i = 0; i < 4; i++){
            if (i == locationOfCorrectAnswer){
                answers.add(a+b);
            }else{
                int wrongAnswer = rand.nextInt(41);
                while (wrongAnswer == a + b){
                    wrongAnswer = rand.nextInt(41);
                }
                answers.add(wrongAnswer);
            }
        }

        button0.setText(Integer.toString(answers.get(0)));
        button1.setText(Integer.toString(answers.get(1)));
        button2.setText(Integer.toString(answers.get(2)));
        button3.setText(Integer.toString(answers.get(3)));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sumTextView = findViewById(R.id.sumTextView);

        button0 = findViewById(R.id.button1);
        button1 = findViewById(R.id.button2);
        button2 = findViewById(R.id.button3);
        button3 = findViewById(R.id.button4);

        goButton = findViewById(R.id.goButton);
        resultTextView  = findViewById(R.id.resultTextView);
        scoreTextView = findViewById(R.id.scoreTextView);
        timerTextView = findViewById(R.id.timerTextView);
        playAgainButton = findViewById(R.id.playAgainButton);
        constraintLayout = findViewById(R.id.constraintLayout);

        newQuestion();
        goButton.setVisibility(View.VISIBLE);
        constraintLayout.setVisibility(View.INVISIBLE);
        resultTextView.setText("");
    }
}