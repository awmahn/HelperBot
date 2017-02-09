package com.example.awmahn.helperbot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


//test text for push check try 5
public class MainActivity extends AppCompatActivity {
    // This is a test comment...
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

}
