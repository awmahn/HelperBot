package com.example.awmahn.helperbot;

import android.content.Intent;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class MainActivity extends AppCompatActivity {
    // This is a test comment...
    //

    private final String QUESTION = "QUESTION_PARCELABLE_KEY";

    private Button mLoadSearchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoadSearchButton = (Button) findViewById(R.id.loadSearchButton);
        mLoadSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, QuestionsListActivity.class);
                startActivity(i);
            }
        });

    }

    public void GoogleSearch(View view) {
        EditText googleSearchBox = (EditText) findViewById(R.id.googleSearchBox);
        String search = googleSearchBox.getText().toString();
        questions currentQuestions = new questions();
        currentQuestions.setTraditionalSearch(search);
        Uri uri = Uri.parse(currentQuestions.generateSearchURL());
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void createNewSearch(View view) {
        questions question = new questions();
        Intent i = new Intent();
        i.putExtra("question", question);
        i.setClass(this, DecisionActivity.class);
        startActivity(i);
        //
    }

}
