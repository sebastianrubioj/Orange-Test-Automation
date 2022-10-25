package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import pages.utils.BasePage;
import pages.utils.Utils;

import java.util.List;

public class AdminSectionPage extends BasePage {

    private final String SYSTEM_USERS_FILTER_CONTAINER = "oxd-table-filter";
    private final String USER_ROLE_DROPDOWN = "//div/label[text()='User Role']/parent::div/following-sibling::div";
    private final String USER_ROLE_ADMIN = "//div/span[text()='Admin']";
    private final String USER_ROLE_ESS = "//div/span[text()='ESS']";
    private final String SEARCH_BUTTON = "button[type='submit']";
    private final String USER_ROLE_TABLE_DATA = "div.oxd-table-body div.oxd-table-card div:nth-child(3)";

    Utils util = new Utils(getDriver());

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

    @FindAll({@FindBy (css = USER_ROLE_TABLE_DATA)})
    List<WebElement> userRoleTableData;

    public AdminSectionPage(WebDriver myDriver) {
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

    public void clickOnSearch(){
        clickElement(searchButton);
    }

    public boolean tableContainsExpectedUserRole(String expectedUserRole){
        util.waitForSpinnerDisapear();
        int count = 0;
        for(WebElement userRole : userRoleTableData){
            if(userRole.getText().equals(expectedUserRole)){
                count++;
            }
        }
        return count==userRoleTableData.size();
    }
}
