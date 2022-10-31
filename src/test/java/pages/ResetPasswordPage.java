package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.utils.BasePage;
import pages.utils.CommonPage;

public class ResetPasswordPage extends CommonPage {

    private final String USERNAME_INPUT = "username";
    private final String RESET_PASSWORD_BUTTON = "orangehrm-forgot-password-button--reset";
    private final String CANCEL_BUTTON = "orangehrm-forgot-password-button--cancel";
    private final String RESET_PASSWORD_CONTAINER = "orangehrm-card-container";


    @FindBy(name = USERNAME_INPUT)
    WebElement userNameInput;

    @FindBy(className = RESET_PASSWORD_BUTTON)
    WebElement resetPasswordButton;

    @FindBy(className = CANCEL_BUTTON)
    WebElement cancelButton;

    @FindBy(className = RESET_PASSWORD_CONTAINER)
    WebElement ResetPasswordContainer;

    public ResetPasswordPage(WebDriver myDriver) {
        super(myDriver);
    }

    public boolean isElementPresent(String element){
        getWait().until(ExpectedConditions.visibilityOf(ResetPasswordContainer));
        WebElement elementSelected = null;

        switch (element){
            case "username_input":
                elementSelected = userNameInput;
                break;
            case "reset_password_button":
                elementSelected = resetPasswordButton;
                break;
            case "cancel_button":
                elementSelected = cancelButton;
                break;
        }

        return elementSelected.isDisplayed();
    }

}
