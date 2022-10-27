package stepdefs.orangeSiteStepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.AdminJobPage;
import pages.AdminManagementPage;
import pages.AdminPage;
import pages.HomePage;
import stepdefs.BaseTest;

public class AdminPageStepDef extends BaseTest {

    HomePage home = getHomePage();
    AdminManagementPage adminManagementPage = getAdminManagementPage();
    AdminPage adminPage = getAdminPage();
    AdminJobPage adminJobPage = getAdminJobPage();
    private int recordsAmount;

    @Given("^lands in admin section$")
    public void userIsInAdminSection() {
        home.selectAdminSection();
    }

    @When("selects {string} user role")
    public void selectsUserRole(String userRole) {
        adminManagementPage.selectUserRole(userRole);
    }

    @And("clicks on search button")
    public void clicksOnSearchButton() {
        adminManagementPage.clickOnSearch();
    }

    @Then("should see a list of system users with {string} user role")
    public void shouldSeeAListOfSystemUsersWithUserRole(String userRole) {
        Assert.assertTrue(adminManagementPage.tableContainsExpectedUserRole(userRole));
    }

    @When("selects {string} status")
    public void selectsStatus(String status) {
        adminManagementPage.selectStatus(status);
    }

    @Then("should see a list of system users with {string} status")
    public void shouldSeeAListOfSystemUsersWithStatus(String status) {
        Assert.assertTrue(adminManagementPage.tableContainsExpectedStatus(status));
    }

    @When("type the system user name {string}")
    public void typeTheSystemUserName(String username) {
        adminManagementPage.typeUsername(username);
    }

    @Then("should see the records table with {string}")
    public void shouldSeeTheRecordsTableWith(String data) {
        Assert.assertTrue(adminManagementPage.validateTableDataResult(data));
    }

    @When("type the system employee name {string}")
    public void typeTheSystemEmployeeName(String employeeName) {
        adminManagementPage.typeEmployeeName(employeeName);
    }

    @Then("should see the records table with {string} username only")
    public void shouldSeeTheRecordsTableWithUsernameOnly(String username) {
       Assert.assertTrue( adminManagementPage.tableContainsExpectedUsername(username), "The table result is showing data from different employee name, expected only "+ username);
    }

    @Then("should see the records table with {string} employee name only")
    public void shouldSeeTheRecordsTableWithEmployeeNameOnly(String employeeName) {
        Assert.assertTrue(adminManagementPage.tableContainsExpectedEmployeeName(employeeName),"The table result is showing data from different employee name, expected only "+ employeeName);
    }

    @Then("should see the notification info with message {string}")
    public void shouldSeeTheNotificationInfoWithMessage(String messageExpected) {
        Assert.assertEquals(adminManagementPage.getInfoMessage(), messageExpected,"massage mismatch, expected: '" + messageExpected+"' but found: '" + adminManagementPage.getInfoMessage()+"'");
    }

    @And("should not see any result in the records table")
    public void shouldNotSeeAnyResultInTheRecordsTable() {
        Assert.assertTrue(adminManagementPage.validateEmptyTable());
    }

    @And("goes to Job Titles section")
    public void goesToJobTitlesSection() {
        adminPage.goToJobTitlesSectionPage();
    }

    @When("verifies the total amount of records")
    public void verifiesTheTotalAmountOfRecords() {
        recordsAmount = adminJobPage.getAmountFromRecordsTitle();
    }

    @And("selects the checkbox for all results")
    public void selectsTheCheckboxForAllResults() {
        adminJobPage.setSelectAllCheckboxTable();
    }

    @Then("should see all the records selected")
    public void shouldSeeAllTheRecordsSelected() {
        Assert.assertTrue(adminJobPage.validateAllCheckboxSelected());
    }

    @And("should appear the Delete Selected option button")
    public void shouldAppearTheDeleteSelectedOptionButton() {
        Assert.assertTrue(adminJobPage.isDeleteSelectedButtonPresent());
    }

    @And("should see the table tittle with the message {string}")
    public void shouldSeeTheTableTittleWithTheMessage(String expectedTitle) {
        Assert.assertTrue(adminJobPage.getRecordsTableTitle().contains(expectedTitle));
    }

    @And("should see the table tittle with the total amount of records verified previously")
    public void shouldSeeTheTableTittleWithTheTotalAmountOfRecordsVerifiedPreviously() {
        Assert.assertEquals(adminJobPage.getAmountFromRecordsTitle(),recordsAmount);
    }
}
