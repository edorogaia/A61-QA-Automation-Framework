package PageFactory;

import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory extends BasePage {

public LoginPageFactory(WebDriver givenDriver) {
    super(givenDriver);

    }
    //Page factory Elements
    @FindBy(css = "[type='submit']")
    WebElement submitBtn;
    @FindBy(css = "[type='email']")
    WebElement emailField;
    @FindBy(css = "[type='password']")
    WebElement passwordField;

    //Helper Methods
    public LoginPageFactory clickSubmitBtn() {
        submitBtn.click();
        return this;
    }

    public LoginPageFactory provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPageFactory providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }


}
