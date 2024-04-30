package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
//                        Intent intent = new Intent(this, ColorNotWordGame.class);
//                        startActivity(intent);
                        android.content.Intent intent = new android.content.Intent(SplashActivity.this, ColorNotWordGame.class);
                        startActivity(intent);
                        finish();
                    }

                }, 2000
        );
    }
}