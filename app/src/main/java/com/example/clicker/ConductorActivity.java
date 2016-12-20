package com.example.clicker;

import android.content.Context;
import android.content.SharedPreferences;
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
    public int value;
    Clicker clicker = new Clicker();
    public int variableCcounter;

    public static final String SECOND_SAVES="mySecondSave";
    public static final String SECOND_SAVES_COUNTER="secondCounter";
    public static final String SECOND_SAVES_NUMBER_OF_CLICKS="SecondNumberOfClicks";
    public static final String SAVES_CHRONOMETER="SecondNumberOfClicks";
    private SharedPreferences mSaves;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conductor);
        mSaves=getSharedPreferences(SECOND_SAVES, Context.MODE_PRIVATE);
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
        if (variableCcounter==0||clicker.getNumberOfClicks()==1){
            chronometer.setBase(SystemClock.elapsedRealtime());
            chronometer.start();
        }
        variableCcounter++;
        conductorButton.setText(Integer.toString(clicker.getCounter()));
    }

    public void onStopButtonClick(View view) {
        chronometer.stop();

    }

    public void onSecondModeStatsButtonClick(View view) {
        Toast.makeText(this,"Количество пассажиров: "+clicker.getNumberOfClicks()+"\nВыручка: "+clicker.getCounter(),Toast.LENGTH_SHORT).show();
    }

    public void onSecondModeCleanButtonClick(View view) {
        chronometer.stop();
        chronometer.setBase(SystemClock.elapsedRealtime());
        clicker.clean();
        conductorButton.setText("");
    }

    public void onSecondModeResumeClick(View view) {
        chronometer.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences.Editor editor=mSaves.edit();
        editor.putInt(SECOND_SAVES_COUNTER,clicker.getCounter());
        editor.putInt(SECOND_SAVES_NUMBER_OF_CLICKS,clicker.getNumberOfClicks());
       // editor.putLong(SAVES_CHRONOMETER,millis);
        editor.apply();
    }



    @Override
    protected void onResume(){
        super.onResume();
        if (mSaves.contains(SECOND_SAVES_COUNTER)){
            clicker.setCounter(mSaves.getInt(SECOND_SAVES_COUNTER,0));
            conductorButton.setText(Integer.toString(mSaves.getInt(SECOND_SAVES_COUNTER,0)));
        }
        if (mSaves.contains(SECOND_SAVES_NUMBER_OF_CLICKS)){
            clicker.setNumberOfClicks(mSaves.getInt(SECOND_SAVES_NUMBER_OF_CLICKS,0));
        }

    }


}
