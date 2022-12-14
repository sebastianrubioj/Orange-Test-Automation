package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.utils.BasePage;
import pages.utils.CommonPage;
import pages.utils.Utils;

public class HomePage extends CommonPage {

    private final String USERNAME_DROPDOWN = "oxd-userdropdown-name";
    private final String ADMIN_MENU_SECTION = "a[href='/web/index.php/admin/viewAdminModule']";
    private final String MAINTENANCE_MENU_SECTION = "a[href='/web/index.php/maintenance/viewMaintenanceModule']";
    private final String PERFORMANCE_MENU_SECTION = "a[href='/web/index.php/performance/viewPerformanceModule']";
    private final String SECTION_PAGE_HEADER = "oxd-topbar-header-breadcrumb-module";
    Utils util = new Utils(getDriver());
    @FindBy(className = USERNAME_DROPDOWN)
    WebElement userNameDropdown;

    @FindBy(css = ADMIN_MENU_SECTION)
    WebElement adminMenuSection;
    @FindBy(css = MAINTENANCE_MENU_SECTION)
    WebElement maintenanceMenuSection;
    @FindBy(css = PERFORMANCE_MENU_SECTION)
    WebElement performanceMenuSection;

    @FindBy(className = SECTION_PAGE_HEADER)
    WebElement sectionPageHeader;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public boolean isUserNameDropdownTextPresent(){
        getWait().until(ExpectedConditions.visibilityOf(userNameDropdown));
        return userNameDropdown.isEnabled();
    }

    public void selectAdminSection(){
        util.clickElement(adminMenuSection);
    }

    public void selectMaintenanceSection(){
        util.clickElement(maintenanceMenuSection);
    }
    public void selectPerformanceSection(){util.clickElement(performanceMenuSection);}

    public boolean validateSectionHeader(String sectionName){
        return sectionPageHeader.getText().equals(sectionName);
    }
}
