package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HaveRunAntivirusActivity extends AppCompatActivity {
    private questions mQuestion;
    private Button mYesButton;
    private Button mNoButton;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_have_run_antivirus);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

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
