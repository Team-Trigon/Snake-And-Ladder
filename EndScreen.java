package com.example.snakeandladder1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {
    TextView msg;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);
        msg=findViewById(R.id.mssg);
        Intent k = getIntent();
        String str = k.getStringExtra("message_key");
        msg.setText(str);
        if(str.equals("GREEN WON"))
        {
            msg.setTextColor(Color.GREEN);
        }
        else{
            msg.setTextColor(Color.BLUE);
        }
    }
    public void restart(View v)
    {
        Intent l = new Intent(EndScreen.this,Game2.class);
        startActivity(l);
        finish();
    }

    public void menuback(View v)
    {
        Intent i7 = new Intent(EndScreen.this,Play.class);
        finish();
        startActivity(i7);

    }
}