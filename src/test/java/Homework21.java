import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;

import static sun.swing.SwingUtilities2.submit;

public class Homework21Test extends BaseTest{

    String newPlaylistName = "Sample Edited Playlist";

    @Test
    public WebElement renamePlaylist(String newPlaylistName) {

        //Login
        enterEmail("elena.dorogaia@testpro.io");
        enterPassword("te$terthegreat");
        submit();
        //Locate the playlist name element
        WebElement playlistNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//*[@class='playlist-favorites']"));

        //Chain action methods to rename the playlist
        actions.moveToElement(playlistNameElement)
                .doubleClick()
                .keyDown(Keys.CONTROL).sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys(newPlaylistName)
                .sendKeys(Keys.ENTER)
                .build()
                .perform();
        return wait.until(ExpectedConditions.visibilityOf(playlistNameElement));

        //Assertion - verify renamed PlaylistName is visible
        Assert.assertTrue(getrenamedPlaylist().isDisplayed());
    }

    private WebElement getrenamedPlaylist() {
    }


    private WebElement renamePlaylist() {
    }

    public void submit() {
    }

    public void enterPassword(String te$terthegreat) {

    }

    public void enterEmail(String mail) {
    }


}
