package stepdefs.orangeSiteStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AdminSectionPage;
import pages.HomePage;
import stepdefs.BaseTest;

import static stepdefs.pageConstants.Urls.LOGIN_URL;

public class AdminPageStepDef extends BaseTest {

    HomePage home = getHomePage();
    AdminSectionPage adminPage = getAdminSectionPage();
    @Given("^lands in admin section$")
    public void userIsInAdminSection() {
        home.selectAdminSection();
    }

    @When("selects {string} user role")
    public void selectsUserRole(String userRole) {
        adminPage.selectUserRole(userRole);
    }

    @And("clicks on search button")
    public void clicksOnSearchButton() {
        adminPage.clickOnSearch();
    }

    @Then("should see a list of system users with {string} user role")
    public void shouldSeeAListOfSystemUsersWithUserRole(String userRole) {
        Assert.assertTrue(adminPage.tableContainsExpectedUserRole(userRole));
    }
}
