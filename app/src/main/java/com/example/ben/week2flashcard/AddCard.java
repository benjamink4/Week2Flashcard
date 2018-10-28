package com.example.ben.week2flashcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class AddCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);


        findViewById(R.id.cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddCard.this,MainActivity.class);
                AddCard.this.startActivity(intent);
            }
        });

        findViewById(R.id.save).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String q=((EditText) findViewById(R.id.Question)).getText().toString();
                String a=((EditText)findViewById(R.id.Answer)).getText().toString();
                Intent data=new Intent();
                data.putExtra("String1",q);
                data.putExtra("String2",a);
                setResult(RESULT_OK,data);
                finish();



            }
        });
    }
}