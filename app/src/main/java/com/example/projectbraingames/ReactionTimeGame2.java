package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class ReactionTimeGame2 extends AppCompatActivity {
    android.widget.ImageButton backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reaction_time_2);

        backButton = (android.widget.ImageButton) findViewById(R.id.backToGames);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openGamePage();
            }
        });
    }

    public void openGamePage(){
        android.content.Intent intent = new android.content.Intent(this, GamePage.class);
        startActivity(intent);
    }
}