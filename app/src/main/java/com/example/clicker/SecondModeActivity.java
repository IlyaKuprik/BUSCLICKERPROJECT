package com.example.clicker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class SecondModeActivity extends AppCompatActivity {
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        if (editText.getText().length()!=0){
        Intent intent=new Intent(SecondModeActivity.this,ConductorActivity.class);;
        intent.putExtra("cost",Integer.parseInt(String.valueOf(editText.getText())));
        startActivity(intent);
        }
        else{
            Toast.makeText(this,"Пожалуйста,введите сумму",Toast.LENGTH_SHORT).show();
        }
    }
}
