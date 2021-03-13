package edu.stanford.cs108.colorpicker;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeColor(View view) {
        TextView textView = (TextView) findViewById(R.id.RGB);
        SeekBar redSeekBar = (SeekBar) findViewById(R.id.RedBar);
        SeekBar blueSeekBar = (SeekBar) findViewById(R.id.BlueBar);
        SeekBar greenSeekBar = (SeekBar) findViewById(R.id.GreenBar);

        int r = redSeekBar.getProgress();
        int g = greenSeekBar.getProgress();
        int b = blueSeekBar.getProgress();
        View cView = (View) findViewById(R.id.colorView);
        cView.setBackgroundColor(Color.rgb(r,g,b));
        textView.setText("Red: " + r + ", Green: " + g + ", Blue: " + b);
    }
}
