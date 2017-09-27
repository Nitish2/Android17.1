package com.example.hp.music_player;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

// Creating class and implements it from View.OnClickListener interface
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //Declaring variables
    Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Creating & initializing objects by ID.
        start = (Button) findViewById(R.id.start);
        stop = (Button) findViewById(R.id.stop);
        // Calling onClick Methods
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // A Switch is a two-state toggle switch widget that can select between two options.
        switch (view.getId()) { // Construct a new Switch
            case R.id.start:// Start Music
                startService(new Intent(this, Music_Service.class)); // Starts the service
                Toast.makeText(this, "Music start", Toast.LENGTH_SHORT).show(); //Toast message
                break; //Break statement
            case R.id.stop:// Stop music
                stopService(new Intent(this, Music_Service.class)); // Starts the service
                Toast.makeText(this, "Music stop", Toast.LENGTH_SHORT).show(); //Toast message
                break; //Break statement

        }
    }
}
