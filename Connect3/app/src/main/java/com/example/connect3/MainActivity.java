package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int[][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    boolean gameActive = true;
    public void dropIn(View view){
        ImageView counter = (ImageView) view;
        int playerState = Integer.parseInt(counter.getTag().toString());
        if (gameState[playerState] == 2 && gameActive) {
            gameState[playerState] = activePlayer;
            counter.setTranslationY(-1500);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
            counter.animate().translationYBy(1500).setDuration(400);
            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {
                    String message = "";
                    gameActive = false;
                    if (activePlayer == 1) {
                        message = "Yellow Win!";
                    } else {
                        message = "Red Win!";
                    }
                    Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

                    Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
                    TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

                    winnerTextView.setText(message);
                    winnerTextView.setVisibility(view.VISIBLE);
                    playAgainButton.setVisibility((view.VISIBLE));
                }
            }
        }
    }

    public void playAgain(View view){
        Button playAgainButton = (Button) findViewById(R.id.playAgainButton);
        TextView winnerTextView = (TextView) findViewById(R.id.winnerTextView);

        winnerTextView.setVisibility(view.INVISIBLE);
        playAgainButton.setVisibility((view.INVISIBLE));

        GridLayout myGridView = (GridLayout) findViewById(R.id.gridLayout);
        for(int i = 0; i < myGridView.getChildCount(); i++){
            ImageView counter = (ImageView) myGridView.getChildAt(i);
            counter.setImageDrawable(null);
        }
        activePlayer = 0;
        for (int i =0; i < gameState.length; i++){
            gameState[i] = 2;
        }
        gameActive = true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}