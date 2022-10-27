package pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

import java.util.List;

public class CommonPage extends BasePage {
    private final String LOADING_SPINNER = "oxd-loading-spinner";
    private final String RECORDS_TABLE_TITLE = "div.orangehrm-horizontal-padding span.oxd-text.oxd-text--span";
    private final String SELECT_ALL_CHECKBOX_TABLE = "div.oxd-table-header span.oxd-checkbox-input";
    private final String TABLE_CHECKBOX_LIST = "//div[@class='oxd-table-body']//input";
    private final String TABLE_CHECKBOX_LIST_SELECTION = "//div[@class='oxd-table-body']//span";
    private final String DELETE_SELECTED_BUTTON = "oxd-button--label-danger";
    private final String HEADER_TITLE = "div.orangehrm-header-container h6.orangehrm-main-title";
    private final String ADD_BUTTON = "//button[text()=' Add ']";
    private final String TABLE_COLUMN_HEADER = "div.oxd-table-header div.oxd-table-header-cell";

    Utils util = new Utils(getDriver());
    Random random = new Random();
    @FindBy(className = LOADING_SPINNER)
    WebElement loadingSpinner;

    @FindBy(css = RECORDS_TABLE_TITLE)
    WebElement recordsTableTitle;

    @FindBy(css = SELECT_ALL_CHECKBOX_TABLE)
    WebElement selectAllCheckboxTable;
    @FindAll({@FindBy(xpath = TABLE_CHECKBOX_LIST)})
    List<WebElement> tableCheckboxList;
    @FindAll({@FindBy(xpath = TABLE_CHECKBOX_LIST_SELECTION)})
    List<WebElement> tableCheckboxListSelection;

    @FindBy(className = DELETE_SELECTED_BUTTON)
    WebElement deleteSelectedButton;

    @FindBy(css = HEADER_TITLE)
    WebElement headerTitle;

    @FindBy(xpath = ADD_BUTTON)
    WebElement addButton;

    @FindAll({@FindBy(css = TABLE_COLUMN_HEADER)})
    List<WebElement> tableColumnHeader;

    public CommonPage(WebDriver myDriver) {
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
        waitForSpinnerDisapear();
        String recordsTitle = recordsTableTitle.getText();
        System.out.println(recordsTitle);
        String amount = recordsTitle.replaceAll("[^0-9]", "");
        return Integer.parseInt(amount);
    }

    public void setSelectAllCheckboxTable() {
        util.clickElement(selectAllCheckboxTable);
    }

    public boolean validateAllCheckboxSelected() {
        waitForSpinnerDisapear();
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

    public String getRecordsTableTitle() {
        waitForSpinnerDisapear();
        return recordsTableTitle.getText();
    }

    public String getHeaderTitle() {
        getWait().until(ExpectedConditions.visibilityOf(headerTitle));
        return headerTitle.getText();
    }

    public boolean validateAddButtonPresent() {
        return addButton.isDisplayed();
    }

    public boolean validateColumnHeaderTitlePresent(String expectedColumnTitle) {
        boolean expectedColumnTitlePresent = false;
        for (WebElement columnTitle : tableColumnHeader) {
            if (columnTitle.getText().equals(expectedColumnTitle)) {
                expectedColumnTitlePresent = true;
                break;
            }
        }
        return expectedColumnTitlePresent;
    }

    public boolean validateOneCheckboxSelected() {
        waitForSpinnerDisapear();
        int checkboxSelected = 0;
        for (WebElement checkbox : tableCheckboxList) {
            if (checkbox.isSelected()) {
                checkboxSelected++;
            }
        }
        return checkboxSelected == 1;
    }

    public void setSelectOneCheckboxFromTable() {
        waitForSpinnerDisapear();
        int indexElementToCheck = random.nextInt(tableCheckboxList.size());
        util.clickElement(tableCheckboxListSelection.get(indexElementToCheck));
    }
}
