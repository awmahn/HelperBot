package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HaveRunAntivirusActivity extends AppCompatActivity {
    // Initialise variables
    private questions mQuestion;
    private Button mYesButton;
    private Button mNoButton;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_have_run_antivirus);

        // Get the question object from the intent
        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // If the button is pressed go to the was a virus detected node and pass the questions object forward
        mYesButton = (Button) findViewById(R.id.have_Run_Antivirus_Yes_Button);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.putExtra("activityBefore", "HaveRunAntivirusActivity");
                i.setClass(HaveRunAntivirusActivity.this, DidDetectVirusActivity.class);
                startActivity(i);
                finish();
            }
        });

        // If the button is pressed go to the do you have an antivirus node and pass the questions object forward
        mNoButton = (Button) findViewById(R.id.have_Run_Antivirus_No_Button);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(HaveRunAntivirusActivity.this, DoHaveAntivirusActivity.class);
                startActivity(i);
                finish();
            }
        });

        // If the button is pressed go to the is the problem a virus node and pass the questions object forward
        mBackButton = (Button) findViewById(R.id.have_Run_Antivirus_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(HaveRunAntivirusActivity.this, IsItAVirusActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
