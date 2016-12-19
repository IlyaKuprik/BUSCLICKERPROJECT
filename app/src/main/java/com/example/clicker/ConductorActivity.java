package com.example.clicker;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class ConductorActivity extends AppCompatActivity {
    Button conductorButton;
    Chronometer chronometer;
    static int value;
    Clicker clicker = new Clicker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conductor);

        Bundle extras=getIntent().getExtras();
        if (extras!=null){
            value=extras.getInt("cost");
        }
        conductorButton=(Button)findViewById(R.id.conductorButton);
        chronometer=(Chronometer)findViewById(R.id.chrn);
        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                        chronometer.getBase();
            }
        });
    }

    public void onConductorButtonClick(View view) {
        clicker.click(value);
        if (clicker.getNumberOfClicks()==1){
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
        }
        conductorButton.setText(Integer.toString(clicker.getCounter()));
    }

    public void onStopButtonClick(View view) {
        chronometer.stop();
    }

    public void onSecondModeStatsButtonClick(View view) {
        Toast.makeText(this,"Количество пассажиров: "+clicker.getNumberOfClicks()+"\nВыручка: "+clicker.getCounter(),Toast.LENGTH_SHORT).show();
    }

    public void onSecondModeCleanButtonClick(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        clicker.clean();
        conductorButton.setText("");
    }

    public void onSecondModeResumeClick(View view) {
        chronometer.start();
    }
}
