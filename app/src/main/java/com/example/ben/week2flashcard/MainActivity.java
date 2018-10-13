package com.example.ben.week2flashcard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_question).setVisibility(View.GONE);
            }
        });

        findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.GONE);
            }
        });

        findViewById(R.id.Choice1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.Choice1).setBackgroundColor(Color.parseColor("#FF0000"));
                findViewById(R.id.CorrectChoice).setBackgroundColor(Color.parseColor("#008000"));
            }
        });

        findViewById(R.id.CorrectChoice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.CorrectChoice).setBackgroundColor(Color.parseColor("#008000"));
            }
        });

        findViewById(R.id.LastChoice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.LastChoice).setBackgroundColor(Color.parseColor("#FF0000"));
                findViewById(R.id.CorrectChoice).setBackgroundColor(Color.parseColor("#008000"));

            }
        });
    }
}
