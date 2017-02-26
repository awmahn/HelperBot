package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GettingErrorCodeActivity extends AppCompatActivity {
    // Initialised variabless
    private questions mQuestion;
    private Button mYesButton;
    private Button mNoButton;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_error_code);

        // Get the question object from the intent
        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // If the button is pressed go to the what is the error code node and pass the questions object forward
        mYesButton = (Button) findViewById(R.id.getting_Error_Code_Yes_Button);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(GettingErrorCodeActivity.this, ObtainErrorCodeActivity.class);
                startActivity(i);
                finish();
            }
        });

        // If the button is pressed go to the how is the program malfunctioning node and pass the questions object forward
        mNoButton = (Button) findViewById(R.id.getting_Error_Code_No_Button);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(GettingErrorCodeActivity.this, HowProgramMalfunctioningActivity.class);
                startActivity(i);
                finish();
            }
        });

        // If the button is pressed go to the hardware is the problem a virus and pass the questions object forward
        mBackButton = (Button) findViewById(R.id.getting_Error_Code_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(GettingErrorCodeActivity.this, IsItAVirusActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
