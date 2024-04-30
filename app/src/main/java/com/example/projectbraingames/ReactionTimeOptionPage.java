package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

public class ReactionTimeOptionPage extends AppCompatActivity {

    android.widget.ImageButton backButton;
    android.widget.Button gameModeOne;
    android.widget.Button gameModeTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_time_option_page);

        gameModeOne = (android.widget.Button) findViewById(R.id.option1);
        gameModeOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameMode1();
            }
        });

        gameModeTwo = (android.widget.Button) findViewById(R.id.option2);
        gameModeTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameMode2();
            }
        });


        backButton = (android.widget.ImageButton) findViewById(R.id.backToGames);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGamePage();
            }
        });
    }

    public void openGameMode1(){
        android.content.Intent intent = new android.content.Intent(this, ReactionTimeGameOne.class);
        startActivity(intent);
    }

    public void openGameMode2(){
        android.content.Intent intent = new android.content.Intent(this, ReactionTimeGameTwo.class);
        startActivity(intent);
    }


    public void openGamePage(){
        android.content.Intent intent = new android.content.Intent(this, GamePage.class);
        startActivity(intent);
    }
}