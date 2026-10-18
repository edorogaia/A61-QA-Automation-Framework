import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;

public class BaseTest {

    public static WebDriver driver = null;
    public ChromeOptions = new ChromeOptions();
    public WebDriverWait wait;
    public Wait<WebDriver> fluentWait;
    public Actions actions = null;

    private static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }



    @BeforeMethod
    @Parameters({"BaseURL"})
    public void setBrowser(String baseURL) throws MalformedURLException {
        driver = pickBrowser(System.getProperty("browser"));
        threadDriver.set(pickBrowser(System.getProperty("browser")));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().manage().window().maximize();
        navigateToPage(baseURL);

    }


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

        public static WebDriver getDriver(){
        return threadDriver.get();
        }

        protected void enterEmail(String email) {
            //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
            Instant wait;
            WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated
                    (By.cssSelector("input[type='email']")));
            emailField.clear();
            emailField.sendKeys(email);
        }

        public void navigateToPage(String url) {
            getDriver().get(url);
    }

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

            switch (browser){
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

                case "cloud":
                    return lambdaTest();

                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    return driver = new ChromeDriver(chromeOptions);
            }
        }

    public static WebDriver lambdaTest() throws MalformedURLException{

        String hubUrl = "https://hub.lambdatest.com/wd/hub";

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("dev");
        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
        ltOptions.put("username", "elenadorogaia");
        ltOptions.put("accessKey", "LT_WAOgSxRoISw1gbHYcK1kxLaN4jGFporltiHYZ7t1pG9Dsgd");
        ltOptions.put("project", "Untitled");
        ltOptions.put("selenium_version", "4.0.0");
        ltOptions.put("w3c", true);
        browserOptions.setCapability("LT:Options", ltOptions);

        return new RemoteWebDriver(new URL(hubUrl), browserOptions);

    }
}

    @AfterMethod
    public void tearDown(){
        threadDriver.get().close();
        threadDriver.remove();
    }

    public void closeBrowser(){
        driver.quit();
    }

    protected void submit() throws InterruptedException {
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        WebElement submit = wait.until
                (ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        submit.click();


}

void main() {
}
