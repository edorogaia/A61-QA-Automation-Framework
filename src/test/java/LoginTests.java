import PageFactory.LoginPageFactory;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.time.Instant;

public class LoginTests extends BaseTest {
    @Test
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

    @Test
    public void positiveLoginTest(){
        //Objects
        WebDriver driver;
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        //Steps
        loginPage.provideEmail("elena.dorogaia@testpro.io");
        loginPage.providePassword("te$terthegreat");
        loginPage.clickSubmit();
        //loginPage.login();
        //Expected
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }

    @Test
    public void positiveLoginTestUsingPageFactory(){
        //Objects
        WebDriver driver;
        LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
        HomePage homePage = new HomePage(driver);
        //Steps
        loginPageFactory.provideEmail("elena.dorogaia@testpro.io")
                .providePassword("te$terthegreat")
                .clickSubmitBtn();
        //loginPage.login();
        //Expected vs Actual
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());

    }
}
