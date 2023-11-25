package com.example.snakeandladder1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;
import java.util.Random;

public class Game2 extends AppCompatActivity {
    ImageView p1, p2, imageview, loc2, loc;
    Random r;
    Button ro;
    Integer playerTurn = 1, counter = 0;
    TextView display;
    int num;
    int player1 = 1, player2 = 1,winsb=0,winsg=0;
    boolean gamestate = true;
    String varImage;
    int[] images = {
            1, 2, 3, 4, 5, 6
    };

    String[] snakes = {
            "img32", "img36", "img48", "img62", "img88", "img95", "img97"
    };

    String[] posn1 = {
            "img10", "img06", "img26", "img18", "img24", "img56", "img78"
    };

    int[] pl1 = {
            10, 6, 26, 18, 24, 56, 78
    };

    String[] ladder = {
            "img04", "img08", "img21", "img28", "img50", "img71", "img86"
    };

    String[] posn2 = {
            "img14", "img30", "img42", "img76", "img67", "img92", "img99"
    };

    int[] pl2 = {
            14, 30, 42, 76, 67, 92, 99
    };

    @SuppressLint({"MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);


        ro = findViewById(R.id.roll);
        imageview = findViewById(R.id.white);
        display = findViewById(R.id.dis);

//        p1 = findViewById(R.id.play1);
//        p2 = findViewById(R.id.play2);
        r = new Random();


//        ro.setOnClickListener(new View.OnClickListener() {
//
//                        @Override
//                        public void onClick(View view) {
//                            num = r.nextInt(images.length + 1);
//                            if (num == 1) {
//                                imageview.setImageResource(R.drawable.dice1);
//                            } else if (num == 2) {
//                                imageview.setImageResource(R.drawable.dice2);
//                            } else if (num == 3) {
//                                imageview.setImageResource(R.drawable.dice3);
//                            } else if (num == 4) {
//                                imageview.setImageResource(R.drawable.dice4);
//                } else if (num == 5) {
//                    imageview.setImageResource(R.drawable.dice5);
//                } else if (num == 6) {
//                    imageview.setImageResource(R.drawable.dice6);
//                }
//            }
//        });
    }

    @SuppressLint({"SetTextI18n", "DiscouragedApi"})
    public void rollDice(View v) {
        if (gamestate) {
            num = r.nextInt(6) + 1;
            if (num == 1) {
                imageview.setImageResource(R.drawable.a);
            } else if (num == 2) {
                imageview.setImageResource(R.drawable.b);
            } else if (num == 3) {
                imageview.setImageResource(R.drawable.c);
            } else if (num == 4) {
                imageview.setImageResource(R.drawable.d);
            } else if (num == 5) {
                imageview.setImageResource(R.drawable.e);
            } else if (num == 6) {
                imageview.setImageResource(R.drawable.f);
            }
            if (playerTurn == 1) {
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
                        loc = (ImageView) findViewById(getResources().getIdentifier(varImage, "id", getPackageName()));
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
                    loc = (ImageView) findViewById(getResources().getIdentifier(varImage, "id", getPackageName()));
                    loc.setImageResource(R.drawable.p1);
                }
                if (gamestate) {
                    display.setText("GREEN TURN");
                }
            } else if (playerTurn == 2) {
                varImage = "img01";
                playerTurn = 1;
                if (100 - player2 >= num) {
                    if (player2 < 10) {
                        varImage = "img" + 0 + player2;
                    } else if (player2 >= 100) {
                        varImage = "img100";
                        display.setText("GREEN WON");
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
                        loc = (ImageView) findViewById(getResources().getIdentifier(varImage, "id", getPackageName()));
                        loc.setImageResource(0);
                    }
                    player2 += num;

                    if (player2 < 10) {
                        varImage = "img" + 0 + player2;
                    } else if (player2 >= 100) {
                        varImage = "img100";
                        display.setText("GREEN WON");
                        gamestate = false;
                        display.setBackgroundColor(Color.GREEN);
                        display.setTextColor(Color.BLACK);
                    } else {
                        int temp = player2;
                        String d1 = Integer.toString(temp / 10);
                        String d2 = Integer.toString(temp % 10);
                        varImage = "img" + d1 + d2;
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

                    loc = (ImageView) findViewById(getResources().getIdentifier(varImage, "id", getPackageName()));
                    loc.setImageResource(R.drawable.green);
                }
                if (gamestate) {
                    display.setText("BLUE TURN");
                }
            }
        } else {
            gamestate = true;
            String str = display.getText().toString();
            Intent k = new Intent(Game2.this, EndScreen.class);
            k.putExtra("message_key",str);
            startActivity(k);
            finish();
        }
    }
}