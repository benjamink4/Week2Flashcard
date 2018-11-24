package com.example.ben.week2flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        String s1 = getIntent().getStringExtra("stringKey1");
        String s2 = getIntent().getStringExtra("stringKey2");
        /*
        String s3=getIntent().getStringExtra("Choice1");
        String s5=getIntent().getStringExtra("Choice2");
        */
        ((EditText)findViewById(R.id.Question)).setText(s1);
        ((EditText)findViewById(R.id.Answer)).setText(s2);
        /*
        ((EditText)findViewById(R.id.WrongChoice1)).setText(s3);
        ((EditText)findViewById(R.id.WrongChoice2)).setText(s5);*/


        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCard.this,MainActivity.class);
                AddCard.this.startActivity(intent);
                overridePendingTransition(R.anim.left_in, R.anim.right_in);
            }
        });

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String q=((EditText) findViewById(R.id.Question)).getText().toString();
                String a=((EditText)findViewById(R.id.Answer)).getText().toString();
                String Wc1=((EditText)findViewById(R.id.WrongChoice1)).getText().toString();
                String Wc2=((EditText)findViewById(R.id.WrongChoice2)).getText().toString();

                if(q.equals("") && a.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter a Question and an Answer", Toast.LENGTH_SHORT).show();
                }
                else if(a.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter an Answer", Toast.LENGTH_SHORT).show();
                }
                else if(q.equals("")){
                    Toast.makeText(getApplicationContext(), "Enter a Question", Toast.LENGTH_SHORT).show();


                }
                    else {

                    Intent data = new Intent();
                    data.putExtra("String1", q);
                    data.putExtra("String2", a);
                    data.putExtra("Wrong1key",Wc1);
                    data.putExtra("Wrong2key",Wc2);
                    setResult(RESULT_OK, data);
                    finish();
                }



            }
        });
    }





}