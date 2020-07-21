package com.android.example.mymusicapp;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

//adapted from AndroidFlavorAdapter -> https://github.com/udacity/ud839_CustomAdapter_Example/blob/master/app/src/main/java/com/example/android/flavor/AndroidFlavorAdapter.java
public class SongAdapter extends ArrayAdapter<Song> {

    private static final String LOG_TAG = SongAdapter.class.getSimpleName();

    /**
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param songs   A List of Songs objects to display in a list
     */
    public SongAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Song currentSong = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView titleTextView = (TextView) listItemView.findViewById(R.id.song_title);
        // Get the version name from the current Song object and
        // set this text on the name TextView
        titleTextView.setText(currentSong.getSongTitle());

        TextView artistTextView = (TextView) listItemView.findViewById(R.id.song_artist);
        artistTextView.setText(currentSong.getSongArtist());
        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.song_cover);
        // Get the image resource ID from the current Word object and
        // set the image to iconView
        iconView.setImageResource(currentSong.getSongCover());
        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView

        TextView durationTextView = (TextView) listItemView.findViewById(R.id.song_duration);
        //convert to mm:ss
        int time = currentSong.getSongDuration();
        int min = time / 60;
        int sec = time % 60;
        if (sec < 10) {
            durationTextView.setText(min + ":0" + sec);
        } else {
            durationTextView.setText(min + ":" + sec);
        }

        return listItemView;

    }
}