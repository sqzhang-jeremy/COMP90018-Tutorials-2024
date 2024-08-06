package com.example.firstdemo;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.TextView;

import com.example.firstdemo.databinding.ActivityMain2Binding;

public class Main2Activity extends AppCompatActivity {

    public static String RECEIVED_MESSAGE = "Received message";

    private SharedPreferences prefs;
    private TextView counterTextView;

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        Intent intent = getIntent();
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.previousMessage.setText(intent.getStringExtra(MainActivity.MESSAGE));

        // Handle the back press in API > Tiramisu
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(RECEIVED_MESSAGE, "Hello from the second activity.");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);

        // Add button click listener for activity 3
        binding.buttonToMain3Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
                startActivity(intent);
            }
        });

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
