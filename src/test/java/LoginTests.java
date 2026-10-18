import Pages.HomePage;
import Pages.LogingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPassword() throws InterruptedException {
        LogingPage logingPage = new LogingPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        logingPage.provideEmail("elena.dorogaia@testpro.io");
        Thread.sleep(2000);
        logingPage.providePassword("te$terthegreat");
        Thread.sleep(2000);
        logingPage.clickSubmit();
        Thread.sleep(2000);
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test
    public void loginInvalidEmailValidPassword() throws InterruptedException {
        String expectedUrl = "https://qa.koel.app/";
        LogingPage logingPage = new LogingPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        logingPage.provideEmail("invalid@testpro.io");
        Thread.sleep(2000);
        logingPage.providePassword("te$terthegreat");
        Thread.sleep(2000);
        logingPage.clickSubmit();
        Thread.sleep(2000);
        Assert.assertEquals(getDriver().getCurrentUrl(), expectedUrl);

    }

    private void enterPassword(String te$terthegreat) {
    }

    private void enterEmail(String mail) {
    }

    //@Test
    public void loginEmptyEmailPassword() {

//      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://qa.koel.app/";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        driver.quit();
    }
}
