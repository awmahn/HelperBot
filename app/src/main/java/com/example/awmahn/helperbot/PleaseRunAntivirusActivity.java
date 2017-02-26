package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PleaseRunAntivirusActivity extends AppCompatActivity {
    private questions mQuestion;
    private Button mContinueButton;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_please_run_antivirus);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // Continue user to antivirus activity
        mContinueButton = (Button) findViewById(R.id.please_Run_Antivirus_Continue_Button);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.putExtra("activityBefore", "PleaseRunAntivirusActivity");
                i.setClass(PleaseRunAntivirusActivity.this, DidDetectVirusActivity.class);
                startActivity(i);
                finish();
            }
        });

        // Go back
        mBackButton = (Button) findViewById(R.id.please_Run_Antivirus_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(PleaseRunAntivirusActivity.this, DoHaveAntivirusActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
