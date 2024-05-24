package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    android.widget.ImageButton logoButton;
    android.widget.Button aboutUsButton;
    android.widget.Button extrasButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoButton = (android.widget.ImageButton) findViewById(R.id.brainLogo);
        logoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGamePage();
            }
        });

//        extrasButton = (android.widget.Button)findViewById(R.id.infoButton);
//        extrasButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                openExtrasPage();
//            }
//        });


        aboutUsButton = (android.widget.Button) findViewById(R.id.aboutUsButton);
        aboutUsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAboutUsPage();
            }
        });
    }
    public void openGamePage(){
        android.content.Intent intent = new android.content.Intent(this, GamePage.class);
        startActivity(intent);
    }

    public void openExtrasPage(){
        android.content.Intent intent = new android.content.Intent(this, LeftRightPage.class);
        startActivity(intent);
    }


    public void openAboutUsPage(){
        android.content.Intent intent = new android.content.Intent(this, AboutUsPage.class);
        startActivity(intent);
    }
}