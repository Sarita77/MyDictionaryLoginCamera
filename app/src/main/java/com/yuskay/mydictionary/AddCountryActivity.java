package com.yuskay.mydictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class AddCountryActivity extends AppCompatActivity {
    EditText etCountry, etCapital;
    Button btnAddCountry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_country);

        etCapital = findViewById(R.id.etCapital);
        etCountry = findViewById(R.id.etCountry);
        btnAddCountry = findViewById(R.id.btnAddCountry);

        btnAddCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }
        });
    }

    private void Save() {
        try{
            PrintStream printStream = new PrintStream(openFileOutput("words.txt", MODE_PRIVATE | MODE_APPEND));
            printStream.println(etCountry.getText().toString()+ "->" + etCapital.getText().toString());
            Toast.makeText(this, ""+ getFilesDir(), Toast.LENGTH_LONG).show();

        }
        catch (FileNotFoundException e) {
            Log.d("Dictionary app", "Error:" + e.toString());
            e.printStackTrace();
        }
    }


}
