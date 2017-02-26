package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DidPowerEraseActivity extends AppCompatActivity {
    // Initialise variables
    private questions mQuestion;
    private Button mYesButton;
    private Button mNoButton;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_did_power_erase);

        // Get question object from intent
        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // If the button is pressed go to the name the virus node and pass the questions object forward
        mYesButton = (Button) findViewById(R.id.did_Power_Erase_Yes_Button);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.putExtra("activityBefore", "DidPowerEraseActivity");
                i.setClass(DidPowerEraseActivity.this, NameVirusActivity.class);
                startActivity(i);
                finish();
            }
        });

        // If the button is pressed go to the do you want an aggressive backup virus search
        // Node and pass the questions object forward
        mNoButton = (Button) findViewById(R.id.did_Power_Erase_No_Button);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(DidPowerEraseActivity.this, WantPowerEraseActivity.class);
                startActivity(i);
                finish();
            }
        });

        // If the button is pressed go to the have you run a virus scan node and pass the questions object forward
        mBackButton = (Button) findViewById(R.id.did_Power_Erase_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);

                i.setClass(DidPowerEraseActivity.this,DidDetectVirusActivity.class);


                startActivity(i);
                finish();
            }
        });

    }
}
