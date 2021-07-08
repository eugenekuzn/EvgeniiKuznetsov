package ru.training.at.hw5.usertablepage;

import java.util.Arrays;
import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class UserTablePage {
    WebDriver driver;
    private UserTableElements userTableElements;

    public UserTablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        userTableElements = new UserTableElements(driver);
    }

    public String getPageName() {
        return driver.getTitle();
    }

    public List<WebElement> getUsernameOnUserTable() {
        return userTableElements.getUsernameOnUserTable();
    }

    public List<WebElement> getDescriptionOnUserTable() {
        return userTableElements.getDescriptionOnUserTable();
    }

    public List<WebElement> getDropdownOptions() {
        return userTableElements.getDropdownsOnUserTable();
    }

    public void numberTypeDropdownIsDisplayed() {
        userTableElements.checkNumberTypeDropdown();
    }

    public void usernamesIsDisplayed(String[] names) {
        List<String> checkingUsernames = Arrays.asList(names);

        checkingUsernames.forEach(name -> Assert.assertEquals(name, userTableElements.getUsername(name)));
    }

    public void descriptionIsDisplayed(String[] textUnderImages) {
        List<String> checkingText = Arrays.asList(textUnderImages);
        checkingText.forEach(
            textUnderImage -> Assert.assertEquals(textUnderImage, userTableElements.getDescription(textUnderImage)));
    }

    public void checkboxesIsDisplayed() {
        userTableElements.checkCheckboxes();
    }
}
