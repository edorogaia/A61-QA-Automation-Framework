import Playlist.Playlist;
import Song.Song;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class Homework17 {

    private Playlist playlist;
    private Song testSong;

    public Homework17(Song testSong) {
        this.testSong = testSong;
    }

    @BeforeEach
    void setUp() {
        // Initialize objects before every test
        playlist = new Playlist ("Favorites");
        testSong = new Song ("If I find a way (explicit)", "Ron Milazzo" 198);
    }

    @Test
    void testAddSongToPlaylist_Success() {
        // 1. Execute helper method to add the song
        addSongToPlaylist(playlist, testSong);

        // 2. Execute helper methods for verification
        verifyPlaylistContainsSong(playlist, testSong);
        verifyPlaylistSize(playlist, 1);

    }

    @Test
    void testAddSongToPlaylist_DuplicateSong() {
        // 1. Add the song twice
        addSongToPlaylist(playlist, testSong);
        addSongToPlaylist(playlist, testSong);

        // 2. Verify it's only in the playlist once
        verifyPlaylistSize(playlist, 1);
    }
    
    //Helper / Reusable Methods
    
    private void addSongToPlaylist(Playlist playlist, Song testSong) {
        Object song;
        playlist.addSong(song);
    }
    
    private void verifyPlaylistContainsSong(Playlist playlist, Song testSong) {
        assertTrue(playlist.getSongs().contains(song),
                "The playlist should contain the song: " + song.getTitle());
    }
    
    private void verifyPlaylistSize(Playlist playlist, int size) {
        assertEquals(expectedSize, playlist.getSongs().size(),
                "Playlist size does not match.");
    }
}
