package com.example.projectbraingames;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TicTacToeGame extends AppCompatActivity implements View.OnClickListener {
    boolean playerOneActive;
    private TextView playerOneScore, playerTwoScore, playerStatus;
    private Button[] buttons = new Button[9];
    private Button playagain;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6},
            {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};
    int rounds;
    private int playerOneScoreCount, playerTwoScoreCount;

    android.widget.ImageView player1turn;
    android.widget.ImageView player2turn;

    android.widget.ImageButton backButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_game);

        player1turn = (android.widget.ImageView)findViewById(R.id.player1Turn);
        player2turn = (android.widget.ImageView)findViewById(R.id.player2Turn);


        playerOneScore = findViewById(R.id.score_Player1);
        playerTwoScore = findViewById(R.id.score_Player2);
        playerStatus = findViewById(R.id.textStatus);

        playagain = findViewById(R.id.btn_play_again);
        buttons[0] = findViewById(R.id.btn0);
        buttons[1] = findViewById(R.id.btn1);
        buttons[2] = findViewById(R.id.btn2);
        buttons[3] = findViewById(R.id.btn3);
        buttons[4] = findViewById(R.id.btn4);
        buttons[5] = findViewById(R.id.btn5);
        buttons[6] = findViewById(R.id.btn6);
        buttons[7] = findViewById(R.id.btn7);
        buttons[8] = findViewById(R.id.btn8);
        for(int i=0; i<buttons.length; i++) {
            buttons[i].setOnClickListener(this);
        }
        playerOneScoreCount = 0;
        playerTwoScoreCount = 0;
        playerOneActive = true;
        rounds = 0;

        backButton = (android.widget.ImageButton)findViewById(R.id.backToGames);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGamePage();
            }
        });
    }

    @Override
    public void onClick(View view)
    {
        if(!((Button)view).getText().toString().equals(""))
        {
            return;
        }
        else if(checkWinner())
        {
            return;
        }
        String buttonID  = view.getResources().getResourceEntryName(view.getId());
        int gameStatePointer = Integer.parseInt(buttonID.substring(buttonID.length()-1,buttonID.length()));
        if(playerOneActive)
        {
            ((Button)view).setText("X");
            ((Button)view).setTextColor(Color.parseColor("#115592"));
            gameState[gameStatePointer] = 0;
            player2turn.setBackgroundResource(R.drawable.thinkingbrain);
            player1turn.setBackgroundResource(R.drawable.thinkingbrain2);

        }
        else
        {
            ((Button)view).setText("O");
            ((Button)view).setTextColor(Color.parseColor("#990000"));
            gameState[gameStatePointer] = 1;
            player1turn.setBackgroundResource(R.drawable.thinkingbrain);
            player2turn.setBackgroundResource(R.drawable.thinkingbrain2);
        }
        rounds++;
        if(checkWinner())
        {
            if(playerOneActive)
            {
                playerOneScoreCount++;
                updatePlayerScore();
                playerStatus.setText("TEAM X has won!");
                player1turn.setBackgroundResource(R.drawable.winnerbrain);
                player2turn.setBackgroundResource(R.drawable.sadbrain);
            } else {
                playerTwoScoreCount++;
                updatePlayerScore();
                playerStatus.setText("TEAM O has won!");
                player2turn.setBackgroundResource(R.drawable.winnerbrain);
                player1turn.setBackgroundResource(R.drawable.sadbrain);
            }
        }
        else if(rounds==9)
        {
            playerStatus.setText("DRAW!");
            player2turn.setBackgroundResource(R.drawable.waitbrain);
            player1turn.setBackgroundResource(R.drawable.waitbrain);
        }
        else
        {
            playerOneActive = !playerOneActive;
        }


        playagain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                playAgain();
            }
        });

    }

    private boolean checkWinner()
    {
        boolean winnerResults  = false;
        for (int[] winningPositions: winningPositions)
        {
            if(gameState[winningPositions[0]]==gameState[winningPositions[1]]&&
                    gameState[winningPositions[1]]==gameState[winningPositions[2]] &&
                    gameState[winningPositions[0]]!=2)
            {
                winnerResults = true;
            }
        }
        return winnerResults;
    }

    private void playAgain()
    {
        rounds = 0;
        playerOneActive = true;
        for (int i=0; i<buttons.length; i++)
        {
            gameState[i] = 2;
            buttons[i].setText("");
        }
        playerStatus.setText(". . .");
        player1turn.setBackgroundResource(R.drawable.thinkingbrain);
        player2turn.setBackgroundResource(R.drawable.thinkingbrain2);
    }

    private void updatePlayerScore()
    {
        playerOneScore.setText(Integer.toString(playerOneScoreCount));
        playerTwoScore.setText(Integer.toString(playerTwoScoreCount));
    }

    public void openGamePage(){
        android.content.Intent intent = new android.content.Intent(this, GamePage.class);
        startActivity(intent);
    }
}