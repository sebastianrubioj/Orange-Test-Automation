package stepdefs.orangeSiteStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AccessAdminPage;
import pages.HomePage;
import stepdefs.BaseTest;

import static stepdefs.pageConstants.CommonPageConst.*;
import static stepdefs.pageConstants.LoginConst.*;

public class MaintenancePageStepDef extends BaseTest {

    HomePage home = getHomePage();
    AccessAdminPage accessAdminPage = getAccessAdminPage();

    @When("goes to the Maintenance section")
    public void goesToTheMaintenanceSection() {
        home.selectMaintenanceSection();
    }

    @And("lands in Admin Access page")
    public void landsInAdminAccessPage() {
        accessAdminPage.waitAccessCardContainerPresent();
    }

    @Then("should see the title {string}")
    public void shouldSeeTheTitle(String title) {
        Assert.assertEquals(accessAdminPage.getAccessCardTitle(),title);
    }


    @And("should see the description message")
    public void shouldSeeTheDescriptionMessage() {
        Assert.assertEquals(accessAdminPage.getAdminAccessMessage(),ADMIN_ACCESS_MESSAGE);
    }


    @And("I should see the username contains by default {string} value")
    public void iShouldSeeTheUsernameContainsByDefaultValue(String username) {
        Assert.assertEquals(accessAdminPage.getUsernameInputText(),username,"Expected: '" + username + "' but found: '" + accessAdminPage.getUsernameInputText() + "'");
    }

    @And("should see the username section disabled")
    public void shouldSeeTheUsernameSectionDisabled() {
        Assert.assertTrue(accessAdminPage.validateUsernameInputDisabled());
    }

    @And("should see the password section enabled")
    public void shouldSeeThePasswordSectionEnabled() {
        Assert.assertTrue(accessAdminPage.validatePasswordInputEnabled());
    }

    @And("set a {string} password")
    public void setAPassword(String password) {
        accessAdminPage.setPasswordInput(password);
    }

    @And("clicks on Confirm button")
    public void clicksOnConfirmButton() {
        accessAdminPage.selectConfirmButton();
    }

    @When("clicks on cancel button")
    public void clicksOnCancelButton() {
        accessAdminPage.selectCancelButton();
    }

    @When("clicks on Orange page link")
    public void clicksOnOrangePageLink() {
        accessAdminPage.selectOrangePageLink();
    }

    @Then("should be redirected to the Orange web page")
    public void shouldBeRedirectedToTheOrangeWebPage() {
        Assert.assertEquals(ORANGE_INFO_PAGE_TITLE, accessAdminPage.getPageTitleFromNewTab());
    }
}
