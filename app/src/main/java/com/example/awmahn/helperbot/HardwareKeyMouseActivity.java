package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HardwareKeyMouseActivity extends AppCompatActivity {
    // Initialise variables
    private questions mQuestion;
    private Button mNoButton;
    private Button mYesButton;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware_key_mouse);

        // Get question object from the intent
        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // If the button is pressed remind the user to check the connectors, connections, and wires
        mNoButton = (Button) findViewById(R.id.deviceSeatedNo);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HardwareKeyMouseActivity.this, "Try to connect the cable firmly, and check to see if the problem still exists.", Toast.LENGTH_LONG).show();
            }
        });

        // If the button is pressed ask the user to go back to the hardware problem solver or go consult a professional
        mYesButton = (Button) findViewById(R.id.deviceSeatedYes);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HardwareKeyMouseActivity.this, "Consider trying the 'Hardware' problem solver, and/or consult a professional.", Toast.LENGTH_LONG).show();
            }
        });

        // Go back to prior activity
        mBackButton = (Button) findViewById(R.id.keyboardGoBackButton);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);

                i.setClass(HardwareKeyMouseActivity.this, HardwareProblemType.class);

                startActivity(i);
                finish();
            }
        });



    }
}
