package pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class Utils extends BasePage {


    public Utils(WebDriver myDriver) {
        super(myDriver);
    }

    public void clickElement(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public WebDriver changeOfTab() {
        String currentHandle = getDriver().getWindowHandle();
        Set<String> allHandles = getDriver().getWindowHandles();
        allHandles.remove(currentHandle);
        getDriver().switchTo().window((String) allHandles.toArray()[0]);
        return getDriver();
    }
}
