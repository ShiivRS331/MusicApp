package com.example.musync;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;

public class HealthActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        Button playBtn = findViewById(R.id.health_next);
        playBtn.setOnClickListener(v -> {
            Intent intent = new Intent(HealthActivity.this, MusicPlayerActivity.class);
            startActivity(intent);
        });
    }
}
