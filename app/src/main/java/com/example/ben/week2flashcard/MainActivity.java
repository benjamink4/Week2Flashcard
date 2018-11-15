package com.example.ben.week2flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;


public class MainActivity extends AppCompatActivity {
    FlashcardDatabase flashcardDatabase;
    List<Flashcard> allFlashcards;
    int currentCardDisplayedIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flashcardDatabase=new FlashcardDatabase(getApplicationContext());
        allFlashcards=flashcardDatabase.getAllCards();
        if(allFlashcards!=null && allFlashcards.size()>0){
            ((TextView)findViewById(R.id.flashcard_question)).setText(allFlashcards.get(0).getQuestion());
            ((TextView)findViewById(R.id.flashcard_answer)).setText(allFlashcards.get(0).getAnswer());
            /*
            ((TextView)findViewById(R.id.WrongChoice1)).setText(allFlashcards.get(0).getWrongAnswer1());
            ((TextView)findViewById(R.id.WrongChoice2)).setText(allFlashcards.get(0).getWrongAnswer2());*/


        }

        if(allFlashcards.size()==0){
            ((TextView)findViewById(R.id.flashcard_question)).setText("You need to add a question");

        }
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
        });*/


        findViewById(R.id.plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddCard.class);
                MainActivity.this.startActivityForResult(intent, 100);
            }
        });


        findViewById(R.id.edit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCard.class);
                intent.putExtra("stringKey1", ((TextView)findViewById(R.id.flashcard_question)).getText());
                intent.putExtra("stringKey2",((TextView)findViewById(R.id.flashcard_answer)).getText());
                intent.putExtra("Choice1", ((TextView)findViewById(R.id.Choice1)).getText());

                intent.putExtra("correct",((TextView)findViewById(R.id.flashcard_answer)).getText());
                intent.putExtra("Choice2",((TextView)findViewById(R.id.LastChoice)).getText());
                MainActivity.this.startActivityForResult(intent, 100);


            }
        });


        findViewById(R.id.next).setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                currentCardDisplayedIndex++;
                if(currentCardDisplayedIndex>allFlashcards.size()-1){
                    currentCardDisplayedIndex=0;
                }

                if(allFlashcards.size()>0){

                ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                ((TextView) findViewById(R.id.flashcard_answer)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());}

                if(((TextView)findViewById(R.id.flashcard_answer)).VISIBLE==View.VISIBLE){
                    findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                    findViewById(R.id.flashcard_answer).setVisibility(View.GONE);

                }


            }
        });
/*
        findViewById(R.id.Delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allFlashcards.size() > 0) {
                    flashcardDatabase.deleteCard(((TextView) findViewById(R.id.flashcard_question)).getText().toString());


                    if (allFlashcards.size() > 1) {
                        if (currentCardDisplayedIndex > allFlashcards.size() - 1) {
                            currentCardDisplayedIndex = 0;
                        } else {

                            currentCardDisplayedIndex++;
                        }


                        ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(currentCardDisplayedIndex).getQuestion());
                        ((TextView) findViewById(R.id.flashcard_answer)).setText(allFlashcards.get(currentCardDisplayedIndex).getAnswer());
                    }
                    if (allFlashcards.size() <= 1) {
                        ((TextView) findViewById(R.id.flashcard_question)).setText("You need to add a question");

                    }


                }
            }


        });*/



    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){


        if(requestCode==10){
            String string1=data.getExtras().getString("stringKey1");
            String string2=data.getExtras().getString("stringKey2");
            /*
            String c1=data.getExtras().getString("Choice1");

            String c2=data.getExtras().getString("Choice2");
            */
            ((EditText)findViewById(R.id.Question)).setText(string1);
            ((EditText)findViewById(R.id.Answer)).setText(string2);
            /*
            ((EditText)findViewById(R.id.WrongChoice1)).setText(c1);

            ((EditText)findViewById(R.id.WrongChoice2)).setText(c2);
            */

        }
        if(requestCode==100){
            String string1=data.getExtras().getString("String1");
            String string2=data.getExtras().getString("String2");
            /*
            String Wrong1=data.getExtras().getString("Wrong1key");
            String Wrong2=data.getExtras().getString("Wrong2key");*/

            ((TextView)findViewById(R.id.flashcard_question)).setText(string1);
            ((TextView)findViewById(R.id.flashcard_answer)).setText(string2);
            /*
            ((TextView)findViewById(R.id.Choice1)).setText(Wrong1);
            ((TextView)findViewById(R.id.CorrectChoice)).setText(string2);
            ((TextView)findViewById(R.id.LastChoice)).setText(Wrong2);
            */


            flashcardDatabase.insertCard(new Flashcard(string1,string2));
            allFlashcards=flashcardDatabase.getAllCards();







        }
    }


}
