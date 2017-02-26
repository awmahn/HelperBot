package com.example.awmahn.helperbot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameVirusActivity extends AppCompatActivity {
    private questions mQuestion;
    private String mActivityBefore;
    private Button mContinueButton;
    private EditText mVirusName;
    private Button mBackButton;
    dbHandler mdbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_virus);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");
        mActivityBefore = (String) i.getSerializableExtra("activityBefore");
            // Note the activity user just came from

        // Store the name of supposed virus
        mVirusName = (EditText) findViewById(R.id.name_Virus_EditText);
        if (mQuestion.getTraditionalSearch().equals("")) {
            // Do nothing if search empty
        }
        else {
            mVirusName.setText(mQuestion.getTraditionalSearch());
        }

        // Find pertinent info on virus removal
        mContinueButton = (Button) findViewById(R.id.name_Virus_Continue_Button);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestion.setTraditionalSearch(mVirusName.getText().toString() + " virus removal");
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

        // Go back, depending on prior activity
        mBackButton = (Button) findViewById(R.id.name_Virus_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                if (mActivityBefore != null) {
                    if (mActivityBefore.equals("GetAntivirusActivity")) {
                        i.setClass(NameVirusActivity.this, GetAntivirusActivity.class);
                    } else if (mActivityBefore.equals("DidPowerEraseActivity")) {
                        i.setClass(NameVirusActivity.this, DidPowerEraseActivity.class);
                    } else if (mActivityBefore.equals("WantPowerEraseActivity")) {
                        i.setClass(NameVirusActivity.this, WantPowerEraseActivity.class);
                    } else if (mActivityBefore.equals("DidDetectVirusActivity")) {
                        i.setClass(NameVirusActivity.this, DidDetectVirusActivity.class);
                    } else {
                        i.setClass(NameVirusActivity.this, DidDetectVirusActivity.class);
                    }
                }
                else {
                    i.setClass(NameVirusActivity.this, DidDetectVirusActivity.class);
                }

                startActivity(i);
                finish();
            }
        });


    }
}
