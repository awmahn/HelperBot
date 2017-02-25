package com.example.awmahn.helperbot;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PeripheralNotWorkingActivity extends AppCompatActivity {
    private questions mQuestion;
    private Button mKeyboardMouseButton;
    //private Button mPrinterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peripheral_not_working);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // Keyboard/mouse/etc. issue
        mKeyboardMouseButton = (Button) findViewById(R.id.hardwareKeyboardMouseButton);
        mKeyboardMouseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(PeripheralNotWorkingActivity.this, HardwareKeyMouseActivity.class);
                startActivity(i);
                finish();
            }
        });



    }
}
