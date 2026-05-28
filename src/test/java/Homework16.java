import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Homework16 {

@Test
public static void registrationNavigation() {
    //Step.1
    WebDriver driver = new ChromeDriver();
    String url = "https://qa.koel.app/";
    driver.get(url);

    //Step.2
    driver.findElement(By.linkText("Register")).click();

    //Step.3
    String expectedUrl = "https://qa.koel.app/";
    boolean isCorrectPage = driver.getCurrentUrl().contains(expectedUrl);
    assertTrue(isCorrectPage, "Navigation to registration page failed!");

    //Step.4
    driver.quit();
   }
}
