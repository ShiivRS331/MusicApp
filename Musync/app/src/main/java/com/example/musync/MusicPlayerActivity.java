package com.example.musync;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;
public class MusicPlayerActivity extends Activity {
    private MediaPlayer mediaPlayer;
    private Button playPauseBtn;
    private SeekBar seekBar;

    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player); // Note: uses activity_player.xml

        playPauseBtn = findViewById(R.id.playPauseBtn);
        seekBar = findViewById(R.id.seekBar);

        // Load music from res/raw/sample_music.mp3 (you must add this file manually)
        mediaPlayer = MediaPlayer.create(this, R.raw.sample_music);

        seekBar.setMax(mediaPlayer.getDuration());

        playPauseBtn.setOnClickListener(v -> {
            if (isPlaying) {
                mediaPlayer.pause();
                playPauseBtn.setText("Play");
            } else {
                mediaPlayer.start();
                playPauseBtn.setText("Pause");
            }
            isPlaying = !isPlaying;
        });

        // Update seek bar while playing
        new Thread(() -> {
            while (mediaPlayer != null) {
                try {
                    if (mediaPlayer.isPlaying()) {
                        seekBar.setProgress(mediaPlayer.getCurrentPosition());
                    }
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) mediaPlayer.seekTo(progress);
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    @Override
    protected void onDestroy() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
        super.onDestroy();
    }

}
