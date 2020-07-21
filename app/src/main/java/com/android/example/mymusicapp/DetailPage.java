package com.android.example.mymusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        //button back to main_activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //get song infmormation from  MainActivity
        Intent intent = getIntent();
        String songTitle = intent.getStringExtra("SongTitle");
        String songArtist = intent.getStringExtra("SongArtist");
        int songCover = intent.getIntExtra("SongCover", 0);
        int time = intent.getIntExtra("SongDuration", 0);

        //convert time to mm:ss format
        String songDuration = "";
        int min = time / 60;
        int sec = time % 60;
        if (sec < 10) songDuration = min + ":0" + sec;
        else songDuration = min + ":" + sec;

        //set text and images
        TextView songTitleView = (TextView) findViewById(R.id.song_title_subpage);
        songTitleView.setText(String.valueOf(songTitle));
        TextView songArtistView = (TextView) findViewById(R.id.song_artist_subpage);
        songArtistView.setText(String.valueOf(songArtist));
        ImageView songImageView = (ImageView) findViewById(R.id.song_cover_subpage);
        songImageView.setImageResource(songCover);
        TextView songDurationView = (TextView) findViewById(R.id.song_duration);
        songDurationView.setText(songDuration);
    }
}
