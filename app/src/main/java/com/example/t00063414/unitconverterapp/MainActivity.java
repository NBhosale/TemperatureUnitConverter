package com.example.t00063414.unitconverterapp;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String fromSpinnerValue = "";
    private String toSpinnerValue = "";
    private Spinner fromSpinner;
    private Spinner toSpinner;
    private TextView resultText;
    private String result = "";
    private EditText userValue;
    private String errorResult = "Please enter a value!!";
    private String sameValueError = "No Need Conversion";
    private String CelsiusTemperatureString = "Celsius";
    private String FahrenheitTemperatureString = "Fahrenheit";
    private double inputValue = 0;
    private TextView appTitle;
    private int counterForColor = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            result = savedInstanceState.getString("result");
        }
        titleTimer();
    }

    public void convertTemperature(View view){

        fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        toSpinner = (Spinner) findViewById(R.id.toSpinner);
        userValue = (EditText) findViewById(R.id.userValue);
        fromSpinnerValue = String.valueOf(fromSpinner.getSelectedItem());
        toSpinnerValue = String.valueOf(toSpinner.getSelectedItem());
        resultText = (TextView) findViewById(R.id.resultText);

        if(userValue.getText().toString().equals("")){
            resultText.setText(getString(R.string.result));
            Toast.makeText(this, errorResult, Toast.LENGTH_LONG).show();
        }else if(fromSpinnerValue.equalsIgnoreCase(toSpinnerValue)){
            resultText.setText(getString(R.string.result));
            Toast.makeText(this, sameValueError, Toast.LENGTH_LONG).show();
        }else if(fromSpinnerValue.equalsIgnoreCase(CelsiusTemperatureString)){
            inputValue = Double.parseDouble(userValue.getText().toString());
            double Fahrenheit = (inputValue * 1.8) + 32;
            result = String.valueOf(Fahrenheit);
            resultText.setText(result);
        }else{
            inputValue = Double.parseDouble(userValue.getText().toString());
            double Celsius = (inputValue - 32) * 0.55;
            result = String.valueOf(Celsius);
            resultText.setText(result);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){

        savedInstanceState.putString("result", result);
    }

    public void titleTimer(){
        appTitle = (TextView) findViewById(R.id.appTitle);
        final Handler handle = new Handler();
        handle.post(new Runnable() {
            @Override
            public void run() {
                if(counterForColor == 0){
                    appTitle.setBackgroundResource(R.color.hintColor);
                    counterForColor++;
                }else if(counterForColor == 1){
                    appTitle.setBackgroundResource(R.color.resultColor);
                    counterForColor++;
                }else{
                    appTitle.setBackgroundResource(R.color.valueColor);
                    counterForColor = 0;
                }

                handle.postDelayed(this, 1000);
            }
        });
    }
}
