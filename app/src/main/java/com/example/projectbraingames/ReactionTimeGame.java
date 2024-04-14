package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ReactionTimeGame extends AppCompatActivity {
    android.widget.ImageButton backButton;
//    android.widget.RelativeLayout layout;
//    android.widget.Button actionButton;
//    android.widget.Chronometer timeElapsed;
//    android.widget.TextView textFeedback;
//    public static final Random RANDOM = new Random();
//    private int randomNum;
//    private int randomTimerDelay;
//    public boolean isGreen;
//    public Timer timer;
//    public TimerTask myTimer;
//    android.widget.ImageView imageView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_time);

//        imageView1 = findViewById(R.id.imageView1);

//        textFeedback = (android.widget.TextView) findViewById(R.id.feedback);
//        layout = (android.widget.RelativeLayout) findViewById(R.id.relativeLayout);
//
//        timer = new Timer();
//        randomTimerDelay = RANDOM.nextInt(10000) + 1000;
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                setBackgroundColor();
//            }
//        }, randomTimerDelay);
//
////        timer = new Timer();
////        MyTimer myTimer = new MyTimer();
////        timer.schedule(myTimer, 1000, 0);
//
//        actionButton = (android.widget.Button) findViewById(R.id.centralButton);
//        actionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //checkColor();
//            }
//        });

        backButton = (android.widget.ImageButton) findViewById(R.id.backToGames);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //myTimer.cancel();
                //timeElapsed.stop();
                openGamePage();
            }
        });
    }

//    public void setBackgroundColor(){
//        randomNum = RANDOM.nextInt(5) + 1;
//        if(randomNum == 1) {
//            layout.setBackgroundResource(R.color.pink);
//            isGreen = false;
//        } else if(randomNum == 2){
//            layout.setBackgroundResource(R.color.yellow);
//            isGreen = false;
//        } else if(randomNum == 3){
//            layout.setBackgroundResource(R.color.green);
//            myTimer.cancel();
//            isGreen = true;
//            startElapsedTime();
//        } else if(randomNum == 4){
//            layout.setBackgroundResource(R.color.blue);
//            isGreen = false;
//        } else if(randomNum == 5){
//            layout.setBackgroundResource(R.color.purple);
//            isGreen = false;
//        }
//    }
//    //    public void startReactionTimer(){
////        Timer greenTimer = new Timer();
////        greenTimer.scheduleAtFixedRate(new TimerTask() {
////            @Override
////            public void run() {
////                runOnUiThread(new Runnable() {
////                    @Override
////                    public void run() {
////
////                    }
////                });
////            }
////        }, 1000, 1000);
////
////    }
//    public void checkColor(){
//        if(isGreen){
//            textFeedback.setText("WHOOOHOO! You reacted in ");
//        } else if(!isGreen){
//            textFeedback.setText("");
//        }
//    }
////    public void openGamePage(){
////        android.content.Intent intent = new android.content.Intent(this, GameActivity.class);
////        startActivity(intent);
////    }
//
//    private class MyTimer extends TimerTask{
//        @Override
//        public void run() {
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    setBackgroundColor();
//                }
//            });
//        }
//    }
//
//    public void startElapsedTime(){
//        Chronometer timeElapsed = (android.widget.Chronometer)findViewById(R.id.elapsedTime);
//        timeElapsed.start();
//        timeElapsed.setFormat("Time Running - %s");
//    }

    public void openGamePage(){
        android.content.Intent intent = new android.content.Intent(this, GamePage.class);
        startActivity(intent);
    }
}