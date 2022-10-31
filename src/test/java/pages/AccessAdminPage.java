package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.utils.CommonPage;
import pages.utils.Utils;

public class AccessAdminPage extends CommonPage {

    private final String ADMIN_ACCESS_CARD_CONTAINER = "orangehrm-card-container";
    private final String ADMIN_ACCESS_CARD_TITLE = "orangehrm-admin-access-title";
    private final String ADMIN_ACCESS_MESSAGE = "oxd-text--toast-message";
    private final String USERNAME_INPUT = "//label[text()='Username']/parent::div/following-sibling::div/input";
    private final String PASSWORD_INPUT = "//label[text()='Password']/parent::div/following-sibling::div/input";
    private final String CONFIRM_BUTTON = "//button[text()=' Confirm ']";
    private final String CANCEL_BUTTON = "//button[text()=' Cancel ']";
    private final String ORANGE_PAGE_LINK = ".orangehrm-copyright a";


    Utils util = new Utils(getDriver());
    @FindBy(className = ADMIN_ACCESS_CARD_CONTAINER)
    WebElement adminAccessCardContainer;
    @FindBy(className = ADMIN_ACCESS_CARD_TITLE)
    WebElement adminAccessCardTitle;
    @FindBy(className = ADMIN_ACCESS_MESSAGE)
    WebElement adminAccessCardMessage;
    @FindBy(xpath = USERNAME_INPUT)
    WebElement usernameInput;
    @FindBy(xpath = PASSWORD_INPUT)
    WebElement passwordInput;

    @FindBy(xpath = CONFIRM_BUTTON)
    WebElement confirmButton;

    @FindBy(xpath = CANCEL_BUTTON)
    WebElement cancelButton;
    @FindBy(css = ORANGE_PAGE_LINK)
    WebElement orangePageLink;
    public AccessAdminPage(WebDriver myDriver){
        super(myDriver);
    }
    public void waitAccessCardContainerPresent(){
        getWait().until(ExpectedConditions.visibilityOf(adminAccessCardContainer));
    }

    public String getAccessCardTitle(){
        return adminAccessCardTitle.getText();
    }

    public String getAdminAccessMessage(){
        return adminAccessCardMessage.getText();
    }

    public boolean validateUsernameInputDisabled(){
        return !usernameInput.isEnabled();
    }

    public String getUsernameInputText(){
        return usernameInput.getAttribute("value");
    }

    public boolean validatePasswordInputEnabled(){
        return passwordInput.isEnabled();
    }

    public void setPasswordInput(String password){
        getWait().until(ExpectedConditions.visibilityOf(passwordInput));
        passwordInput.sendKeys(password);
    }

    public void selectConfirmButton(){
        util.clickElement(confirmButton);
    }

    public void selectCancelButton(){
        util.clickElement(cancelButton);
    }

    public void selectOrangePageLink(){
        util.clickElement(orangePageLink);
    }
}
