package com.example.android.cityinformation;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    SQLiteDatabase CitiesDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        CitiesDB = openOrCreateDatabase("myDB", MODE_PRIVATE, null);

        Button addBtn = (Button) findViewById(R.id.add);
        addBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextView NAME = (TextView) findViewById(R.id.name);
                        TextView CONT = (TextView) findViewById(R.id.continent);
                        TextView POP = (TextView) findViewById(R.id.population);

                        String dataStr = "INSERT INTO cities VALUES ('" +  NAME.getText().toString()  + "','" +  CONT.getText().toString() +  "'," + POP.getText().toString()  + ",NULL);";
                        System.err.println(dataStr);
                        CitiesDB.execSQL(dataStr);
                        Toast toast = Toast.makeText(Main3Activity.this, NAME.getText().toString() + " Added", Toast.LENGTH_SHORT);
                        toast.show();
                        NAME.setText(""); CONT.setText(""); POP.setText("");
                    }
                }
        );
    }
    public void addCity(View view) {
        // Implement in the onClick Listener
    }
}
