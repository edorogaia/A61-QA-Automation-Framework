package Pages;

import org.openqa.selenium.By;

public class LogingPage extends BasePage {

    public LogingPage(WebDriver givenDriver) { super(givenDriver); }

    //Elements
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitButton = By.cssSelector("button[type='submit']");


    //Helper Methods

    public void provideEmail(String email) { findElement(emailField).sendKeys(email); }

    public void providePassword(String password) { findElement(passwordField).sendKeys(password); }

    public void clickSubmit() { findElement(submitButton).click(); }

    public void login() {
        provideEmail("elena.dorogaia@testpro.io");
        providePassword("te$terthegreat");
        clickSubmit();
    }
}
