package linkedlist.challenge;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private final String artist;
    private final String name;
    private final ArrayList<Song> listOfSongs;

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        listOfSongs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean addSong(String title, int minutes, int sec) {
        if (findSongByName(title) == null) {
            this.listOfSongs.add(new Song(title, minutes, sec));
            return true;
        }
        return false;
    }

    private Song getSongByIndex(int index) {
        return this.listOfSongs.get(index);
    }

    public Song findSongByName(String name) {
        for (Song song : this.listOfSongs) {
            if (song.getTitle().equals(name)) return song;
        }
        return null;
    }

    public boolean addToPlayListByTrackNumber(int trackNumber, LinkedList<Song> playlist) {
        int index = trackNumber - 1;

        if ((index >= 0) && (index <= this.listOfSongs.size())) {
            playlist.add(getSongByIndex(index));
            return true;
        }
        System.out.println("This album does not have this track.");
        return false;
    }

    public boolean addToPlayListByTitle(String title, LinkedList<Song> playlist) {
        Song checkedSong = findSongByName(title);

        if (checkedSong != null) {
            playlist.add(checkedSong);
            return true;
        }
        System.out.println("The song " + title + " is not in this album.");
        return false;
    }


    public ArrayList<Song> getListOfSongs() {
        return listOfSongs;
    }

    @Override
    public String toString() {
        return "Album{"
                + artist +
                " - " + name + '\'' +
                ",\n listOfSongs:\n " + listOfSongs.toString() +
                '}';
    }
}
