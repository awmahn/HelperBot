package com.example.awmahn.helperbot;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class HardwareProblemType extends AppCompatActivity {
    private questions mQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware_problem_type);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");
    }
}
