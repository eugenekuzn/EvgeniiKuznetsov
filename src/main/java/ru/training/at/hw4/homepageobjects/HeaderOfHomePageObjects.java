package ru.training.at.hw4.homepageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderOfHomePageObjects {
    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(xpath = "//a[text() = 'Home']")
    WebElement homeLink;
    @FindBy(xpath = "//a[text() = 'Contact form']")
    WebElement contactFormLink;
    @FindBy(className = "dropdown-toggle")
    WebElement serviceLink;
    @FindBy(xpath = "//a[text() = 'Metals & Colors']")
    WebElement metalsNColorsLink;
    @FindBy(xpath = "//a[text() = 'Different elements']")
    WebElement differentElementsSubLink;

    protected HeaderOfHomePageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getUsername() {
        return username.getText();
    }

    public String getHeaderElementText(String nameOfCheckingElement) {
        switch (nameOfCheckingElement) {
            case "HOME":
                return homeLink.getText();
            case "CONTACT FORM":
                return contactFormLink.getText();
            case "SERVICE":
                return serviceLink.getText();
            case "METALS & COLORS":
                return metalsNColorsLink.getText();
            default:
                return "matches not found";
        }
    }

    public void accessToDifferentElementsPage() {
        serviceLink.click();
        differentElementsSubLink.click();
    }
}
