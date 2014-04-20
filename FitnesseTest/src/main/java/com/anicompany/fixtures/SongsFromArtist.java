package com.anicompany.fixtures;

import com.anicompany.domain.Song;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Anirban on 4/20/2014.
 */
public class SongsFromArtist
{
    private String artist;

    public SongsFromArtist(String artist)
    {
        this.artist = artist;
    }

    public List<Object> query()
    {
        List<Object> table = new ArrayList();
        for (Song song : prepareSongs(this.artist))
        {
            List<Object> row = new ArrayList();
            row.add(list(new Object[] { "title", song.getTitle() }));
            row.add(list(new Object[] { "artist", song.getArtist() }));
            table.add(row);
        }
        return table;
    }

    private List<Object> list(Object... objs) {
        LinkedList<Object> result = new LinkedList<Object>();

        for (Object current : objs)
            result.add(current);

        return result;
    }

    private List<Song> prepareSongs(String artist)
    {
        List<Song> songList = new ArrayList();
        songList.add(new Song("Metallica", "Nothing Else Matters"));
        return songList;
    }
}
