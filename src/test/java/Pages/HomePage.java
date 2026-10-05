package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Instant;

public class HomePage extends BasePage{

    public HomePage(WebDriver givenDriver) { super(givenDriver);  }

    //Page Elements

    By userAvatarIcon = By.cssSelector("img.avatar");

    //Helper Method

    public WebElement getUserAvatar() { return findElement(userAvatarIcon); }

    public void chooseAllSongsList() {
        Instant wait;
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("li a.songs"))).click();
}

    public void contextClickFirstSong() {
        WebElement firstSongElement = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        Actions actions;
        actions.contextClick(firstSongElement).perform();
    }
