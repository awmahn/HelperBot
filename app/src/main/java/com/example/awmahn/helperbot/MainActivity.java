package com.example.awmahn.helperbot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


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
        Uri uri = Uri.parse("http://www.google.com/#q=fish");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

}
