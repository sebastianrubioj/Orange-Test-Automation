package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

    private final String USERNAME_DROPDOWN = "oxd-userdropdown-name";

    @FindBy(className = USERNAME_DROPDOWN)
    WebElement userNameDropdown;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public String getUserNameDropdownText(){
        getWait().until(ExpectedConditions.visibilityOf(userNameDropdown));
        return userNameDropdown.getText();
    }
}
