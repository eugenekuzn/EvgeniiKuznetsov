package ru.training.at.hw3;

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
            case "Home":
                return homeLink.getText();
            case "Contact form":
                return contactFormLink.getText();
            case "Service":
                return serviceLink.getText();
            case "Metals & Colors":
                return metalsNColorsLink.getText();
            default:
                return null;
        }
    }

    public void accessToDifferentElementsPage() {
        serviceLink.click();
        differentElementsSubLink.click();
    }
}
