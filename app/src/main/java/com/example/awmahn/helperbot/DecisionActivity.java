package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DecisionActivity extends AppCompatActivity {
    // Set up variables
    private questions mQuestion;
    private Button mSoftwareProblemButton;
    private Button mHowDoIButton;
    private Button mBackButton;
    private Button mHardwareProblemButton;
    private EditText mSearchNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);


        // Retrieve question object from storage in the intent
        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");
        // If for some reason there is an existing name in the question object then show it
        mSearchNameEditText = (EditText) findViewById(R.id.decision_Name_EditText);
        if (mQuestion.getName().equals("")) {
            // Do nothing
        }
        else {
            mSearchNameEditText.setText(mQuestion.getName());
        }
        // If the button is pressed go to the software issue node and pass the question object forward
        mSoftwareProblemButton = (Button) findViewById(R.id.softwareIssueButton);
        mSoftwareProblemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestion.setName(mSearchNameEditText.getText().toString());
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(DecisionActivity.this, TriedOnOffActivity.class);
                startActivity(i);
                finish();
            }
        });
        // If the button is pressed go back to the starting node
        mBackButton = (Button) findViewById(R.id.decision_back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        // If the button is pressed go to the hardware issue node and pass the questions object forward
        mHardwareProblemButton = (Button) findViewById(R.id.hardwareIssueButton);
        mHardwareProblemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestion.setName(mSearchNameEditText.getText().toString());
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(DecisionActivity.this, HardwareProblemType.class);
                startActivity(i);
                finish();
            }
        });

        // If the button is pressed go to the how do I node and pass the questions object forward
        mHowDoIButton = (Button) findViewById(R.id.decision_How_Do_I_Button);
        mHowDoIButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestion.setName(mSearchNameEditText.getText().toString());
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(DecisionActivity.this, HowDoIProblemActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
