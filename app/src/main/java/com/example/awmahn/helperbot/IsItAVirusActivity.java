package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class IsItAVirusActivity extends AppCompatActivity {
    private questions mQuestion;
    private Button mYesButton;
    private Button mNoButton;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_it_a_virus);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // Yes, problem is a virus...
        mYesButton = (Button) findViewById(R.id.is_A_Virus_Yes_Button);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(IsItAVirusActivity.this, HaveRunAntivirusActivity.class);
                startActivity(i);
                finish();
            }
        });

        // No, problem is not a virus...
        mNoButton = (Button) findViewById(R.id.is_A_Virus_No_Button);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(IsItAVirusActivity.this, GettingErrorCodeActivity.class);
                startActivity(i);
                finish();
            }
        });

        // Go back to prior activity
        mBackButton = (Button) findViewById(R.id.is_A_Virus_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(IsItAVirusActivity.this, TriedOnOffActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
