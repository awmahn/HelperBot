package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HardwareKeyMouseActivity extends AppCompatActivity {
    private questions mQuestion;
    private Button mNoButton;
    private Button mYesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware_key_mouse);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");


        mNoButton = (Button) findViewById(R.id.deviceSeatedNo);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HardwareKeyMouseActivity.this, "Try to connect the cable firmly, and check to see if the problem still exists.", Toast.LENGTH_LONG).show();
            }
        });

        mYesButton = (Button) findViewById(R.id.deviceSeatedYes);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HardwareKeyMouseActivity.this, "Consider trying the 'Hardware' problem solver, and/or consult a professional.", Toast.LENGTH_LONG).show();
            }
        });




    }
}
