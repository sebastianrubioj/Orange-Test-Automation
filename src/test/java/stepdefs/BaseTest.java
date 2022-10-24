package stepdefs;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import static stepdefs.Hooks.getDriver;

public class BaseTest {

    public WebDriver myDriver = getDriver();

    public LoginPage getLoginPage() {
        return new LoginPage(myDriver);
    }

    public HomePage getHomePage(){
        return new HomePage(myDriver);
    }
}
