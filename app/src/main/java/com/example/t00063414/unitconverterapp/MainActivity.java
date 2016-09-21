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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void convertTemperature(View view){

        fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        toSpinner = (Spinner) findViewById(R.id.toSpinner);
        userValue = (EditText) findViewById(R.id.userValue);
        fromSpinnerValue = String.valueOf(fromSpinner.getSelectedItem());
        toSpinnerValue = String.valueOf(toSpinner.getSelectedItem());
        resultText = (TextView) findViewById(R.id.resultText);

        if(userValue.getText().toString().equals("")){
            Toast.makeText(this, errorResult, Toast.LENGTH_LONG).show();
        }else if(fromSpinnerValue.equalsIgnoreCase(toSpinnerValue)){
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
}
