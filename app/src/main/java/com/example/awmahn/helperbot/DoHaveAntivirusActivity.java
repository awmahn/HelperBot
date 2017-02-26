package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DoHaveAntivirusActivity extends AppCompatActivity {
    // Initialise variables
    private questions mQuestion;
    private Button mYesButton;
    private Button mNoButton;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_do_have_antivirus);

        // Get question object from the intent
        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // If the button is pressed go to the please run a search with your antivirus node and pass the questions object forward
        mYesButton = (Button) findViewById(R.id.do_Have_Antivirus_Yes_Button);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(DoHaveAntivirusActivity.this, PleaseRunAntivirusActivity.class);
                startActivity(i);
                finish();
            }
        });

        // If the button is pressed go to the do you want to get an antivirus node and pass the questions object forward
        mNoButton = (Button) findViewById(R.id.do_Have_Antivirus_No_Button);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(DoHaveAntivirusActivity.this, GetAntivirusActivity.class);
                startActivity(i);
                finish();
            }
        });

        // If the button is pressed go to the have you run a scan with your antivirus node and pass the questions object forward
        mBackButton = (Button) findViewById(R.id.do_Have_Antivirus_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(DoHaveAntivirusActivity.this, HaveRunAntivirusActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
