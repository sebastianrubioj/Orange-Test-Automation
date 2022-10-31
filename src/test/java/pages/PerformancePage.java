package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.utils.CommonPage;
import pages.utils.Utils;

public class PerformancePage extends CommonPage {

    private final String MY_TRACKERS_HEADER_TAB = "//li/a[text()='My Trackers']";
    private final String VIEW_BUTTON = "button[name='view']";
    private final String PROFILE_TRACKER_CONTAINER = "orangehrm-employee-tracker";
    private final String PROFILE_PICTURE = "employee-image";
    private final String PROFILE_NAME_HEADER = "orangehrm-employee-tracker-header";
    private final String TRACKER_LOG_HEADER = "orangehrm-employee-tracker-list-header";

    private final String ADD_LOG_BUTTON = "//button[text()=' Add Log ']";
    Utils util = new Utils(getDriver());

    @FindBy(xpath = MY_TRACKERS_HEADER_TAB)
    WebElement myTrackersHeaderTab;

    @FindBy(css = VIEW_BUTTON)
    WebElement viewButton;

    @FindBy(className = PROFILE_TRACKER_CONTAINER)
    WebElement profileTrackerContainer;

    @FindBy(className = PROFILE_PICTURE)
    WebElement profilePicture;
    @FindBy(className = PROFILE_NAME_HEADER)
    WebElement profileNameHeader;

    @FindBy(className = TRACKER_LOG_HEADER)
    WebElement trackerLogHeader;
    @FindBy(xpath = ADD_LOG_BUTTON)
    WebElement addLogButton;

    public PerformancePage(WebDriver myDriver) {
        super(myDriver);
    }

    public void selectMyTrackersHeaderTab() {
        util.clickElement(myTrackersHeaderTab);
    }

    public void selectViewButton() {
        util.clickElement(viewButton);
    }

    public boolean validateProfilePicturePresent() {
        getWait().until(ExpectedConditions.visibilityOf(profileTrackerContainer));
        return profilePicture.isDisplayed();
    }

    public boolean validateProfileNameHeaderPresent() {
        getWait().until(ExpectedConditions.visibilityOf(profileTrackerContainer));
        return profileNameHeader.isDisplayed();
    }

    public String getTrackerLogHeader() {
        getWait().until(ExpectedConditions.visibilityOf(trackerLogHeader));
        return trackerLogHeader.getText();
    }

    public boolean validateAddLogButtonPresent() {
        waitForSpinnerDisapear();
        return addLogButton.isDisplayed();
    }

}
