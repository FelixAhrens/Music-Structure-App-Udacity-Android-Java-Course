package com.android.example.mymusicapp;

public class Song {

    private String mSongTitle;
    private String mSongArtist;
    private int mSongCover;
    private int mSongDuration;


    public Song(String songTitle, String songArtist, int songCover, int songDrutation) {
        mSongTitle = songTitle;
        mSongArtist = songArtist;
        mSongCover = songCover;
        mSongDuration = songDrutation;
    }

    public String getSongTitle() {
        return mSongTitle;
    }

    public String getSongArtist() {
        return mSongArtist;
    }

    public int getSongCover() {
        return mSongCover;
    }

    public int getSongDuration() {

        return mSongDuration;
    }
}