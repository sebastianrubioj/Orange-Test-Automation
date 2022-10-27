package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.utils.BasePage;
import pages.utils.CommonPage;
import pages.utils.Utils;

public class AdminJobPage extends CommonPage {

    Utils util = new Utils(getDriver());
    public AdminJobPage(WebDriver myDriver){
        super(myDriver);
    }


}
