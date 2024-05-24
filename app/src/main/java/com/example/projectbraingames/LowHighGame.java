package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import java.util.Random;

public class LowHighGame extends AppCompatActivity {
    android.widget.ImageButton backButton;
    android.widget.Button checkButton;
    android.widget.ImageButton lowButton;
    android.widget.ImageButton highButton;
    android.widget.TextView message;
    android.widget.TextView numberText;

    public static final int upperBound = 100;
    public static final Random RANDOM = new Random();
    Random random;
    int randomNum = 0;
    int newRandomNum = 0;
    private int score = 0;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_low_high);

        random = new Random();
        randomNum = random.nextInt(100) + 1;
        numberText.setText(""+ randomNum);

//        message = (android.widget.TextView) findViewById(R.id.message);
        numberText = (android.widget.TextView)findViewById(R.id.number);

//        lowButton = (android.widget.ImageButton) findViewById(R.id.lowerbutton);
//        lowButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                checkLower();
//            }
//        });
//
//        highButton = (android.widget.ImageButton) findViewById(R.id.higherbutton);
//        highButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                checkHigh();
//            }
//        });

        backButton = (android.widget.ImageButton) findViewById(R.id.backToGames);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGamePage();
            }
        });

        //newGame();
    }

    public void checkHigh(){
//        int n = Integer.parseInt(numberGuessed.getText().toString());
//        numberOfTries++;
//
//        if (n == randomNum){
//            message.setText("Congrats! You guessed the number " + randomNum + " in " + numberOfTries + " tries.");
//        } else if(n > randomNum){
//            message.setText("LOWER");
//        } else if(n < randomNum){
//            message.setText("HIGHER");
//        }
    }

//    public void checkLow(){
//        if ( == randomNum){
//            message.setText("Congrats! You guessed the number " + randomNum + " in " + numberOfTries + " tries.");
//        }
//    }

//    public void newGame(){
//        Random random = new Random();
//        randomNum = random.nextInt(100);
//        numberText.setText(randomNum);
//    }

    public void openGamePage(){
        android.content.Intent intent = new android.content.Intent(this, GamePage.class);
        startActivity(intent);
    }
}