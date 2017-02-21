package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DecisionActivity extends AppCompatActivity {
    questions question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);

        Intent i = getIntent();
        question = (questions)i.getSerializableExtra("question");


    }
}
