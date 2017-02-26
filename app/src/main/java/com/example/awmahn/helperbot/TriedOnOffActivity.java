package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TriedOnOffActivity extends AppCompatActivity {
    private questions mQuestion;
    private Button mYesButton;
    private Button mNoButton;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tried_on_off);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // User has rebooted their device
        mYesButton = (Button) findViewById(R.id.tried_On_Off_Yes_Button);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(TriedOnOffActivity.this, IsItAVirusActivity.class);
                startActivity(i);
                finish();
            }
        });

        // User has not restarted their device
        mNoButton = (Button) findViewById(R.id.tried_On_Off_No_Button);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TriedOnOffActivity.this, "Please restart the device", Toast.LENGTH_LONG).show(); // Tell user to reboot!
            }
        });

        // Go back
        mBackButton = (Button) findViewById(R.id.tried_On_Off_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(TriedOnOffActivity.this, HardwareProblemType.class);
                startActivity(i);
                finish();
            }
        });

    }
}
