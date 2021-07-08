package ru.training.at.hw5.homepage;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private HeaderObjects headerObjects;

    @FindBy(className = "profile-photo")
    private WebElement profileMenu;
    @FindBy(id = "name")
    private WebElement loginInputField;
    @FindBy(id = "password")
    private WebElement passwordInputField;
    @FindBy(id = "login-button")
    private WebElement submitButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        headerObjects = new HeaderObjects(driver);
    }

    public void login(String username, String password) {
        profileMenu.click();
        loginInputField.sendKeys(username);
        passwordInputField.sendKeys(password);
        submitButton.click();
    }

    public void assertUsernameIsLogged(String checkingUsername) {
        Assert.assertEquals(this.headerObjects.getUsername(), checkingUsername);
    }

    public void openDifferentElementsPage() {
        headerObjects.goToDifferentElementsPage();
    }

    public void clickOnServiceButton() {
        headerObjects.clickOnServiceLink();
    }

    public void clickOnUserTableLink() {
        headerObjects.clickOnUserTableLink();
    }
}
