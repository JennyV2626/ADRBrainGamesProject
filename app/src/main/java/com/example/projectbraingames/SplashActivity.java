package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {
    android.widget.TextView countdown;
    public int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        countdown = (android.widget.TextView)findViewById(R.id.countdown);

        new CountDownTimer(10000, 1000){
            public void onTick(long millisUntilFinished){
                countdown.setText(String.valueOf(counter));
                counter--;
            }
            public  void onFinish(){
                countdown.setText("GO!!");
            }
        }.start();

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        android.content.Intent intent = new android.content.Intent(SplashActivity.this, WordNotColorGame.class);
                        startActivity(intent);
                        finish();
                    }

                }, 4000
        );


    }
}