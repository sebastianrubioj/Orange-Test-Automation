package pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Utils extends BasePage{

    private static final String LOADING_SPINNER = "oxd-loading-spinner";

    @FindBy(className = LOADING_SPINNER)
    WebElement loadingSpinner;

    public Utils(WebDriver myDriver){
        super(myDriver);
    }

    public void waitForSpinnerDisapear(){
        getWait().until(ExpectedConditions.invisibilityOf(loadingSpinner));
    }
}
