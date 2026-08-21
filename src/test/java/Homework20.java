import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework20 {
    @Test
    public void deletePlaylist() throws InterruptedException{
        String expectedPlaylistDeletedMessage = "Deleted playlist\"Favorites.\"";

        provideEmail("elena.dorogaia@testpro.io");
        providePassword("te$terthegreat");
        clickSubmit();
        openPlaylist();
        clickDeletePlaylistBtn();
        Assert.assertEquals(getDeletedPlaylistMsg(). expectedPlaylistDeletedMessage);
    }

    public void  openPlaylist() {
       // WebElement emptyPlaylist = driver.findElement(By.cssSelector(".playlist:nth-child(3)"));
        WebElement emptyPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector(".playlist:nth-child(3)")));
        emptyPlaylist.click();
    }

    public void clickDeletePlaylistBtn() throws InterruptedException {
        //WebElement deletePlaylist = driver. findElement(By.cssSelector(".btn-delete-playlist"));
        WebElement deletePlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated
                        (By.cssSelector(".btn-delete-playlist")));
        deletePlaylist.click();
    }

    public String getDeletedPlaylistMsg() {
        //WebElement notificationMsg = driver.findElement(By.cssSelector("div.success.show"));
        WebElement notificationMsg = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("div.success.show")));
        return notificationMsg.getText();
    }
}
