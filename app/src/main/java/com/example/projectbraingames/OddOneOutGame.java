package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class OddOneOutGame extends AppCompatActivity {
    public static final Random RANDOM = new Random();
    private int randomNum;
    android.widget.Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    android.widget.ImageButton backButton;
    Timer timer;
    TimerTask timerTask;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_odd_one_out);
        backButton = (android.widget.ImageButton)findViewById(R.id.backToGames);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGamePage();
            }
        });

        timer = new Timer();
        button1 = (android.widget.Button)findViewById(R.id.button1);
        button2 = (android.widget.Button)findViewById(R.id.button2);
        button3 = (android.widget.Button)findViewById(R.id.button3);
        button4 = (android.widget.Button)findViewById(R.id.button4);
        button5 = (android.widget.Button)findViewById(R.id.button5);
        button6 = (android.widget.Button)findViewById(R.id.button6);
        button7 = (android.widget.Button)findViewById(R.id.button7);
        button8 = (android.widget.Button)findViewById(R.id.button8);
        button9 = (android.widget.Button)findViewById(R.id.button9);
    }

    public void openGamePage(){
        android.content.Intent intent = new android.content.Intent(this, GamePage.class);
        startActivity(intent);
    }

    public void setBackgroundColor(){
        randomNum = RANDOM.nextInt(5) + 1;
        if(randomNum == 1) {
            //layout.setBackgroundResource(R.color.pink);
        } else if(randomNum == 2){
            //layout.setBackgroundResource(R.color.yellow);
        } else if(randomNum == 3){
            //layout.setBackgroundResource(R.color.green);
        } else if(randomNum == 4){
            //layout.setBackgroundResource(R.color.blue);
        } else if(randomNum == 5){
            //layout.setBackgroundResource(R.color.purple);
        }
    }

}