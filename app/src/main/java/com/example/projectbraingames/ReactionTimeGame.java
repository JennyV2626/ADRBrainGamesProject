package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ReactionTimeGame extends AppCompatActivity {
    android.widget.ImageButton backButton;
    android.widget.Button mainButton;
    android.widget.ImageView imageView;
    android.widget.TextView timerText;

    private final String isGreen = "!! CLICK !! IT'S GREEN !!";

    public int currentNum;
    public int count;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_time);

        currentNum = 10;
        count = 0;
        imageView = findViewById(R.id.imgView);


        Timer timer = new Timer();
        MyTimer colorTimer = new MyTimer();
        timer.schedule(colorTimer, 0, 1000 + (int)(Math.random() * 4000));

        if(count == 100){
            colorTimer.cancel();
            timer.cancel();
        }

        timerText = (android.widget.TextView)findViewById(R.id.counterTime);


        mainButton = (android.widget.Button) findViewById(R.id.centralButton);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //checkColor();
            }
        });

        backButton = (android.widget.ImageButton) findViewById(R.id.backToGames);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGamePage();
            }
        });
    }

    private class MyTimer extends TimerTask{
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    getRandomBGColor();
                }
            });
        }
    }

    public void getRandomBGColor(){
        Random random = new Random();
        int randomNum = random.nextInt(6);
        if(currentNum != randomNum) {
            if (randomNum == 0) {
                imageView.setBackgroundResource(R.color.pink1);
            }
            if (randomNum == 1) {
                imageView.setBackgroundResource(R.color.orange1);
            }
            if (randomNum == 2) {
                imageView.setBackgroundResource(R.color.yellow1);
            }
            if (randomNum == 3 && count > 3) {
                imageView.setBackgroundResource(R.color.green1);
                mainButton.setText(isGreen);
                count = 100;
            }
            if (randomNum == 4) {
                imageView.setBackgroundResource(R.color.blue1);
            }
            if (randomNum == 5) {
                imageView.setBackgroundResource(R.color.purple1);
            }

            currentNum = randomNum;
            //Counter to ensure green doesn't come too early
            count++;
        }
    }

//    public void checkColor(){
//        if(isGreen){
//            textFeedback.setText("WHOOOHOO! You reacted in ");
//        } else if(!isGreen){
//            textFeedback.setText("");
//        }
   // }


    public void openGamePage(){
        android.content.Intent intent = new android.content.Intent(this, GamePage.class);
        startActivity(intent);
    }

}