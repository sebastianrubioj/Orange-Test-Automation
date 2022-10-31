package stepdefs;

import org.openqa.selenium.WebDriver;
import pages.*;
import pages.utils.Utils;

import static stepdefs.Hooks.getDriver;

public class BaseTest {

    public WebDriver myDriver = getDriver();

    public LoginPage getLoginPage() {
        return new LoginPage(myDriver);
    }

    public HomePage getHomePage() {
        return new HomePage(myDriver);
    }

    public AdminManagementPage getAdminManagementPage() {
        return new AdminManagementPage(myDriver);
    }

    public void goToUrl(String url) {
        myDriver.get(url);
    }

    public ResetPasswordPage getResetPasswordPage() {
        return new ResetPasswordPage(myDriver);
    }

    public AdminPage getAdminPage() {
        return new AdminPage(myDriver);
    }

    public AdminJobPage getAdminJobPage() {
        return new AdminJobPage(myDriver);
    }

    public AccessAdminPage getAccessAdminPage() {
        return new AccessAdminPage(myDriver);
    }

    public PerformancePage getPerformancePage() {
        return new PerformancePage(myDriver);
    }

    public Utils getUtils() {
        return new Utils(myDriver);
    }

}
