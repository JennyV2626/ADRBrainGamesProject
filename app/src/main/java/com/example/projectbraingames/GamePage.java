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


        /*
        reactionGameCard = (android.widget.ImageButton) findViewById(R.id.reactiontime);
        reactionGameCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openReactionGame();
            }
        });

/
        lowHighGameButton = (android.widget.ImageButton) findViewById(R.id.lowhigh);
        lowHighGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGuessGame();
            }
        });

        colorGameButton = (android.widget.ImageButton) findViewById(R.id.colornotword);
        colorGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openColorNotWordGame();
            }
        }); */
    }
    public void backToMain(){
        android.content.Intent intent = new android.content.Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void openReactionGame(){
        android.content.Intent intent = new android.content.Intent(this, ReactionTimeGame.class);
        startActivity(intent);
    }

    public void openGuessGame(){
        android.content.Intent intent = new android.content.Intent(this, LowHighGame.class);
        startActivity(intent);
    }

    public void openColorNotWordGame(){
        android.content.Intent intent = new android.content.Intent(this, SplashActivity.class);
        startActivity(intent);
    }
}