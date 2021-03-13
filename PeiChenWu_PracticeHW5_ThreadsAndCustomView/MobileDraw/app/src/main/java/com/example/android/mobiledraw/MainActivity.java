package com.example.android.mobiledraw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //public static int MODE = 2;
    public static float X;
    public static float Y;
    public static float WIDTH;
    public static float HEIGHT;
    public static boolean SELECTION = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Drawable.mode = 2;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button updateBtn = (Button) findViewById(R.id.update_btn);
        updateBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RadioGroup group = (RadioGroup) findViewById(R.id.rGroup);
                        int currentCheck = group.getCheckedRadioButtonId();
                        switch (currentCheck) {
                            case R.id.select:
                                Drawable.mode = 1;
                                String s = "";
                                s += Drawable.mode;
                                Toast toast = Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT);
                                toast.show();
                                break;
                            case R.id.rect:
                                Drawable.mode = 2;
                                break;
                            case R.id.oval:
                                Drawable.mode = 3;
                                s = "";
                                s += Drawable.mode;
                                toast = Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT);
                                toast.show();
                                break;
                            case R.id.erase:
                                Drawable.mode = 4;
                                break;
                        }
                        TextView text_X = (TextView) findViewById(R.id.x_pos);
                        TextView text_Y = (TextView) findViewById(R.id.y_pos);
                        TextView text_W = (TextView) findViewById(R.id.width);
                        TextView text_H = (TextView) findViewById(R.id.height);
                        if (SELECTION) {
                            //TextView text_X = (TextView) findViewById(R.id.x_pos);
                            String output1 = "";
                            output1 += X;
                            text_X.setText(output1);

                            //TextView text_Y = (TextView) findViewById(R.id.y_pos);
                            String output2 = "";
                            output2 += Y;
                            text_Y.setText(output2);

                            //TextView text_W = (TextView) findViewById(R.id.width);
                            String output3 = "";
                            output3 += WIDTH;
                            text_W.setText(output3);


                            //TextView text_H = (TextView) findViewById(R.id.height);
                            String output4 = "";
                            output4 += HEIGHT;
                            text_H.setText(output4);



                            SELECTION = false;
                        } else {
                            //TextView text_X = (TextView) findViewById(R.id.x_pos);
                            String output1 = "";
                            //output1 += X;
                            text_X.setText(output1);

                            //TextView text_Y = (TextView) findViewById(R.id.y_pos);
                            String output2 = "";
                            //output2 += Y;
                            text_Y.setText(output2);

                            //TextView text_W = (TextView) findViewById(R.id.width);
                            String output3 = "";
                            //output3 += WIDTH;
                            text_W.setText(output3);


                            //TextView text_H = (TextView) findViewById(R.id.height);
                            String output4 = "";
                            //output4 += HEIGHT;
                            text_H.setText(output4);


                        }

                        /*
                        if (text_X.getText().toString() != "" && text_Y.getText().toString() != "" && text_W.getText().toString() != "" && text_H.getText().toString() != "") {
                            X = Float.parseFloat(text_X.getText().toString());
                            Y = Float.parseFloat(text_Y.getText().toString());
                            WIDTH = Float.parseFloat(text_W.getText().toString());
                            HEIGHT = Float.parseFloat(text_H.getText().toString());
                        }
                        */




                    }
                }
        );

    }

    public void update(View view) {
    }

/*
    public void setTextView() {
        TextView text_X = (TextView) findViewById(R.id.x_pos);
        String s = "";
        s += X;
        text_X.setText(s);
    }
*/

}

