import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

import static sun.swing.SwingUtilities2.submit;

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
    public void LoginValidEmailPasswordWithFluentWait() throws InterruptedException{

        //navigateToPage();
        enterEmail("elena.dorogaia@testpro.io");
        enterPassword("te$terthegreat");
        submit();
        //WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        WebElement avatarIcon = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("img[class='avatar']")));
        //Expected Result
        Assert.assertTrue(avatarIcon.isDisplayed());

        
    }

    private void submit() {
    }

    private void enterPassword(String te$terthegreat) {
    }

    private void enterEmail(String mail) {
    }

    @Test(dataProvider = "NegativeLoginTestData",dataProviderClass = TestDataProvider.class)
    public void negativeLoginTest(String email, String password) throws InterruptedException {
        String expectedURL = "https://qa.koel.app/";
        enterEmail(email);
        enterPassword(password);
        submit();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    //Login Test using Page Object Model

    @Test
    public void positiveLoginTest(){
        //Objects
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //Steps
        loginPage.provideEmail("elena.dorogaia@testpro.io");
        loginPage.providePassword("te$terthegreat");
        loginPage.clickSubmit();

        //Expected
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }

    @Test(dataProvider = "NegativeLoginTestData",dataProviderClass = TestDataProvider.class)
    public void negativeLoginTests(String email, String password){
        String expectedURL = "https://qa.koel.app/";
        //Objects
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        //Steps
        loginPage.provideEmail(email);
        loginPage.providePassword(password);
        loginPage.clickSubmit();
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);
    }
}

