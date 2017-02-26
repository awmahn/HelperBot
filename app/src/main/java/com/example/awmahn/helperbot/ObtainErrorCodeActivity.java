package com.example.awmahn.helperbot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ObtainErrorCodeActivity extends AppCompatActivity {
    private questions mQuestion;
    private Button mContinueButton;
    private Button mBackButton;
    private String mProgram;
    private String mErrorCode;
    private EditText mProgramEditText;
    private EditText mErrorCodeEditText;
    dbHandler mdbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obtain_error_code);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // Perform a search on error code with program name
        mContinueButton = (Button) findViewById(R.id.obtain_Error_Code_Continue_Button);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mErrorCodeEditText = (EditText) findViewById(R.id.obtain_Error_Code_Error_Code_EditText); // Error code
                mProgramEditText = (EditText) findViewById(R.id.obtain_Error_Code_Program_Name_EditText); // Software name
                mErrorCode = mErrorCodeEditText.getText().toString();
                mProgram = mProgramEditText.getText().toString();
                mQuestion.setTraditionalSearch(mProgram + " " + mErrorCode);
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


        // Go back
        mBackButton = (Button) findViewById(R.id.obtain_Error_Code_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(ObtainErrorCodeActivity.this, GettingErrorCodeActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
