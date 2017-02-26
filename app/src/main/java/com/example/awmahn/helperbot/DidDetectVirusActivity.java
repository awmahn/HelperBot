package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DidDetectVirusActivity extends AppCompatActivity {
    // Initialise variables
    private questions mQuestion;
    private String mActivityBefore;
    private Button mYesButton;
    private Button mNoButton;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_did_detect_virus);

        // Get the question object and which activity called this activity
        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");
        mActivityBefore = (String) i.getSerializableExtra("activityBefore");

        // If the button is pressed go to the name the virus node and pass the questions object forward
        mYesButton = (Button) findViewById(R.id.did_Detect_Virus_Yes_Button);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.putExtra("activityBefore", "DidDetectVirusActivity");
                i.setClass(DidDetectVirusActivity.this, NameVirusActivity.class);
                startActivity(i);
                finish();
            }
        });

        // If the button is pressed go to the have you run a more aggressive virus search node and pass the questions object forward
        mNoButton = (Button) findViewById(R.id.did_Detect_Virus_No_Button);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(DidDetectVirusActivity.this, DidPowerEraseActivity.class);
                startActivity(i);
                finish();
            }
        });

        // If the button is pressed go to the correct node or go to the have you run an antivirus scan page if nothing is there
        // And pass the questions object forward
        mBackButton = (Button) findViewById(R.id.did_Detect_Virus_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);

                if (mActivityBefore != null) {
                    if (mActivityBefore.equals("PleaseRunAntivirusActivity")) {
                        i.setClass(DidDetectVirusActivity.this, PleaseRunAntivirusActivity.class);
                    } else if (mActivityBefore.equals("HaveRunAntivirusActivity")) {
                        i.setClass(DidDetectVirusActivity.this, HaveRunAntivirusActivity.class);
                    } else {
                        i.setClass(DidDetectVirusActivity.this, HaveRunAntivirusActivity.class);
                    }
                }
                else {
                    i.setClass(DidDetectVirusActivity.this, HaveRunAntivirusActivity.class);
                }


                startActivity(i);
                finish();
            }
        });

    }
}
