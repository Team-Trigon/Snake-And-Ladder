package com.example.snakeandladder1;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Random;

public class Game extends AppCompatActivity {
    ImageView p1, p2, imageview, loc2, loc;
    Random r;
    Button ro;
    private final Handler handler = new Handler();
    private final int delayMillis = 1000; // 1000 milliseconds = 1 second

    Integer playerTurn = 1, counter = 0;
    TextView display;
    int num;
    int player1 = 1, player2 = 1, winsb = 0, winsg = 0;
    boolean gamestate = true;
    String varImage;
    int[] images = {1, 2, 3, 4, 5, 6};

    String[] snakes = {"img32", "img36", "img48", "img62", "img88", "img95", "img97"};

    String[] posn1 = {"img10", "img06", "img26", "img18", "img24", "img56", "img78"};

    int[] pl1 = {10, 6, 26, 18, 24, 56, 78};

    String[] ladder = {"img04", "img08", "img21", "img28", "img50", "img71", "img86"};

    String[] posn2 = {"img14", "img30", "img42", "img76", "img67", "img92", "img99"};

    int[] pl2 = {14, 30, 42, 76, 67, 92, 99};

    int computer = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);

        ro = findViewById(R.id.roll);
        imageview = findViewById(R.id.white);
        display = findViewById(R.id.dis);
        r = new Random();
    }

    @SuppressLint({"SetTextI18n", "DiscouragedApi"})
    public void rollDice(View v) {
        if (gamestate) {
            num = r.nextInt(6) + 1;
            setDiceImage(num);

            if (playerTurn == 1) {
                player1Turn();
            } else if (playerTurn == 2) {
                computerTurn();
            }
        } else {
            gamestate = true;
            String str = display.getText().toString();
            Intent k = new Intent(Game.this, EndScreen.class);
            k.putExtra("message_key", str);
            startActivity(k);
            finish();
        }
    }

    private void setDiceImage(int num) {
        switch (num) {
            case 1:
                imageview.setImageResource(R.drawable.a);
                break;
            case 2:
                imageview.setImageResource(R.drawable.b);
                break;
            case 3:
                imageview.setImageResource(R.drawable.c);
                break;
            case 4:
                imageview.setImageResource(R.drawable.d);
                break;
            case 5:
                imageview.setImageResource(R.drawable.e);
                break;
            case 6:
                imageview.setImageResource(R.drawable.f);
                break;
        }
    }

    private void player1Turn() {
        varImage = "img01";
        playerTurn = 2;
        if (100 - player1 >= num) {
            if (player1 < 10) {
                varImage = "img" + 0 + player1;
            } else if (player1 >= 100) {
                varImage = "img100";
                display.setText("BLUE WON");
                winsb++;
                gamestate = false;
                display.setBackgroundColor(Color.GREEN);
                display.setTextColor(Color.BLACK);
            } else {
                int temp = player1;
                String d1 = Integer.toString(temp / 10);
                String d2 = Integer.toString(temp % 10);
                varImage = "img" + d1 + d2;
            }

            if (player1 != player2) {
                loc = findViewById(getResources().getIdentifier(varImage, "id", getPackageName()));
                loc.setImageResource(0);
            }
            player1 += num;

            if (player1 < 10) {
                varImage = "img" + 0 + player1;
            } else if (player1 >= 100) {
                varImage = "img100";
                display.setText("BLUE WON");
                gamestate = false;
                display.setBackgroundColor(Color.GREEN);
                display.setTextColor(Color.BLACK);
            } else {
                int temp = player1;
                String d1 = Integer.toString(temp / 10);
                String d2 = Integer.toString(temp % 10);
                varImage = "img" + d1 + d2;
                for (int i = 0; i < snakes.length; i++) {
                    if (varImage.equals(snakes[i])) {
                        varImage = posn1[i];
                        player1 = pl1[i];
                    }
                    if (varImage.equals(ladder[i])) {
                        varImage = posn2[i];
                        player1 = pl2[i];
                    }
                }
            }
            loc = findViewById(getResources().getIdentifier(varImage, "id", getPackageName()));
            loc.setImageResource(R.drawable.p1);
        }

        if (gamestate) {
            display.setText("COMPUTER TURN");
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    computerTurn();
                }
            }, delayMillis);
        }
    }



    private void computerTurn() {
        varImage = "img01";
        playerTurn = 1;

        // Computer rolls the dice
        int computerRoll = r.nextInt(6) + 1;
        setDiceImage(computerRoll);

        if (100 - player2 >= computerRoll) {
            if (player2 < 10) {
                varImage = "img" + 0 + player2;
            } else if (player2 >= 100) {
                varImage = "img100";
                display.setText("COMPUTER WON");
                winsg++;
                gamestate = false;
                display.setBackgroundColor(Color.GREEN);
                display.setTextColor(Color.BLACK);
            } else {
                int temp = player2;
                String d1 = Integer.toString(temp / 10);
                String d2 = Integer.toString(temp % 10);
                varImage = "img" + d1 + d2;
            }

            if (player1 != player2) {
                loc = findViewById(getResources().getIdentifier(varImage, "id", getPackageName()));
                loc.setImageResource(0);
            }
            player2 += computerRoll;

            if (player2 < 10) {
                varImage = "img" + 0 + player2;
            } else if (player2 >= 100) {
                varImage = "img100";
                display.setText("COMPUTER WON");
                gamestate = false;
                display.setBackgroundColor(Color.GREEN);
                display.setTextColor(Color.BLACK);
            } else {
                int temp = player2;
                String d1 = Integer.toString(temp / 10);
                String d2 = Integer.toString(temp % 10);
                varImage = "img" + d1 + d2;

                // Check for snakes/ladders
                for (int i = 0; i < snakes.length; i++) {
                    if (varImage.equals(snakes[i])) {
                        varImage = posn1[i];
                        player2 = pl1[i];
                    }
                    if (varImage.equals(ladder[i])) {
                        varImage = posn2[i];
                        player2 = pl2[i];
                    }
                }
            }

            loc = findViewById(getResources().getIdentifier(varImage, "id", getPackageName()));
            loc.setImageResource(R.drawable.green);

            if (player2 >= 100) {
                display.setText("COMPUTER WON");
                gamestate = false;
                display.setBackgroundColor(Color.GREEN);
                display.setTextColor(Color.BLACK);
            } else {
                display.setText("BLUE TURN");
            }
        }
    }


}
