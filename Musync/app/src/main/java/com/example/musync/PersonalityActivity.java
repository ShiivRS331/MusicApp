package com.example.musync;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

public class PersonalityActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personality);

        Spinner spinner = findViewById(R.id.personality_spinner);
        Button nextBtn = findViewById(R.id.personality_next);
        Button openTest = findViewById(R.id.take_test);

        openTest.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.16personalities.com/free-personality-test"));
            startActivity(browserIntent);
        });

        nextBtn.setOnClickListener(v -> {
            startActivity(new Intent(this, MoodActivity.class));
        });
    }
}
