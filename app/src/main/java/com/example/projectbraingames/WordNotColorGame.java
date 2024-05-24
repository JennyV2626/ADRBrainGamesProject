package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



public class WordNotColorGame extends AppCompatActivity {

    private static final String red = "red";
    private static final String blue = "blue";
    private static final String green = "green";
    private static final String yellow = "yellow";
    private static final String RED_VALUE = "#FF5757";
    private static final String BLUE_VALUE = "#5271FF";
    private static final String GREEN_VALUE = "#7ED957";
    private static final String YELLOW_VALUE = "#FFDE59";

    private TextView txtQuestion = null;
    private android.widget.ImageButton btnRed, btnBlue, btnGreen, btnYellow = null;
    private ProgressBar progressBar = null;
    private Integer score = 0;

    private int bestScore;
    private final Handler handler = new Handler();

    public String color;
    android.widget.ImageButton backButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_not_color);

        txtQuestion = findViewById(R.id.txt_question);

        btnRed = (android.widget.ImageButton)findViewById(R.id.red);
        btnBlue = (android.widget.ImageButton)findViewById(R.id.blue);
        btnGreen = (android.widget.ImageButton)findViewById(R.id.green);
        btnYellow = (android.widget.ImageButton)findViewById(R.id.yellow);

        progressBar = findViewById(R.id.progress_bar);
        progressBar.setProgress(0);

        setQuestion();

        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = "red";
                submitAnswer();
            }
        });

        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = "blue";
                submitAnswer();
            }
        });

        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = "green";
                submitAnswer();
            }
        });

        btnYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                color = "yellow";
                submitAnswer();
            }
        });

        backButton = (android.widget.ImageButton) findViewById(R.id.backToGames);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit();
                openGamePage();
            }
        });

    }

    private void setQuestion() {
        setTimer();
        Map<String, String> colorMap = new HashMap<>();
        colorMap.put(red, RED_VALUE);
        colorMap.put(blue, BLUE_VALUE);
        colorMap.put(green, GREEN_VALUE);
        colorMap.put(yellow, YELLOW_VALUE);

        String question = getRandomColor();
        String questionColor = getRandomColor();

        if(colorMap.containsKey(question) && colorMap.containsKey(questionColor)) {
            txtQuestion.setText(question);
            String questionTextColor = colorMap.get(questionColor);
            txtQuestion.setTextColor(Color.parseColor(questionTextColor));
        }

    }

    private String getRandomColor() {
        List<String> colors = Arrays.asList(red, blue, green, yellow);

        Random random = new Random();
        int randomIndex = random.nextInt(4);
        return colors.get(randomIndex);

    }

    public void submitAnswer() {

        boolean result = txtQuestion.getText().equals(color);

        if(result) {
            // answer is correct
            score += 1;
            setQuestion();
        } else {
            // wrong answer. exit the game
            if(score > bestScore){}
            exit();
        }
    }

    private void exit() {
        handler.removeCallbacksAndMessages(null);
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("score", String.valueOf(score));
        this.startActivity(intent);
    }

    private void setTimer() {
        progressBar.setProgress(0);
        handler.removeCallbacksAndMessages(null);
        final int delay = 1000;
        final int[] counter = {1};

        handler.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        int progress = counter[0] * 20;
                        progressBar.setProgress(progress);

                        if (progress == 100) {
                            exit();
                        }

                        counter[0]++;
                        handler.postDelayed(this, delay);
                    }
                }, delay
        );
    }


    public void openGamePage(){
        android.content.Intent intent = new android.content.Intent(this, GamePage.class);
        startActivity(intent);
    }
}