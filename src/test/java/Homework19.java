import org.testng.annotations.Test;

public class PlaylistTest<Playlist> extends BaseTest {

    @Test
    public void testDeletePlaylist(){
        // 1. Arrange: Create and populate the playlist
        Playlist myPlaylist = new Playlist ("Favorites");
        myPlaylist.addSong("If I find a way");

        // 2. Act: Delete the playlist
        myPlaylist.delete();

        // 3. Assert: Verify the playlist is deleted
        assertTrue(myPlaylist.isDeleted(),"The playlist should be deleted.");
        Object PlaylistManager;
        assertNull(PlaylistManager.getPlaylist("Favorites"), "The playlist should no longer exist in the system.");
    }
}
