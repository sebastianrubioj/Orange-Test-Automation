package stepdefs.orangeSiteStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import stepdefs.BaseTest;

import static stepdefs.pageConstants.HomePageConst.HOMEPAGE_URL;
import static stepdefs.pageConstants.HomePageConst.USERNAME_DROPDOWN;
import static stepdefs.pageConstants.LoginConst.*;

public class LoginStepDef extends BaseTest {

    LoginPage login = getLoginPage();
    HomePage home = getHomePage();

    @Given("^user is on login page$")
    public void userIsOnLoginPage() {
        myDriver.get(LOGIN_URL);
    }

    @When("^user provide valid credentials$")
    public void userProvideValidCredentials() {
        login.typeUserName(VALID_USERNAME);
        login.typePassword(VALID_PASSWORD);
    }

    @And("^clicks on login button$")
    public void clicksOnLoginButton() {
        login.clickLoginButton();
    }

    @Then("^should be redirected to the homepage$")
    public void shouldBeRedirectedToTheHomepage() {
        Assert.assertEquals(home.getUserNameDropdownText(),USERNAME_DROPDOWN);
        Assert.assertEquals(home.getUrl(),HOMEPAGE_URL);
    }
}
