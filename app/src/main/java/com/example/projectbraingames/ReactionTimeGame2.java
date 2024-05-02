package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;

import java.util.Timer;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ReactionTimeGame2 extends AppCompatActivity {
    android.widget.ImageButton backButton;

    android.widget.Button mainButton;
    android.widget.Chronometer chronometer;
    Handler handler;
    Timer timer;
    long tMilliSec, tStart, tBuff, tUpdate = 0L;
    int sec, min, milliSec;
    public boolean isSad;

    android.widget.ImageView brainImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_time_2);

        isSad = false;

        brainImage = (android.widget.ImageView)findViewById(R.id.brainEmote);

        chronometer = (android.widget.Chronometer)findViewById(R.id.chronometer);
        handler = new Handler();

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                brainImage.setBackgroundResource(R.drawable.sadbrain);
                isSad = true;
                tStart = SystemClock.uptimeMillis();
                handler.postDelayed(runnable, 0);
                chronometer.start();
            }
        }, 5000 + (int)(Math.random()* 10000));


        mainButton = (android.widget.Button) findViewById(R.id.centralButton);
        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tBuff += tMilliSec;
                handler.removeCallbacks(runnable);
                chronometer.stop();
                }
            }
        );



        backButton = (android.widget.ImageButton) findViewById(R.id.backToGames);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGamePage();
            }
        });
    }


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
            if(sec >= 10){
                chronometer.setText("0" + min + ":" + sec + ":" + milliSec);
            } else{
                chronometer.setText("0" + min + ":0" + sec + ":" + milliSec);
            }
            handler.postDelayed(this, 60);
        }
    };

    public void openGamePage(){
        android.content.Intent intent = new android.content.Intent(this, GamePage.class);
        startActivity(intent);
    }
}