import Pages.AllSongsPage;
import Pages.HomePage;
import Pages.LogingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Instant;

public static class AllSongsTest extends BaseTest {

    private Instant wait;

   /*@Test
    public void playSong() throws InterruptedException {
        //Login
        enterEmail("elena.dorogaia@testpro.io");
        enterPassword("te$terthegreat");
        Submit();
        //Thread.sleep(2000);
        //choose AllSongs list
        chooseAllSongsList();
        //Thread.sleep(2000);
        //contextClickFirstSong
        contextClickFirstSong();
        //Thread.sleep(2000);
        //choosePlayOption
        choosePlayOption();
        //Thread.sleep(2000);
        //verify that song is playing
        Assert.assertTrue(isSongPlaying());
    }
    }
    */

    @Test
    public void playSongWithContextClick() throws InterruptedException {
        WebDriver driver;
        LogingPage logingPage = new LogingPage(driver);
        HomePage homePage = new HomePage(driver);
        AllSongsPage allSongsPage = new AllSongsPage(driver);

        LogingPage.login();
        homePage.chooseAllSongsList();
        homePage.contextClickFirstSong();
        allSongsPage.choosePlayOption();
        //verify that song is playing
        Assert.assertTrue(allSongsPage.isSongPlaying());
    }


    }



    private boolean isSongPlaying() {
    }


    private void choosePlayOption() {
    }


    private void contextClickFirstSong() {
    }


    private void chooseAllSongsList() {
    }


    private void Submit() {
    }

    private void enterPassword(String te$terthegreat) {
    }

    private void enterEmail(String mail) {
    }
}
