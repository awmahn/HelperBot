package com.example.awmahn.helperbot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ScreenTurnsColorSearchActivity extends AppCompatActivity {
    private questions mQuestion;
    private Button mWhiteButton;
    private Button mBlackButton;
    private Button mBlueButton;
    private EditText mProgramName;
    private Button mBackButton;
    dbHandler mdbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_turns_color_search);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        mProgramName = (EditText) findViewById(R.id.screen_Turns_Color_EditText);
        if (mQuestion.getTraditionalSearch().equals("")) {
            //do nothing
        }
        else {
            mProgramName.setText(mQuestion.getTraditionalSearch());
        }


        mWhiteButton = (Button) findViewById(R.id.screen_Turns_Color_White_Button);
        mWhiteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestion.setTraditionalSearch(mProgramName.getText().toString() + " white screen");
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

        mBlackButton = (Button) findViewById(R.id.screen_Turns_Color_Black_Button);
        mBlackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestion.setTraditionalSearch(mProgramName.getText().toString() + " black screen");
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

        mBlueButton = (Button) findViewById(R.id.screen_Turns_Color_Blue_Button);
        mBlueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestion.setTraditionalSearch(mProgramName.getText().toString() + " blue screen");
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


        mBackButton = (Button) findViewById(R.id.screen_Turns_Color_Back_Button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);

                i.setClass(ScreenTurnsColorSearchActivity.this, HowProgramMalfunctioningActivity.class);


                startActivity(i);
                finish();
            }
        });

    }
}
