import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    WebDriver driver = null;

    ChromeOptions options = new ChromeOptions();

    WebDriverWait wait;

    Wait fluentWait;

    Actions actions;

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
}