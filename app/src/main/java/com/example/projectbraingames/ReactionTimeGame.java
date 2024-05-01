package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ReactionTimeGame extends AppCompatActivity {
    android.widget.ImageButton backButton;
    android.widget.Button mainButton;
    android.widget.ImageView imageView;
    android.widget.TextView timerText;

    private final String greenAlert = "!! CLICK !!   !! IT'S GREEN !!";
    public int currentNum;
    public int count;
    public boolean isGreen;

    android.widget.Chronometer chronometer;
    Handler handler;
    long tMilliSec, tStart, tBuff, tUpdate = 0L;
    int sec, min, milliSec;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_time);

        currentNum = 10;
        count = 0;
        isGreen = false;
        imageView = findViewById(R.id.imgView);


        Timer timer = new Timer();
        MyTimer colorTimer = new MyTimer();
        timer.schedule(colorTimer, 0, 100 + (int)(Math.random() * 3000));

        if(isGreen){
            colorTimer.cancel();
            timer.cancel();
        }

        chronometer = (android.widget.Chronometer)findViewById(R.id.chronometer);

        handler = new Handler();


        mainButton = (android.widget.Button) findViewById(R.id.centralButton);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isGreen){
                    tBuff += tMilliSec;
                    handler.removeCallbacks(runnable);
                    chronometer.stop();
                }
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
                    if(!isGreen){
                        getRandomBGColor();
                    }
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
            if (randomNum == 3 && count > 6) {
                imageView.setBackgroundResource(R.color.green1);
                mainButton.setText(greenAlert);
                count = 100;
                isGreen = true;
                tStart = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
                chronometer.start();
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


    public Runnable runnable = new Runnable() {
        @SuppressLint("SetTextI18n")
        @Override
        public void run() {
            tMilliSec = SystemClock.uptimeMillis() - tStart;
            tUpdate = tBuff + tMilliSec;
            sec = (int)(tUpdate/1000);
            min = sec/60;
            sec = sec%60;
            milliSec = (int)(tUpdate%100);
            if(sec < 10){
                chronometer.setText("0" + min + ":0" + sec + ":" + milliSec);
            } else if(sec > 10){
                chronometer.setText("0" + min + ":" + sec + ":" + milliSec);
            }
            handler.postDelayed(this, 60);
        }
    };

    public void openGamePage(){
        android.content.Intent intent = new android.content.Intent(this, GamePage.class);
        startActivity(intent);
    }

}