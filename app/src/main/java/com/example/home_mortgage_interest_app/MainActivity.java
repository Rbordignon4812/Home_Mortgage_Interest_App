package com.example.home_mortgage_interest_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.prefs.Preferences;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    int intialYears;
    float intialLoan;
    float monthPay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText years=(EditText) findViewById(R.id.yearsTxt);
        final EditText loan=(EditText) findViewById(R.id.loanTxt);
        final EditText monthly=(EditText) findViewById(R.id.monthlyTxt);
        final SharedPreferences SharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        Button button = (Button) findViewById(R.id.calculateButton);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                intialLoan = Float.parseFloat(loan.getText().toString());
                intialYears = Integer.parseInt(years.getText().toString());
                if(intialYears != 10 || intialYears != 20 || intialYears != 30){
                    Toast.makeText(MainActivity.this,"years must be 10,20,30",Toast.LENGTH_LONG).show();
                }
                else {
                    monthPay = Float.parseFloat(monthly.getText().toString());
                    SharedPreferences.Editor editor = SharedPref.edit();
                    editor.putInt("key1", intialYears);
                    editor.putFloat("key2", intialLoan);
                    editor.putFloat("key3", monthPay);
                    editor.commit();
                    startActivity(new Intent(MainActivity.this, Month_Payment.class));
                }

            }
        });
    }
}
