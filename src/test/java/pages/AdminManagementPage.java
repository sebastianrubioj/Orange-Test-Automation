package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.utils.BasePage;
import pages.utils.Utils;

import java.util.List;

public class AdminManagementPage extends Utils {

    private final String SYSTEM_USERS_FILTER_CONTAINER = "oxd-table-filter";
    private final String USER_ROLE_DROPDOWN = "//div/label[text()='User Role']/parent::div/following-sibling::div";
    private final String USER_ROLE_ADMIN = "//div/span[text()='Admin']";
    private final String USER_ROLE_ESS = "//div/span[text()='ESS']";
    private final String SEARCH_BUTTON = "button[type='submit']";
    private final String USER_ROLE_TABLE_DATA = "div.oxd-table-body div.oxd-table-card div:nth-child(3)";
    private final String STATUS_TYPE_DROPDOWN = "//div/label[text()='Status']/parent::div/following-sibling::div";
    private final String STATUS_TYPE_ENABLED = "//div/span[text()='Enabled']";
    private final String STATUS_TYPE_DISABLED = "//div/span[text()='Disabled']";
    private final String STATUS_TABLE_DATA = "div.oxd-table-body div.oxd-table-card div:nth-child(5)";
    private final String TABLE_RECORDS_HEADER = "orangehrm-vertical-padding";

    private final String SYSTEM_USERNAME_INPUT = "//div/label[text()='Username']/parent::div/following-sibling::div/input";
    private final String SYSTEM_EMPLOYEE_NAME_INPUT = "//div/label[text()='Employee Name']/parent::div/following-sibling::div//input";
    private final String USERNAME_TABLE_DATA = "div.oxd-table-body div.oxd-table-card div:nth-child(2)";
    private final String EMPLOYEE_NAME_TABLE_DATA = "div.oxd-table-body div.oxd-table-card div:nth-child(4)";

    private final String TABLE_DATA_LIST = "div.oxd-table-body div.oxd-table-card div.oxd-padding-cell";
    private final String TOAST_INFO_MESSAGE = "oxd-text--toast-message";
    private final String TABLE_RESULTS = "oxd-table-card";


    @FindBy(className = SYSTEM_USERS_FILTER_CONTAINER)
    WebElement systemUsersFilterContainer;
    @FindBy(xpath = USER_ROLE_DROPDOWN)
    WebElement userRoleDropdown;

    @FindBy(xpath = USER_ROLE_ADMIN)
    WebElement userRoleAdmin;

    @FindBy(xpath = USER_ROLE_ESS)
    WebElement userRoleESS;

    @FindBy(css = SEARCH_BUTTON)
    WebElement searchButton;

    @FindAll({@FindBy(css = USER_ROLE_TABLE_DATA)})
    List<WebElement> userRoleTableData;

    @FindBy(xpath = STATUS_TYPE_DROPDOWN)
    WebElement statusTypeDropdown;

    @FindBy(xpath = STATUS_TYPE_ENABLED)
    WebElement statusTypeEnabled;

    @FindBy(xpath = STATUS_TYPE_DISABLED)
    WebElement statusTypeDisabled;

    @FindAll({@FindBy(css = STATUS_TABLE_DATA)})
    List<WebElement> statusTableData;

    @FindBy(className = TABLE_RECORDS_HEADER)
    WebElement tableRecordsHeader;

    @FindBy(xpath = SYSTEM_USERNAME_INPUT)
    WebElement systemUsernameInput;

    @FindBy(xpath = SYSTEM_EMPLOYEE_NAME_INPUT)
    WebElement systemEmployeeNameInput;

    @FindAll({@FindBy(css = USERNAME_TABLE_DATA)})
    List<WebElement> userNameTableData;

    @FindAll({@FindBy(css = EMPLOYEE_NAME_TABLE_DATA)})
    List<WebElement> employeeNameTableData;

    @FindAll({@FindBy(css = TABLE_DATA_LIST)})
    List<WebElement> tableDataList;

    @FindBy(className = TOAST_INFO_MESSAGE)
    WebElement toastInfoMessage;

    @FindAll({@FindBy(className = TABLE_RESULTS)})
    List<WebElement> tableResults;

    public AdminManagementPage(WebDriver myDriver) {
        super(myDriver);
    }

    public void selectUserRole(String userRole) {
        clickElement(userRoleDropdown);
        if (userRole.equals("Admin")) {
            clickElement(userRoleAdmin);
        } else {
            clickElement(userRoleESS);
        }
    }

    public void clickOnSearch() {
        clickElement(searchButton);
    }

    public boolean tableContainsExpectedUserRole(String expectedUserRole) {
        return tableContainsExpectedUserRole(userRoleTableData, expectedUserRole);
    }

    public void selectStatus(String status) {
        clickElement(statusTypeDropdown);
        if (status.equals("Enabled")) {
            clickElement(statusTypeEnabled);
        } else {
            clickElement(statusTypeDisabled);
        }
    }

    public boolean tableContainsExpectedStatus(String expectedStatus) {
        getWait().until(ExpectedConditions.visibilityOf(tableRecordsHeader));
        return tableContainsExpectedUserRole(statusTableData, expectedStatus);
    }

    public void typeUsername(String username) {
        typeTextToElement(systemUsernameInput, username);
    }

    public boolean validateTableDataResult(String expectedData) {
        getWait().until(ExpectedConditions.visibilityOf(tableRecordsHeader));
        waitForSpinnerDisapear();
        boolean elementPresent = false;
        for (WebElement listData : tableDataList) {
            if (listData.getText().equals(expectedData)) {
                elementPresent = true;
                break;
            }
        }
        return elementPresent;
    }

    public void typeEmployeeName(String employeeName) {
        typeTextToElement(systemEmployeeNameInput, employeeName);
    }

    public boolean tableContainsExpectedUsername(String expectedUsername) {
        return tableContainsExpectedUserRole(userNameTableData, expectedUsername);
    }

    public boolean tableContainsExpectedEmployeeName(String expectedEmployeeName) {
        return tableContainsExpectedUserRole(employeeNameTableData, expectedEmployeeName);
    }

    public String getInfoMessage() {
        getWait().until(ExpectedConditions.visibilityOf(toastInfoMessage));
        return toastInfoMessage.getText();
    }

    public boolean validateEmptyTable() {
        getWait().until(ExpectedConditions.visibilityOf(tableRecordsHeader));
        waitForSpinnerDisapear();
        return tableResults.isEmpty();
    }
}
