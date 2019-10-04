package com.example.home_mortgage_interest_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.DecimalFormat;

public class Month_Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month__payment);
        EditText monthlyPay= (EditText) findViewById(R.id.totalMortgage);
        ImageView image= (ImageView) findViewById(R.id.imageView2);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intYears = sharedPref.getInt("key1",0);
        float floLoan = sharedPref.getFloat("key2",0);
        float floMonth = sharedPref.getFloat("key3",0);

        float finTotalInterest =(float)(floMonth * (intYears * 12)) - floLoan;
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        monthlyPay.setText(currency.format(finTotalInterest));
        if (intYears == 10){
            image.setImageResource(R.drawable.ten);
        }
        else if(intYears == 20){
            image.setImageResource(R.drawable.twenty);
        }
        else if(intYears == 30){
            image.setImageResource(R.drawable.thirty);
        }
        else{
            image.setImageResource(R.drawable.opps);
        }
    }
}
