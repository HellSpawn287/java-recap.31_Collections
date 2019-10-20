package linkedlist.challenge;

import java.util.*;

public class Client {
    public static void main(String[] args) {
        LinkedList<Song> playlist = new LinkedList<>();

        Album metallica1991 = new Album("Metallica", "Metallica");
        metallica1991.getListOfSongs().add(new Song("Enter Sandman", 5, 32));
        metallica1991.getListOfSongs().add(new Song("Sad But True", 5, 24));
        metallica1991.getListOfSongs().add(new Song("Holier Than Thou", 3, 47));
        metallica1991.getListOfSongs().add(new Song("The Unforgiven", 6, 27));
        metallica1991.getListOfSongs().add(new Song("Wherever I May Roam", 6, 44));
        metallica1991.getListOfSongs().add(new Song("Don't Tread on Me", 4, 0));
        metallica1991.getListOfSongs().add(new Song("Through the Never", 4, 4));
        metallica1991.getListOfSongs().add(new Song("Nothing Else Matters", 6, 28));
        metallica1991.getListOfSongs().add(new Song("Of Wolf and Man", 4, 16));
        metallica1991.getListOfSongs().add(new Song("The God That Failed", 5, 8));
        metallica1991.getListOfSongs().add(new Song("My Friend of Misery", 6, 49));
        metallica1991.getListOfSongs().add(new Song("The Struggle Within", 3, 53));

        Album trophies = new Album("Apollo Brown", "Trophies");
        trophies.getListOfSongs().add(new Song("Trophies", 0, 39));
        trophies.getListOfSongs().add(new Song("The Pursuit", 3, 55));
        trophies.getListOfSongs().add(new Song("Prove Me Wrong", 3, 57));
        trophies.getListOfSongs().add(new Song("Nautica", 3, 55));
        trophies.getListOfSongs().add(new Song("Anotha One", 4, 18));
        trophies.getListOfSongs().add(new Song("Disclaimer", 2, 48));
        trophies.getListOfSongs().add(new Song("We the People", 4, 11));
        trophies.getListOfSongs().add(new Song("Signs", 2, 0));
        trophies.getListOfSongs().add(new Song("The First 48", 4, 3));
        trophies.getListOfSongs().add(new Song("Angels Sing", 4, 2));
        trophies.getListOfSongs().add(new Song("Just Walk", 4, 10));
        trophies.getListOfSongs().add(new Song("The Formula", 3, 49));
        trophies.getListOfSongs().add(new Song("People's Champ", 4, 8));
        trophies.getListOfSongs().add(new Song("Options", 3, 10));
        trophies.getListOfSongs().add(new Song("Caught Up", 3, 39));
        trophies.getListOfSongs().add(new Song("Fantastic", 2, 13));

        playlist.add(metallica1991.getListOfSongs().get(0));
        playlist.add(trophies.getListOfSongs().get(0));


//        printSongs(playlist);
//        printSongs(trophies.getListOfSongs());
//        printSongs(metallica1991.getListOfSongs());
        addToPlaylistInOrder(playlist, trophies.findSongByName("The Formula"));
        removeSongFromPlaylist(playlist, "The Formula");

        play(playlist);

    }

    private static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> iPlay = playlist.listIterator();

        if (playlist.isEmpty()) {
            System.out.println("PlayList is Empty");
            return;
        } else {
            printSongs(playlist);
            printMenu();
            System.out.println("Now playing " + iPlay.next().toString());
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Listening is over!");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (iPlay.hasNext()) {
                            iPlay.next();
                        }
                        forward = true;
                    }
                    if (iPlay.hasNext()) {
                        System.out.println("Now playing " + iPlay.next());
                    } else {
                        System.out.println("Reached the end of the playlist.");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (iPlay.hasPrevious()) {
                            iPlay.previous();
                        }
                        forward = false;
                    }
                    if (iPlay.hasPrevious()) {
                        System.out.println("Now playing " + iPlay.previous());
                    } else {
                        System.out.println("We are at the beginning of this list");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (iPlay.hasPrevious()) {
                            System.out.println("Now replaying " + iPlay.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the beginning of this list");
                        }
                    } else {
                        if (iPlay.hasNext()) {
                            System.out.println("Now replaying " + iPlay.next().toString());
                            forward = true;
                        } else {
                            System.out.println("Reached the end of the playlist.");
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    printSongs(playlist);
                    break;
                case 6:
                    if (playlist.size() > 0) {
                        iPlay.remove();
                        if (iPlay.hasNext()) {
                            System.out.println("Now playing " + iPlay.next());
                        } else if (iPlay.hasPrevious()) {
                            System.out.println("Now playing " + iPlay.previous());
                        }
                    } else {
                        quit = true;
                    }
                    break;
//                case 7:
//                    System.out.println("Type title of song to be removed: ");
//                    String songToBeRemoved = scanner.nextLine();
//                    while (removeSongFromPlaylist(playlist, songToBeRemoved)) {
//                        System.out.println(songToBeRemoved + " has been removed successfully");
//                        play(playlist);
//                        break;
//                    }
//                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available options: \npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay current song\n" +
                "4 - to print menu\n" +
                "5 - to print list of songs\n" +
                "6 - to remove current song from playlist\n" /*+
                "7 - to remove song by title from playlist\n"*/);
    }

    private static boolean removeSongFromPlaylist(LinkedList<Song> playlist, String song) {
        ListIterator<Song> playlistIterator = playlist.listIterator();

        while (playlistIterator.hasNext()) {
            if (playlistIterator.next().getTitle().equals(song)) {
//                playlistIterator.next();
                playlistIterator.remove();
                return true;
            }
        }
        return false;
    }

    private static boolean addToPlaylistInOrder(LinkedList<Song> playlist, Song song) {
        ListIterator<Song> playlistIterator = playlist.listIterator();

        while (playlistIterator.hasNext()) {
            int comparision = playlistIterator.next().getTitle().compareTo(song.getTitle());

            if (comparision == 0) {
                System.out.println(song + " is already added to this playlist.");
                return false;
            } else if (comparision > 0) {
                playlistIterator.previous();
                playlistIterator.add(song);

                return true;
            } else if (comparision < 0) {
                // go to next
            }
        }

        playlistIterator.add(song);
        return true;
    }


    private static void printSongs(ArrayList<Song> album) {
        for (Song song : album) System.out.println("-->" + song);
    }


    private static void printSongs(LinkedList<Song> playlist) {
        Iterator<Song> i = playlist.iterator();

        System.out.println("\nCurrent playlist: ");
        while (i.hasNext()) {
            System.out.println(i.next());
        }
        System.out.println("==============================\n");
    }
}
