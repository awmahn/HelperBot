package com.example.awmahn.helperbot;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HardwareProblemType extends AppCompatActivity {
    private questions mQuestion;
    private Button mBackButton;
    private Button mNotTurningOnButton;
    private Button mPeripheralProblemButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware_problem_type);

        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // Device does not turn on
        mNotTurningOnButton = (Button) findViewById(R.id.deviceWillNotTurnOn);
        mNotTurningOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(HardwareProblemType.this, hardwareNotTurningOn.class);
                startActivity(i);
                finish();
            }
        });

        // Peripheral device not working
        mPeripheralProblemButton = (Button) findViewById(R.id.peripheralNotWorking);
        mPeripheralProblemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(HardwareProblemType.this, PeripheralNotWorkingActivity.class);
                startActivity(i);
                finish();
            }
        });

        // Go back
        mBackButton = (Button) findViewById(R.id.hardwareProblemTypeBackButton);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.putExtra("question", mQuestion);
                i.setClass(HardwareProblemType.this, DecisionActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}
