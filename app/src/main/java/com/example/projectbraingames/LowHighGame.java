package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class LowHighGame extends AppCompatActivity {
    android.widget.ImageButton backButton;
    android.widget.Button checkButton;
    android.widget.EditText numberGuessed;
    android.widget.TextView message;

    public static final int upperBound = 100;
    public static final Random RANDOM = new Random();
    private int numberToFind;
    private int numberOfTries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_high);

        message = (android.widget.TextView) findViewById(R.id.message);
        numberGuessed = (android.widget.EditText) findViewById(R.id.guessText);


        backButton = (android.widget.ImageButton) findViewById(R.id.backToGames);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGamePage();
            }
        });

        checkButton = (android.widget.Button) findViewById(R.id.checkGuess);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkNumber();
            }
        });

        newGame();
    }
    public void openGamePage(){
        android.content.Intent intent = new android.content.Intent(this, GamePage.class);
        startActivity(intent);
    }

    public void checkNumber(){
        int n = Integer.parseInt(numberGuessed.getText().toString());
        numberOfTries++;

        if (n == numberToFind){
            message.setText("Congrats! You guessed the number " + numberToFind + " in " + numberOfTries + " tries.");
        } else if(n > numberToFind){
            message.setText("LOWER");
        } else if(n < numberToFind){
            message.setText("HIGHER");
        }
    }

    public void newGame(){
        numberToFind = RANDOM.nextInt(upperBound) + 1;
        //message.setText(R.string.start_msg);
        numberGuessed.setText("");
        numberOfTries = 0;
    }
}