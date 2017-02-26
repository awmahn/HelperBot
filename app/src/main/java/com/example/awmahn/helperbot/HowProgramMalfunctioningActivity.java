package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HowProgramMalfunctioningActivity extends AppCompatActivity {
    // Initialise variables
    private questions mQuestion;
    private Button mNotStartButton;
    private Button mScreenTurnsColorNoButton;
    private Button mOtherButton;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_program_malfunctioning);

        // Get the question object from the intent
        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // If the button is pressed go to the program does not start node and pass the questions object forward
        mNotStartButton = (Button) findViewById(R.id.how_Program_Malfunctioning_Not_Starting_Button);
        mNotStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(HowProgramMalfunctioningActivity.this, NotStartSearchActivity.class);
                startActivity(i);
                finish();
            }
        });

        // If the button is pressed go to the screen turns a color node and pass the questions object forward
        mScreenTurnsColorNoButton = (Button) findViewById(R.id.how_Program_Malfunctioning_Screen_Turns_Color_Button);
        mScreenTurnsColorNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(HowProgramMalfunctioningActivity.this, ScreenTurnsColorSearchActivity.class);
                startActivity(i);
                finish();
            }
        });

        // If the button is pressed go to the other/misc not functioning properly node and pass the questions object forward
        mOtherButton = (Button) findViewById(R.id.how_Program_Malfunctioning_Other_Button);
        mOtherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(HowProgramMalfunctioningActivity.this, OtherSearchActivity.class);
                startActivity(i);
                finish();
            }
        });

        // If the button is pressed go to the are you getting an error code node and pass the questions object forward
        mBackButton = (Button) findViewById(R.id.how_Program_Malfunctioning_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(HowProgramMalfunctioningActivity.this, GettingErrorCodeActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
