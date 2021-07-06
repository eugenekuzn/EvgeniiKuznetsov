package ru.training.at.hw5.usertablepage;

import java.util.Arrays;
import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTableElements {
    @FindBy(css = ".user-table > select")
    private List<WebElement> numberTypeDropdowns;
    @FindBy(xpath = "//table[@id = 'user-table']//tbody//td//select//option")
    private List<WebElement> dropdownOptions;
    @FindBy(xpath = "//table[@id = 'user-table']//tbody//tr//a")
    private List<WebElement> usernames;
    @FindBy(css = ".user-descr > span")
    private List<WebElement> descriptionsUnderImage;
    @FindBy(css = ".user-descr > input")
    private List<WebElement> checkboxes;

    protected UserTableElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void checkNumberTypeDropdown() {
        numberTypeDropdowns.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    public String getUsername(String checkingUsernames) {
        for (WebElement webElement : usernames) {
            if (checkingUsernames.equals(webElement.getText())) {
                return webElement.getText();
            }
        }
        return "matches not found";
    }

    public String getDescription(String description) {
        for (WebElement webElement : descriptionsUnderImage) {
            if (webElement.getText().contains(description)) {
                return webElement.getText();
            }
        }
        return "matches not found";
    }

    public String getOption(String option) {
        for (WebElement webElement : dropdownOptions) {
            if (webElement.getText().contains(option)) {
                return webElement.getText();
            }
        }
        return "matches not found";
    }

    public List<WebElement> getDescriptionOnUserTable() {
        return descriptionsUnderImage;
    }

    public List<WebElement> getUsernameOnUserTable() {
        return usernames;
    }

    public List<WebElement> getDropdownsOnUserTable() {
        return dropdownOptions;
    }

    public void checkCheckboxes() {
        checkboxes.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }
}
