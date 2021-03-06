package com.example.clicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
    }

    public void onFirstModeButtonClick(View view) {
        Intent intent=new Intent(MainActivity.this,FirstModeActivity.class);
        startActivity(intent);
    }

    public void onSecondModeButtonClick(View view) {
        Intent intent=new Intent(MainActivity.this,SecondModeActivity.class);
        startActivity(intent);
    }
}
