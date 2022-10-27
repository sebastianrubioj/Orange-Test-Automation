package stepdefs.orangeSiteStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.LoginPage;
import pages.ResetPasswordPage;
import stepdefs.BaseTest;

import static stepdefs.pageConstants.LoginConst.*;
import static stepdefs.pageConstants.Urls.*;

public class LoginStepDef extends BaseTest {

    LoginPage login = getLoginPage();
    HomePage home = getHomePage();

    ResetPasswordPage resetPage = getResetPasswordPage();

    @Given("^user is on login page$")
    public void userIsOnLoginPage() {
        goToUrl(LOGIN_URL);
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
        Assert.assertTrue(home.isUserNameDropdownTextPresent());
        Assert.assertEquals(home.getUrl(),HOMEPAGE_URL);
    }


    @When("user set {string} and {string}")
    public void userSetAnd(String username, String password) {
        login.typeUserName(username);
        login.typePassword(password);
    }

    @Then("should see the error message for invalid credentials")
    public void shouldSeeTheErrorMessageForInvalidCredentials() {
        Assert.assertEquals(login.getInvalidCredentialsMessage(), LOGIN_ERROR_MESSAGE);
    }

    @Then("should see the error message for required credentials")
    public void shouldSeeTheErrorMessageForRequiredCredentials() {
        Assert.assertTrue(login.isRequiredCredentialMessagePresent(LOGIN_REQUIRED_MESSAGE));
    }

    @Then("should be redirected to the reset password page")
    public void shouldBeRedirectedToTheResetPasswordPage() {
        Assert.assertEquals(resetPage.getUrl(), RESET_PASSWORD_URL);
    }

    @When("clicks on forgot your password link")
    public void clicksOnForgotYourPasswordLink() {
        login.selectForgotPasswordLink();
    }

    @And("should see the {string} on reset password page")
    public void shouldSeeThe(String element) {
        Assert.assertTrue(resetPage.isElementPresent(element));
    }

}
