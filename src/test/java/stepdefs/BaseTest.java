package stepdefs;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.ResetPasswordPage;

import static stepdefs.Hooks.getDriver;

public class BaseTest {

    public WebDriver myDriver = getDriver();

    public LoginPage getLoginPage() {
        return new LoginPage(myDriver);
    }

    public HomePage getHomePage(){
        return new HomePage(myDriver);
    }

    public void goToUrl(String url){
        myDriver.get(url);
    }

    public ResetPasswordPage getResetPasswordPage(){
        return new ResetPasswordPage(myDriver);
    }

}
