package com.example.awmahn.helperbot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OSForAntivirusActivity extends AppCompatActivity {
    private questions mQuestion;
    private Button mContinueButton;
    private Button mBackButton;
    dbHandler mdbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os_for_antivirus);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        mContinueButton = (Button) findViewById(R.id.os_For_Antivirus_Continue_Button);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText osEditText = (EditText) findViewById(R.id.os_For_Antivirus_EditText);
                String os = osEditText.getText().toString();
                mQuestion.setTraditionalSearch("antivirus for " + os);
                Uri uri = Uri.parse(mQuestion.generateSearchURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                //save to database

                //open database
                mdbHandler = new dbHandler(getApplicationContext(), null);

                // build search object to add to database
                searchDB search = new searchDB();
                search.set_name(mQuestion.getName());
                search.set_url(mQuestion.generateSearchURL());

                //add search to database
                mdbHandler.addSearch(search);


                //close database
                mdbHandler.close();


                startActivity(intent);
                finish();
            }
        });



        mBackButton = (Button) findViewById(R.id.os_For_Antivirus_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(OSForAntivirusActivity.this, GetAntivirusActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}
