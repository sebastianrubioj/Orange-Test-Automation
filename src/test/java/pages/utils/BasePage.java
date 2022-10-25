package pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    protected BasePage(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        Duration timeout = Duration.ofSeconds(30);
        wait = new WebDriverWait(pDriver, timeout);
        driver = pDriver;
    }

    public WebDriverWait getWait(){
        return this.wait;
    }

    public void clickElement(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
