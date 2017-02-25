package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HardwareKeyMouseActivity extends AppCompatActivity {
    private questions mQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware_key_mouse);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");
    }
}
