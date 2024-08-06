
package com.example.firstdemo;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.TextView;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {

    private SharedPreferences prefs;
    private TextView counterTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Add Counter
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        counterTextView = findViewById(R.id.counterTextView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        int visitCount = prefs.getInt("visit_count", 0);
        counterTextView.setText("Visits: " + visitCount);
    }
}