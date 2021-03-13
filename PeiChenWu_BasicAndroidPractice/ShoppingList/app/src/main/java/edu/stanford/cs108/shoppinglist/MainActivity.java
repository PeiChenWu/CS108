package edu.stanford.cs108.shoppinglist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addItem(View view) {
        TextView textView_Out = (TextView) findViewById(R.id.textOutput);
        TextView textView_In = (TextView) findViewById(R.id.textInput);
        if (textView_In.getText().length()!=0) {
            textView_Out.append(textView_In.getText()+"\n");
            textView_In.setText("");
        }
    }

    public void clearItem(View view) {
        TextView textView_Out = (TextView) findViewById(R.id.textOutput);
        textView_Out.setText("");
        TextView textView_In = (TextView) findViewById(R.id.textInput);
        textView_In.setText("");
    }
}
