import Pages.HomePage;
import Pages.LogingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest {

    String newPlayListName = "Sample Edited Playlist";

    @Test
    public void hoverPlayButton() throws InterruptedException {
        WebDriver driver;
        LogingPage loginPage = new LogingPage(driver);
        HomePage homePage = new HomePage(driver);
        //Login
        loginPage.login();
        //verify Play or Resume button is visible with mouse hover
        Assert.assertTrue(homePage.hoverPlay().isDisplayed());

    }

    private WebElement hoverPlay() {
    }

    private void enterPassword(String te$terthegreat) {
    }

    private void enterEmail(String mail) {
    }
}
