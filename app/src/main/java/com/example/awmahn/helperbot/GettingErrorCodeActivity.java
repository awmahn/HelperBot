package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GettingErrorCodeActivity extends AppCompatActivity {
    private questions mQuestion;
    private Button mYesButton;
    private Button mNoButton;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getting_error_code);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        mYesButton = (Button) findViewById(R.id.getting_Error_Code_Yes_Button);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(GettingErrorCodeActivity.this, ObtainErrorCodeActivity.class);
                startActivity(i);
                finish();
            }
        });

        mNoButton = (Button) findViewById(R.id.getting_Error_Code_No_Button);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(GettingErrorCodeActivity.this, HowProgramMalfunctioningActivity.class);
                startActivity(i);
                finish();
            }
        });


        mBackButton = (Button) findViewById(R.id.getting_Error_Code_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(GettingErrorCodeActivity.this, IsItAVirusActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
