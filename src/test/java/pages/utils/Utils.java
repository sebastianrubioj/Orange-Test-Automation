package pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Utils extends BasePage {

    private final String LOADING_SPINNER = "oxd-loading-spinner";
    private final String RECORDS_TABLE_TITLE = "div.orangehrm-horizontal-padding span.oxd-text.oxd-text--span";
    private final String SELECT_ALL_CHECKBOX_TABLE = "div.oxd-table-header span.oxd-checkbox-input";
    private final String TABLE_CHECKBOX_LIST = "div.oxd-table-body span.oxd-checkbox-input";
    private final String DELETE_SELECTED_BUTTON = "oxd-button--label-danger";


    @FindBy(className = LOADING_SPINNER)
    WebElement loadingSpinner;

    @FindBy(css = RECORDS_TABLE_TITLE)
    WebElement recordsTableTitle;

    @FindBy(css = SELECT_ALL_CHECKBOX_TABLE)
    WebElement selectAllCheckboxTable;

    @FindAll({@FindBy(css = TABLE_CHECKBOX_LIST)})
    List<WebElement> tableCheckboxList;

    @FindBy(className = DELETE_SELECTED_BUTTON)
    WebElement deleteSelectedButton;

    public Utils(WebDriver myDriver) {
        super(myDriver);
    }

    public void waitForSpinnerDisapear() {
        getWait().until(ExpectedConditions.invisibilityOf(loadingSpinner));
    }

    public void typeTextToElement(WebElement element, String text) {
        getWait().until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public boolean tableContainsExpectedUserRole(List<WebElement> elementTable, String expectedElementValue) {
        waitForSpinnerDisapear();
        int count = 0;
        for (WebElement element : elementTable) {
            if (element.getText().equals(expectedElementValue)) {
                count++;
            }
        }
        return count == elementTable.size();
    }

    public int getAmountFromRecordsTitle() {
        String recordsTitle = recordsTableTitle.getText();
        System.out.println(recordsTitle);
        String amount = recordsTitle.substring(recordsTitle.indexOf('('), recordsTitle.indexOf(')'));
        return Integer.parseInt(amount);
    }

    public void setSelectAllCheckboxTable() {
        clickElement(selectAllCheckboxTable);
    }

    public boolean validateAllCheckboxSelected() {
        int checkboxSelected = 0;
        for (WebElement checkbox : tableCheckboxList) {
            if (checkbox.isSelected()) {
                checkboxSelected++;
            }
        }
        return checkboxSelected == tableCheckboxList.size();
    }

    public boolean isDeleteSelectedButtonPresent() {
        return deleteSelectedButton.isDisplayed();
    }

    public String getRecordsTableTitle(){
        return recordsTableTitle.getText();
    }

}
