package com.example.ben.week2flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
/*
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
        */

        findViewById(R.id.plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddCard.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });




    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if(requestCode==100){
            String string1=data.getExtras().getString("String1");
            String string2=data.getExtras().getString("String2");
            ((TextView)findViewById(R.id.flashcard_question)).setText(string1);
            ((TextView)findViewById(R.id.flashcard_answer)).setText(string2);



        }
    }
}
