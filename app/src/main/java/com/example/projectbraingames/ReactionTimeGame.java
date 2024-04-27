package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ReactionTimeGame extends AppCompatActivity {
    android.widget.ImageButton backButton;
    android.widget.Button mainButton;
    android.widget.RelativeLayout view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_time);

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
                //myTimer.cancel();
                //timeElapsed.stop();
                openGamePage();
            }
        });
    }

    public void setBackgroundColor(){
        Random random = new Random();
        int randomNum = random.nextInt(6);
        if(randomNum == 0){
            //view.setBackgroundColor(Color.pink1);
        }


    }
        public void startReactionTimer(){
        Timer greenTimer = new Timer();
        greenTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        }, 1000, 1000);

    }
//    public void checkColor(){
//        if(isGreen){
//            textFeedback.setText("WHOOOHOO! You reacted in ");
//        } else if(!isGreen){
//            textFeedback.setText("");
//        }
   // }

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