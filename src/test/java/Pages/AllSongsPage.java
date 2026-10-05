package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{

    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Page Elements

    By playbackBtn = By.cssSelector("li.playback");

    public AllSongsPage(Object driver) {
        super();
    }

    //Helper

    public void choosePlayOption() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playbackBtn)).click();
    }

    public void chooseAllSongsList() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playbackBtn)).click();
    }

}
