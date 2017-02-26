package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class hardwareNotTurningOn extends AppCompatActivity {
    // Initialise variables
    private questions mQuestion;
    private Button mNoButton;
    private Button mYesButton;
    //private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware_not_turning_on);

        // Ger the question object from the intent
        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // If user says device IS plugged in, and wont turn on, then they should consult professional
        mYesButton = (Button) findViewById(R.id.notTurnOnYesButton);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(hardwareNotTurningOn.this, "Try different power outlet. If still encountering problems, consult a professional.", Toast.LENGTH_LONG).show();
            }
        });

        // If user says device not plugged in, tell them to plug it in!
        mNoButton = (Button) findViewById(R.id.notTurnOnNoButton);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(hardwareNotTurningOn.this, "Please plug in the device.", Toast.LENGTH_LONG).show();
            }
        });


    }
}
