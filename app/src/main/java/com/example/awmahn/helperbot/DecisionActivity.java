package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DecisionActivity extends AppCompatActivity {
    private questions mQuestion;
    private Button mSoftwareProblemButton;
    private Button mBackButton;
    private Button mHardwareProblemButton;
    private EditText mSearchNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decision);



        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        mSearchNameEditText = (EditText) findViewById(R.id.decision_Name_EditText);
        if (mQuestion.getTraditionalSearch().equals("")) {
            //do nothing
        }
        else {
            mSearchNameEditText.setText(mQuestion.getTraditionalSearch());
        }

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

        mBackButton = (Button) findViewById(R.id.decision_back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(DecisionActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

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

    }
}
