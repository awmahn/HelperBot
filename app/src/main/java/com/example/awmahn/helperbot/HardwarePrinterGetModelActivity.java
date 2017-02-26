package com.example.awmahn.helperbot;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HardwarePrinterGetModelActivity extends AppCompatActivity {
    // Initialise variables
    private questions mQuestion;
    private Button mPrinterNotTurningOn;
    private Button mPrinterJams;
    private Button mPrinterStreaks;
    dbHandler mdbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware_printer_get_model);

        // Get the question object from the intent
        Intent i = getIntent();
        mQuestion = (questions)i.getSerializableExtra("question");

        // If the user says printer does not turn on ...
        mPrinterNotTurningOn = (Button) findViewById(R.id.printerNotOnButton);
        mPrinterNotTurningOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText printerModelEditText = (EditText) findViewById(R.id.editTextPrinterModel);
                String printerModel = printerModelEditText.getText().toString();
                mQuestion.setTraditionalSearch(mQuestion.getTraditionalSearch() + " " + printerModel + " not turning on");
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

        // If the user says printer frequently jams...
        mPrinterJams = (Button) findViewById(R.id.printerJamsButton);
        mPrinterJams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText printerModelEditText = (EditText) findViewById(R.id.editTextPrinterModel);
                String printerModel = printerModelEditText.getText().toString();
                mQuestion.setTraditionalSearch(mQuestion.getTraditionalSearch() + " " + printerModel + " keeps jamming");
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

        // If the user says printer has lines or streaks when printing...
        mPrinterStreaks= (Button) findViewById(R.id.printerStreakingButton);
        mPrinterStreaks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText printerModelEditText = (EditText) findViewById(R.id.editTextPrinterModel);
                String printerModel = printerModelEditText.getText().toString();
                mQuestion.setTraditionalSearch(mQuestion.getTraditionalSearch() + " " + printerModel + " lines or streaking");
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


    }
}
