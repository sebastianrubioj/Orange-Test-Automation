package stepdefs.orangeSiteStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import pages.PerformancePage;
import stepdefs.BaseTest;

public class PerformancePageStepDef extends BaseTest {

    HomePage home = getHomePage();
    PerformancePage performancePage = getPerformancePage();

    @When("lands in Performance section")
    public void landsInPerformanceSection() {
        home.selectPerformanceSection();
    }

    @And("goes to My Trackers section")
    public void goesToMyTrackersSection() {
        performancePage.selectMyTrackersHeaderTab();
    }

    @When("clicks on view button")
    public void clicksOnViewButton() {
        performancePage.selectViewButton();
    }

    @Then("should see the profile picture")
    public void shouldSeeTheProfilePicture() {
        Assert.assertTrue(performancePage.validateProfilePicturePresent());
    }

    @And("should see the profile header")
    public void shouldSeeTheProfileHeader() {
        Assert.assertTrue(performancePage.validateProfileNameHeaderPresent());
    }

    @And("should see the tracker container with title {string}")
    public void shouldSeeTheTrackerContainerWithTitle(String logHeader) {
        Assert.assertEquals(logHeader, performancePage.getTrackerLogHeader());
    }

    @And("should see the add log button")
    public void shouldSeeTheAddLogButton() {
        Assert.assertTrue(performancePage.validateAddLogButtonPresent());
    }
}
