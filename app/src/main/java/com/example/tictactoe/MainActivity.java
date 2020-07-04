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
            (())
        }
    }
}