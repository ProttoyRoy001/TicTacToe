package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button[][] buttons =  new Button[3][3];
    private boolean player1Turn = true;
    private int roundcount;

    private int player1Point;
    private int player2Point;

    private TextView textViewPlayer1;
    private TextView textViewPlayer2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewPlayer1 = findViewById(R.id.textplayer1);
        textViewPlayer1 = findViewById(R.id.textplayer2);

        for (int i=0;i<3;i++)
        {
            for(int j=0; j<3; j++)
            {
                String buttonID= "button_"+i +j ;
                int resID = getResources().getIdentifier(buttonID,"id",getPackageName());
                buttons[i][j]= findViewById(resID);
                buttons[i][j].setOnClickListener(this);

            }
        }
        Button buttonReset= findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        if (!((Button)v).getText().toString().equals("")){
            return;
        }
        if (player1Turn){
            ((Button)v).setText("X");
        }else {
            ((Button)v).setText("O");
        }
        roundcount++;

        if(checkForWin()){
            if(player1Turn)
            {
                player1Wins();
            }else{
                player2Wins();
            }
        }else if (roundcount == 9){
            draw();
        }else {
            player1Turn = !player1Turn;
        }


    }
    private boolean checkForWin(){
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++)
        {
            for(int j = 0; j<3 ; j++){
                field[i][j]= buttons[i][j].getText().toString();
            }
        }
        for (int i = 0; i < 3; i++)
        {
            if(field[i][0].equals(field[i][1])
            && field[i][0].equals(field[i][2])
            && !field[i][0].equals("")){
                return true;
            }
        }
        for (int i = 0; i < 3; i++)
        {
            if(field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")){
                return true;
            }
        }
        if(field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")){
            return true;
        }
        if(field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("")){
            return true;
        }
        return  false;
    }
    private void player1Wins(){}
    private void player2Wins(){}
    private void draw(){}
}