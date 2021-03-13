package com.example.android.cityinformation;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase CitiesDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CitiesDB = openOrCreateDatabase("myDB", MODE_PRIVATE, null);


        Cursor tablesCursor = CitiesDB.rawQuery("SELECT * FROM sqlite_master WHERE type='table' AND name='cities';", null);
        if (tablesCursor.getCount() == 0) {
            initiate_DataBase();
        }

        Button resetBtn = (Button) findViewById(R.id.reset_database);
        resetBtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String clearStr = "DROP TABLE IF EXISTS cities;";
                        CitiesDB.execSQL(clearStr);
                        initiate_DataBase();
                        Toast toast = Toast.makeText(MainActivity.this, "Database Reset", Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }
        );
    }

    public void LookUpCities(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
    }

    public void AddCity(View view) {
        Intent intent = new Intent(this, Main3Activity.class);
        startActivity(intent);
    }

    public void Reset(View view) {
        // Implement in the onClick Listener
    }

    private void initiate_DataBase() {
        String setupStr = "CREATE TABLE cities ("
                + "name TEXT, continent TEXT, population INTEGER,"
                + " _id INTEGER PRIMARY KEY AUTOINCREMENT"
                + ");";
        System.err.println(setupStr);
        CitiesDB.execSQL(setupStr);

        String dataStr = "INSERT INTO cities VALUES"
                + "('Cairo','Africa',15212345,NULL),"
                + "('Lagos','Africa',21000000,NULL),"
                + "('Kyoto','Asia',1474570,NULL),"
                + "('Mumbai','Asia',20400000,NULL),"
                + "('Shanghai','Asia',24152700,NULL),"
                + "('Melbourne','Australia',3900000,NULL),"
                + "('London','Europe',8580000,NULL),"
                + "('Rome','Europe',2715000,NULL),"
                + "('Rostov-on-Don','Europe',1052000,NULL),"
                + "('New York','North America',21295000,NULL),"
                + "('San Francisco','North America',5780000,NULL),"
                + "('San Jose','North America',7354555,NULL),"
                + "('Rio de Janeiro','South America',12280702,NULL),"
                + "('Santiago','South America',5507282,NULL)"
                + ";";
        System.err.println(dataStr);
        CitiesDB.execSQL(dataStr);
    }
}
