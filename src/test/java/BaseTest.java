import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.awt.datatransfer.MimeTypeParameterList;
import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;
import java.time.Instant;

public class BaseTest {

    @BeforeSuite
    static void setupClass() {
       //WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
    }


    @BeforeMethod
    @Parameters({"BaseURL"}) {
        public void launchBrowser(String baseURL) throws MalformedURLException {

            // Pre-conditions
            // Added ChromeOptions argument below to fix websocket error
            //options.addArguments("--remote-allow-origins=*");
            //driver = new ChromeDriver(options);
            //driver = new FirefoxDriver();
            driver = pickBrowser(System.getProperty("browser"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            fluentWait = new FluentWait(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(2));
            actions = new Actions(driver);
            navigateToPage(baseURL);
        }

        protected void enterEmail(String email) {
            //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
            Instant wait;
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.cssSelector("input[type='email']")));
            emailField.clear();
            emailField.sendKeys(email);
        }

        protected void navigateToPage(String url) { driver.get(url); }

        public WebElement hoverPlay() {
            By driver;
            WebElement play = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
            Actions actions;
            actions.moveToElement(play).perform();
            return wait.until(ExpectedConditions.visibilityOf(play));
        }

        public static WebDriver pickBrowser(String browser) throws MalformedURLException {

            DesiredCapabilities caps = new DesiredCapabilities();
            String gridURL = "http://192.168.1.206:4444";

            switch (browserName){
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    return driver = new FirefoxDriver();
                case "MicrosoftEdge":
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--remote-allow-origins=*");
                    return driver = new EdgeDriver(edgeOptions);
                    //Grid related browsers
                case "grid-edge":
                    caps.setCapability("browserName", "MicrosoftEdge");
                        return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                case "grid-firefox":
                    caps.setCapability("browserName", "firefox");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);
                case "grid-chrome":
                    caps.setCapability("browserName", "chrome");
                    return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    return driver = new ChromeDriver(chromeOptions);

            }
        }

    }

    private WebDriver pickBrowser(String browser) {
    }

}