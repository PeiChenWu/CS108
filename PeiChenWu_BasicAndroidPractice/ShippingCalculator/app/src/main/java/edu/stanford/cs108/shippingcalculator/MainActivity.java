package edu.stanford.cs108.shippingcalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    private double weights;
    private double rate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CalculateCost (View view) {
        Clicked(view);
        TextView textView = (TextView) findViewById(R.id.InputWeight);
        weights = Double.parseDouble(textView.getText().toString());
        TextView cost = (TextView) findViewById(R.id.Cost);
        cost.setText("Cost: "+ NumberFormat.getCurrencyInstance().format(Math.ceil(weights * rate)).toString());
    }


    public void Clicked (View view) {
        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);
        int currentCheck = group.getCheckedRadioButtonId();
        CheckBox ch = (CheckBox) findViewById(R.id.Insurance);
        switch (currentCheck) {
            case R.id.NextDay:
                rate = 10;
                break;
            case R.id.SecondDay:
                rate = 5;
                break;
            case R.id.Standard:
                rate = 3;
                break;
        }
        if (ch.isChecked()) rate = 1.2 * rate;
    }
}
