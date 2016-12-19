package com.example.clicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondModeActivity extends AppCompatActivity {
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_mode);
        editText=(EditText)findViewById(R.id.editText);
    }

    public void onFirstCostClick(View view) {
        Intent intent=new Intent(SecondModeActivity.this,ConductorActivity.class);
        intent.putExtra("cost",20);
        startActivity(intent);
    }

    public void onSecondCostClick(View view) {
        Intent intent=new Intent(SecondModeActivity.this,ConductorActivity.class);
        intent.putExtra("cost",22);
        startActivity(intent);
    }

    public void onThirdCostClick(View view) {
        Intent intent=new Intent(SecondModeActivity.this,ConductorActivity.class);
        intent.putExtra("cost",25);
        startActivity(intent);
    }

    public void onIndividualButtonClick(View view) {
        Intent intent=new Intent(SecondModeActivity.this,ConductorActivity.class);
        intent.putExtra("cost",editText.getText());
        startActivity(intent);
    }
}
