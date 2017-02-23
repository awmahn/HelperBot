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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_os_for_antivirus);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        mContinueButton = (Button) findViewById(R.id.do_Have_Antivirus_Yes_Button);
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText osEditText = (EditText) findViewById(R.id.os_For_Antivirus_EditText);
                String os = osEditText.getText().toString();
                mQuestion.setTraditionalSearch("anitvirus for " + os);
                Uri uri = Uri.parse(mQuestion.generateSearchURL());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                //save to database
                startActivity(intent);
                finish();
            }
        });



        mBackButton = (Button) findViewById(R.id.do_Have_Antivirus_Back_Button);
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
