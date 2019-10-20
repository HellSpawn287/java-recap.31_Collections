package linkedlist.challenge;

import java.time.Duration;

public class Song {
    private final String title;
    private final Duration duration;

    public Song(String title, int minutes, int sec) {
        this.title = title;
        this.duration = Duration.ofMinutes((long) minutes).withSeconds((long) sec);
    }

    public String getTitle() {
        return title;
    }

    public Duration getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "-- > title: '" + title + '\'' +
                ", duration: " + String.format("%02d:%02d",
                duration.toMinutes(),
                duration.getSeconds());
    }
}
