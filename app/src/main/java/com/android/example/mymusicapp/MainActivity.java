package com.android.example.mymusicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create list of songs with own Song class -> Song.java
        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Imagine", "John Lennon",
                R.drawable.john_lennon, 189));
        songs.add(new Song("No Woman, No Cry", "Bob Marley",
                R.drawable.bob_marley, 434));
        songs.add(new Song("(I Can’t Get No) Satisfaction", "The Rolling Stones",
                R.drawable.rolling_stones, 223));
        songs.add(new Song("Yesterday", "The Beatles",
                R.drawable.the_beatles, 153));
        songs.add(new Song("Good Vibrations", "The Beach Boys",
                R.drawable.beach_boys, 216));
        songs.add(new Song("Smells Like Teen Spirit", "Nirvana",
                R.drawable.nirvana, 276));
        songs.add(new Song("Johnny B. Goode", "Chuck Berry",
                R.drawable.chuck_berry, 160));
        songs.add(new Song("Blowin’ In The Wind’", "Bob Dylan",
                R.drawable.bob_dylan, 176));
        songs.add(new Song("Stairway To Heaven", "Led Zeppelin",
                R.drawable.led_zeppelin, 482));
        songs.add(new Song("Light My Fire", "The Doors",
                R.drawable.the_doors, 185));
        songs.add(new Song("Hound Dog", "Elvis Presley",
                R.drawable.elvis_pressley, 147));
        songs.add(new Song("One", "U2",
                R.drawable.u2, 304));


        //Create ListView for Song Library
        SongAdapter adapter = new SongAdapter(this, songs);
        ListView listView = (ListView) findViewById(R.id.list);
        // remove divider between songs
        listView.setDivider(null);
        listView.setAdapter(adapter);


        //Intent for ListView Items to DetailPage
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailPage.class);

                //get item from ArrayList from the clicked element
                String songTitle = songs.get(position).getSongTitle();
                String songArtist = songs.get(position).getSongArtist();
                int songCover = songs.get(position).getSongCover();
                int songDuration = songs.get(position).getSongDuration();
                //transfer ArrayList Item to detail activity
                intent.putExtra("SongTitle", songTitle);
                intent.putExtra("SongArtist", songArtist);
                intent.putExtra("SongCover", songCover);
                intent.putExtra("SongDuration", songDuration);
                startActivity(intent);
            }
        });

    }
}
