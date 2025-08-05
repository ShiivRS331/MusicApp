package com.example.musync;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;
public class MoodActivity extends Activity {
    String[] moods = {"Happy", "Sad", "Angry", "Anxious", "Custom"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood);

        GridView gridView = findViewById(R.id.mood_grid);
        MoodAdapter adapter = new MoodAdapter(this, moods);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            String selectedMood = moods[position];
            Toast.makeText(this, "Selected: " + selectedMood, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, HealthActivity.class));
        });
    }
}
