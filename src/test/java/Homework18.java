import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework18 extends BaseTest {
    @Test(description = "Verify that a song can be successfully played")
    public void playSong() {
        MusicPlayer player = new MusicPlayer();

        // Play the song
        player.selectSong("Episode 2");
        player.pressPlay();

        //Assert that the song is currently playing
        Assert.assertTrue(player.isPlaying(),"The music player failed to play the song."
        Assert.assertEquals(player.getCurrentSong(),"Episode 2", "The wrong song";

    }
}
