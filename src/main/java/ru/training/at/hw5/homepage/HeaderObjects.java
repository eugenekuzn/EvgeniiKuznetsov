package ru.training.at.hw5.homepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderObjects {
    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(className = "dropdown-toggle")
    private WebElement serviceLink;
    @FindBy(xpath = "//a[text() = 'Different elements']")
    private WebElement differentElementsSubLink;

    @FindBy(xpath = "//a[text() = 'User Table ']")
    private WebElement userTableSubLink;

    protected HeaderObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    protected String getUsername() {
        return username.getText();
    }

    protected void goToDifferentElementsPage() {
        differentElementsSubLink.click();
    }

    protected void clickOnServiceLink() {
        serviceLink.click();
    }

    protected void clickOnUserTableLink() {
        userTableSubLink.click();
    }
}
