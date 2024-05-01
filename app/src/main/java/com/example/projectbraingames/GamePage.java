package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

public class GamePage extends AppCompatActivity {
    android.widget.Button backButton;

    CardView colorNotWordCard;
    CardView reactionTimeCard;

    CardView reactionTime2Card;
    CardView lowHighCard;
    CardView oddOneOutCard;
    CardView ticTacToeCard;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_page);

        backButton = (android.widget.Button) findViewById(R.id.backHome);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMain();
            }
        });

        colorNotWordCard = (CardView) findViewById(R.id.colornotword);
        colorNotWordCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorNotWordGame();
            }
        });

        reactionTimeCard = (CardView) findViewById(R.id.reactiontime);
        reactionTimeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReactionGame();
            }
        });

        reactionTime2Card = (CardView) findViewById(R.id.reactiontime2);
        reactionTime2Card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openReactionGame2();
            }
        });

        lowHighCard = (CardView) findViewById(R.id.lowhigh);
        lowHighCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLowHighGame();
            }
        });


        oddOneOutCard = (CardView) findViewById(R.id.oddoneout);
        oddOneOutCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOddOneOutGame();
            }
        });

        ticTacToeCard = (CardView) findViewById(R.id.tictactoe);
        ticTacToeCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTicTacToeGame();
            }
        });
    }

    public void backToMain(){
        android.content.Intent intent = new android.content.Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openColorNotWordGame(){
        android.content.Intent intent = new android.content.Intent(this, SplashActivity.class);
        startActivity(intent);
    }

    public void openReactionGame(){
        android.content.Intent intent = new android.content.Intent(this, ReactionTimeGame.class);
        startActivity(intent);
    }

    public void openReactionGame2(){
        android.content.Intent intent = new android.content.Intent(this, ReactionTimeGame2.class);
        startActivity(intent);
    }

    public void openLowHighGame(){
        android.content.Intent intent = new android.content.Intent(this, LowHighGame.class);
        startActivity(intent);
    }

    public void openOddOneOutGame(){
        android.content.Intent intent = new android.content.Intent(this, OddOneOutGame.class);
        startActivity(intent);
    }

    public void openTicTacToeGame(){
        android.content.Intent intent = new android.content.Intent(this, TicTacToeGame.class);
        startActivity(intent);
    }

}