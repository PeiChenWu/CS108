package com.example.android.cityinformation;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.example.android.cityinformation.R.id.population;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Main2Activity extends AppCompatActivity {
    SQLiteDatabase CitiesDB;
    boolean greater_or_equal = FALSE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        CitiesDB = openOrCreateDatabase("myDB", MODE_PRIVATE, null);

    }

    public void Search(View view) {
        TextView text_name = (TextView) findViewById(R.id.name);
        TextView text_continent = (TextView) findViewById(R.id.continent);
        TextView text_population = (TextView) findViewById(population);

        String city ="", cont = "", pop = "0";
        if (text_name.getText().toString().length() != 0) city += text_name.getText().toString();
        if (text_continent.getText().toString().length() != 0) cont += text_continent.getText().toString();
        if (text_population.getText().toString().length() != 0) {
            pop = "";
            pop += text_population.getText().toString();
        }


        RadioGroup group = (RadioGroup) findViewById(R.id.rGroup);
        int currentCheck = group.getCheckedRadioButtonId();
        switch (currentCheck) {
            case R.id.greaterorequal:
                greater_or_equal = TRUE;
                break;
            case R.id.lessthan:
                greater_or_equal = FALSE;
                break;
        }

        String queryStr = "";
        if (greater_or_equal == TRUE) {
            queryStr += "SELECT * FROM cities WHERE name LIKE '%" + city + "%' AND continent LIKE '%" + cont + "%' AND population >= " + pop + ";";
        } else {
            if (pop == "0") {
                queryStr += "SELECT * FROM cities WHERE name LIKE '%" + city + "%' AND continent LIKE '%" + cont + ";";
            } else {
                queryStr += "SELECT * FROM cities WHERE name LIKE '%" + city + "%' AND continent LIKE '%" + cont + "%' AND population < " + pop + ";";
            }
        }

        Cursor cursor = CitiesDB.rawQuery(queryStr, null);
        System.err.println(queryStr);

        String output1 = "";
        String output2 = "";
        while (cursor.moveToNext()) {
            output1 += cursor.getString(0) + "\n" + cursor.getString(1) + "\n";
            output2 += cursor.getString(2) + "\n" + "\n";
        }

        TextView outputView = (TextView) findViewById(R.id.textOutput);
        outputView.setText(output1);
        TextView outputView2 = (TextView) findViewById(R.id.textOutput2);
        outputView2.setText(output2);
    }
}
