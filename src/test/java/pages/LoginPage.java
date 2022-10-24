package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    private final String USER_NAME_INPUT = "username";
    private final String PASSWORD_INPUT =    "password";
    private final String LOGIN_BUTTON = "button[type='submit']";


    @FindBy(name = USER_NAME_INPUT)
    WebElement userNameInput;

    @FindBy(name = PASSWORD_INPUT)
    WebElement passwordInput;

    @FindBy(css = LOGIN_BUTTON)
    WebElement loginButton;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void typeUserName(String myUser){
        getWait().until(ExpectedConditions.visibilityOf(userNameInput));
        userNameInput.sendKeys(myUser);
    }

    public void typePassword(String myPassword){
        getWait().until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(myPassword);
    }

    public void clickLoginButton(){
        clickElement(loginButton);
    }

}
