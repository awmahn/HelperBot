package com.example.awmahn.helperbot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NotStartSearchActivity extends AppCompatActivity {
    private questions mQuestion;
    private Button mContinueButton;
    private EditText mProgramName;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_not_start_search);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        mProgramName = (EditText) findViewById(R.id.not_Start_Search_EditText);
        if (mQuestion.getTraditionalSearch().equals("")) {
            //do nothing
        }
        else {
            mProgramName.setText(mQuestion.getTraditionalSearch());
        }


        mContinueButton = (Button) findViewById(R.id.not_Start_Search_Continue_Button);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestion.setTraditionalSearch(mProgramName.getText().toString() + " not starting");
                Uri uri = Uri.parse(mQuestion.generateSearchURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                //save to database
                startActivity(intent);
                finish();
            }
        });


        mBackButton = (Button) findViewById(R.id.not_Start_Search_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);

                i.setClass(NotStartSearchActivity.this, HowProgramMalfunctioningActivity.class);


                startActivity(i);
                finish();
            }
        });

    }
}
