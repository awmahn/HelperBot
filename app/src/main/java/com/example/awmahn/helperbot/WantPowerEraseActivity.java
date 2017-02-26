package com.example.awmahn.helperbot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WantPowerEraseActivity extends AppCompatActivity {

    private questions mQuestion;
    private Button mYesButton;
    private Button mNoButton;
    private Button mBackButton;
    dbHandler mdbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_want_power_erase);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // User does want to do Power Eraser, etc.
        mYesButton = (Button) findViewById(R.id.want_Power_Erase_Yes_Button);
        mYesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestion.setTraditionalSearch("Best second opinion antivirus");
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

        // User does not want to do Power Eraser
        mNoButton = (Button) findViewById(R.id.want_Power_Erase_No_Button);
        mNoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.putExtra("activityBefore", "WantPowerErase");
                i.setClass(WantPowerEraseActivity.this, NameVirusActivity.class);
                startActivity(i);
                finish();
            }
        });

        // Go back
        mBackButton = (Button) findViewById(R.id.want_Power_Erase_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);

                i.setClass(WantPowerEraseActivity.this, DidPowerEraseActivity.class);


                startActivity(i);
                finish();
            }
        });

    }
}
