package com.example.awmahn.helperbot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HowDoIProblemActivity extends AppCompatActivity {
    // Initialise variables
    private questions mQuestion;
    private Button mContinueButton;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_do_i_problem);

        // Get the question object from the intent
        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // If the button is pressed edit the question object and go to the which program node and pass the questions object forward
        mContinueButton = (Button) findViewById(R.id.how_Do_I_Problem_Continue_Button);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText descriptionEditText = (EditText) findViewById(R.id.how_Do_I_Problem_Description_EditText);
                String description = descriptionEditText.getText().toString();
                mQuestion.setTraditionalSearch("how to " + description);
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(HowDoIProblemActivity.this, HowDoIProgramActivity.class);
                startActivity(i);
                finish();
            }
        });


        // If the button is pressed go to the what is your problem node and pass the questions object forward
        mBackButton = (Button) findViewById(R.id.how_Do_I_Problem_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(HowDoIProblemActivity.this, DecisionActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
