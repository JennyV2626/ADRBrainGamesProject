package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
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
        setRandomColor();
    }

    public void openGamePage(){
        android.content.Intent intent = new android.content.Intent(this, GamePage.class);
        startActivity(intent);
    }

    @SuppressLint("SetTextI18n")
    public void setRandomColor(){
        randomNum = RANDOM.nextInt(8) + 1;
        if(randomNum == 1){
            button1.setBackgroundColor(Color.RED);
            button1.setText("&#128542;");
        }
        if(randomNum == 2){
            button2.setBackgroundColor(Color.RED);
            button2.setText("&#128542;");
        }
        if(randomNum == 3){
            button3.setBackgroundColor(Color.RED);
            button3.setText("&#128542;");
        }
        if(randomNum == 4){
            button4.setBackgroundColor(Color.RED);
            button4.setText("&#128542;");
        }
        if(randomNum == 5){
            button5.setBackgroundColor(Color.RED);
            button5.setText("&#128542;");
        }
        if(randomNum == 6){
            button6.setBackgroundColor(Color.RED);
            button6.setText("&#128542;");
        }
        if(randomNum == 7){
            button7.setBackgroundColor(Color.RED);
            button7.setText("&#128542;");
        }
        if(randomNum == 8){
            button8.setBackgroundColor(Color.RED);
            button8.setText("&#128542;");
        }
        if(randomNum == 9){
            button9.setBackgroundColor(Color.RED);
            button9.setText("&#128542;");
        }

    }

}