package com.example.my_application_v001;

import android.os.Build;
import android.os.SystemClock;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.Toast;

public class StopWatch extends AppCompatActivity {
    private Chronometer chronometer;
    private long pauseOffset;
    private Boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

        chronometer = findViewById(R.id.chronometer);
        chronometer.setFormat("Time: %s");
        chronometer.setBase(SystemClock.elapsedRealtime());

        pauseOffset = 0;
        running = false;

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if((SystemClock.elapsedRealtime() - chronometer.getBase()) % 5000 == 0) {
                    // chronometer.setBase(SystemClock.elapsedRealtime());
                    Toast.makeText(StopWatch.this, "Bang!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void startChronometer(View view){
        if(!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }

    public void pauseChronometer(View view){
        if(running) {
            chronometer.stop();
            pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

    public void resetChronometer(View view){
        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseOffset = 0;
    }
}
