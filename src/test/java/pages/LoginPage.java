package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BasePage{
    private final String USER_NAME_INPUT = "username";
    private final String PASSWORD_INPUT =    "password";
    private final String LOGIN_BUTTON = "button[type='submit']";
    private final String INVALID_CREDENTIALS_MESSAGE = "oxd-alert-content-text";
    private final String REQUIRED_CREDENTIALS_MESSAGE = ".oxd-input-field-error-message.oxd-input-group__message";
    private final String FORGOT_PASSWORD_LINK = "orangehrm-login-forgot-header";


    @FindBy(name = USER_NAME_INPUT)
    WebElement userNameInput;

    @FindBy(name = PASSWORD_INPUT)
    WebElement passwordInput;

    @FindBy(css = LOGIN_BUTTON)
    WebElement loginButton;

    @FindBy(className = INVALID_CREDENTIALS_MESSAGE)
    WebElement invalidCredentialsMessage;

    @FindAll({@FindBy (className = REQUIRED_CREDENTIALS_MESSAGE)})
    List<WebElement> requiredCredentialsMessage;

    @FindBy(className = FORGOT_PASSWORD_LINK)
    WebElement forgotPasswordLink;

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

    public String getInvalidCredentialsMessage(){
        return invalidCredentialsMessage.getText();
    }

    public boolean isRequiredCredentialMessagePresent(String expectedMessage){
        int count = 0;
        for(WebElement message : requiredCredentialsMessage){
            if(message.getText().equals(expectedMessage)){
                count++;
            }
        }
        return count==requiredCredentialsMessage.size();
    }

    public void selectForgotPasswordLink(){
        clickElement(forgotPasswordLink);
    }

}
