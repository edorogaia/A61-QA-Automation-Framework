import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {


    protected void submit() throws InterruptedException {
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector("button[type='submit']")));
        submit.click();
    }

    protected void enterPassword(String password) {
        //WebElement passwordFailed = driver.findElement(By.cssSelector(input[type='password']"));
        WebElement passwordFailed = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(input[type="password"]")));
        passwordFailed.clear();
         passwordFailed.sendKeys(password);

    }

    protected void enterEmail(String email) {
        //WebElement emailFailed = driver.findElement(By.cssSelector(input[type='password']"));
        WebElement emailFailed = wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.cssSelector(input[type='password']")));
         emailFailed.clear();
        emailFailed.sendKeys(email);

    }

    WebDriverWait wait;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
}

@BeforeMethod
@Parameters({"BaseURL"})
public void LaunchBrowser(String baseURL){
    // Pre-condition
    // Added ChromeOptions argument below to fix websocket error
    options.addArguments("--remote-allow-origins=*");
    driver = new CromeDriver(options);
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    navigateToPage(baseURL);

}

@AfterMethod
public void closeBrowser(){
    driver.quit();
}

void main() {
}