package com.anicompany.domain;

/**
 * Created by Anirban on 4/20/2014.
 */
public class Song {
    private String artist;
    private String title;


    public Song(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
