package com.example.awmahn.helperbot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OtherSearchActivity extends AppCompatActivity {
    private questions mQuestion;
    private Button mContinueButton;
    private EditText mProgramName;
    private Button mBackButton;
    dbHandler mdbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_search);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        mProgramName = (EditText) findViewById(R.id.other_Search_EditText);
        if (mQuestion.getTraditionalSearch().equals("")) {
            // Do nothing if the search is empty
        }
        else {
            mProgramName.setText(mQuestion.getTraditionalSearch());
        }

        // Do the search
        mContinueButton = (Button) findViewById(R.id.other_Search_Continue_Button);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestion.setTraditionalSearch(mProgramName.getText().toString());
                Uri uri = Uri.parse(mQuestion.generateSearchURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                // Save to database

                // Open database
                mdbHandler = new dbHandler(getApplicationContext(), null);

                // Build search object to add to database
                searchDB search = new searchDB();
                search.set_name(mQuestion.getName());
                search.set_url(mQuestion.generateSearchURL());

                // Add search to database
                mdbHandler.addSearch(search);


                // Close database
                mdbHandler.close();


                startActivity(intent);
                finish();
            }
        });


        // Go back to prior activity
        mBackButton = (Button) findViewById(R.id.other_Search_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);

                i.setClass(OtherSearchActivity.this, HowProgramMalfunctioningActivity.class);


                startActivity(i);
                finish();
            }
        });

    }
}
