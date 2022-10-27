package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.utils.BasePage;

public class AdminPage extends BasePage {

    private final String JOB_DROPDOWN_SELECTOR = "//li/span[text()='Job ']";
    private final String JOB_TITLES_SUBSECTION = "//li/a[text()='Job Titles']";

    @FindBy(xpath = JOB_DROPDOWN_SELECTOR)
    WebElement jobDropdownSelector;

    @FindBy(xpath = JOB_TITLES_SUBSECTION)
    WebElement jobTitlesSubsection;

    public AdminPage(WebDriver myDriver){
        super(myDriver);
    }

    public void goToJobTitlesSectionPage(){
        clickElement(jobDropdownSelector);
        clickElement(jobTitlesSubsection);
    }

}
