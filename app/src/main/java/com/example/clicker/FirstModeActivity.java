package com.example.clicker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FirstModeActivity extends AppCompatActivity {
    Button clickButton;
    EditText firstModeHeadline;
    Clicker clicker=new Clicker();
    public static final String SAVES="mySave";
    public static final String SAVES_COUNTER="counter";
    public static final String SAVES_NUMBER_OF_CLICKS="numberOfClicks";
    public static final String SAVES_DATE="date";
    static String formattedDate;
    private SharedPreferences mSaves;

    static SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_first_mode);
        clickButton=(Button)findViewById(R.id.clickButton);
        firstModeHeadline=(EditText)findViewById(R.id.editText2);
        mSaves=getSharedPreferences(SAVES, Context.MODE_PRIVATE);
    }

    public void onClickButtonClick(View view) {
        if (firstModeHeadline.getText().length()!=0) {
            clicker.click(Integer.parseInt(firstModeHeadline.getText().toString()));
            clickButton.setText(Integer.toString(clicker.getCounter()));
        }
        else {
            Toast.makeText(this,"Пожалуйста,введите стоимость проезда",Toast.LENGTH_SHORT).show();
        }
        if (clicker.getNumberOfClicks()==1) {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            formattedDate = df.format(c.getTime());
            editor=mSaves.edit();
            editor.putString(SAVES_DATE,formattedDate);
            editor.apply();
        }
    }

    public void onStatsButtonClick(View view) {
        Toast.makeText(this, "Статистика проездов с " + formattedDate + "\nКоличество проездов: " + clicker.getNumberOfClicks() + "\nСумма всех проездов: " + clicker.getCounter(), Toast.LENGTH_LONG).show();
    }

    public void onCleanButtonClick(View view) {
        clicker.clean();
        clickButton.setText("");
        formattedDate="";
    }

    @Override
    protected void onPause(){
        super.onPause();
        editor=mSaves.edit();
        editor.putInt(SAVES_COUNTER,clicker.getCounter());
        editor.putInt(SAVES_NUMBER_OF_CLICKS,clicker.getNumberOfClicks());
        editor.apply();
    }

    @Override
    protected void onResume(){
        super.onResume();
        if (mSaves.contains(SAVES_COUNTER)){
            clicker.setCounter(mSaves.getInt(SAVES_COUNTER,0));
            clickButton.setText(Integer.toString(mSaves.getInt(SAVES_COUNTER,0)));
        }
        if (mSaves.contains(SAVES_NUMBER_OF_CLICKS)){
            clicker.setNumberOfClicks(mSaves.getInt(SAVES_NUMBER_OF_CLICKS,0));
        }
        if (mSaves.contains(SAVES_DATE)){
            formattedDate=mSaves.getString(SAVES_DATE,null);
        }
    }

    public void onFirstModeBackButtonClick(View view) {
        Intent intent=new Intent(FirstModeActivity.this,MainActivity.class);
        startActivity(intent);
    }
}

