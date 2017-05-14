package com.example.tictac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    Button b00;
    Button b01;
    Button b02;

    Button b20;
    Button b21;
    Button b22;

    Button b10;
    Button b11;
    Button b12;

    Button bReset;

    TextView tvInfo;
    boolean PLAYER_X = true;
    int status[][] = new int[3][3];
    int count = 0;
    String player1,player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String name1 = getIntent().getExtras().getString("NAME1");
        String name2 = getIntent().getExtras().getString("NAME2");

        player1=name1;
        player2=name2;

        //  String name1 = j.getStringExtra("NAME1");
        Toast.makeText(MainActivity.this,"HELLO "+name1+" AND "+name2,
                Toast.LENGTH_SHORT).show();

        initializeBoard();
        b00 = (Button) findViewById(R.id.b00);
        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);

        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);

        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);

        bReset = (Button) findViewById(R.id.bReset);
        tvInfo = (TextView) findViewById(R.id.tvInfo);

        b00.setOnClickListener(this);
        b01.setOnClickListener(this);
        b02.setOnClickListener(this);

        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);

        b20.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);

        bReset.setOnClickListener(this);
    }

    private void setInfo(String text) {
        tvInfo.setText(text);
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                status[i][j] = -1;
    }

    public void onClick(View view) {
        int id = view.getId();
        switch (id) {

            case R.id.b00:
                if (PLAYER_X) {
                    b00.setText("X");
                    status[0][0] = 1;
                } else {
                    b00.setText("0");
                    status[0][0] = 0;
                }
                b00.setEnabled(false);
                break;

            case R.id.b01:
                if (PLAYER_X) {
                    b01.setText("X");
                    status[0][1] = 1;
                } else {
                    b01.setText("0");
                    status[0][1] = 0;
                }
                b01.setEnabled(false);
                break;

            case R.id.b02:
                if (PLAYER_X) {
                    b02.setText("X");
                    status[0][2] = 1;
                } else {
                    b02.setText("0");
                    status[0][2] = 0;
                }
                b02.setEnabled(false);
                break;

            case R.id.b10:
                if (PLAYER_X) {
                    b10.setText("X");
                    status[1][0] = 1;
                } else {
                    b10.setText("0");
                    status[1][0] = 0;
                }
                b10.setEnabled(false);
                break;

            case R.id.b11:
                if (PLAYER_X) {
                    b11.setText("X");
                    status[1][1] = 1;
                } else {
                    b11.setText("0");
                    status[1][1] = 0;
                }
                b11.setEnabled(false);
                break;

            case R.id.b12:
                if (PLAYER_X) {
                    b12.setText("X");
                    status[1][2] = 1;
                } else {
                    b12.setText("0");
                    status[1][2] = 0;
                }
                b12.setEnabled(false);
                break;

            case R.id.b20:
                if (PLAYER_X) {
                    b20.setText("X");
                    status[2][0] = 1;
                } else {
                    b20.setText("0");
                    status[2][0] = 0;
                }
                b20.setEnabled(false);
                break;

            case R.id.b21:
                if (PLAYER_X) {
                    b21.setText("X");
                    status[2][1] = 1;
                } else {
                    b21.setText("0");
                    status[2][1] = 0;
                }
                b21.setEnabled(false);
                break;

            case R.id.b22:
                if (PLAYER_X) {
                    b22.setText("X");
                    status[2][2] = 1;
                } else {
                    b22.setText("0");
                    status[2][2] = 0;
                }
                b22.setEnabled(false);
                break;

            case R.id.bReset:
                break;

            default:
                break;
        }

        if (id == R.id.bReset)
            resetBoard();

        else {
            count++;
            PLAYER_X = !PLAYER_X;
            if (count == 9) {
                result("Game Draw");
            }
            checkWinner();
        }
    }

    private void result(String s) {
        setInfo(s);
        enableAll(false);
    }

    private void checkWinner() {
        // horizontal
        for(int i=0;i<3;i++){
            if(status[i][0] == status[i][1] && status[i][1] == status[i][2]){
                if(status[i][0]==1){
                    result(player1+ " Winner");
                    break;
                }

                else if(status[i][0]==0){
                    result(player2+ " Winner");
                    break;
                }

            }
        }

        // vertical
        for(int i=0;i<3;i++){
            if(status[0][i] == status[1][i] && status[1][i] == status[2][i]){
                if(status[0][i]==1){
                    result(player1+ " Winner");
                    break;
                }

                else if(status[0][i]==0){
                    result(player2+ " Winner");
                    break;
                }

            }
        }

        // diagonal
        if(status[0][0]==status[1][1] && status[1][1]==status[2][2]){
            if(status[0][0]==1){
                result(player1+ " Winner");
            }

            else if(status[0][0]==0){
                result(player2+ " Winner");
            }
        }

        if(status[0][2]==status[1][1] && status[1][1]==status[2][0]){
            if(status[1][1]==1){
                result(player1+ " Winner");
            }

            else if(status[1][1]==0){
                result(player2+ " Winner");
            }
        }

    }

    private void resetBoard() {
        b00.setText("");
        b01.setText("");
        b02.setText("");

        b10.setText("");
        b11.setText("");
        b12.setText("");

        b20.setText("");
        b21.setText("");
        b22.setText("");

        count=0;
        initializeBoard();
        setInfo("PLAY AGAIN..");
        PLAYER_X = true;

        enableAll(true);
    }

    private void enableAll(boolean value){
        b00.setEnabled(value);
        b01.setEnabled(value);
        b02.setEnabled(value);

        b10.setEnabled(value);
        b11.setEnabled(value);
        b12.setEnabled(value);

        b20.setEnabled(value);
        b21.setEnabled(value);
        b22.setEnabled(value);
    }

}
