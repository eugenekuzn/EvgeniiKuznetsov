package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderOfHomePageObjects {
    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(xpath = "//*[@href=\"index.html\"]")
    WebElement homeLink;
    @FindBy(xpath = "//*[@href=\"contacts.html\"]")
    WebElement contactFormLink;
    @FindBy(className = "dropdown-toggle")
    WebElement serviceLink;
    @FindBy(xpath = "//*[@href=\"metals-colors.html\"]")
    WebElement metalNColorLink;
    @FindBy(xpath = "//a[text() = 'Different elements']")
    WebElement differentElementsSubLink;

    protected HeaderOfHomePageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getUsername() {
        return username.getText();
    }

    public WebElement getHomeLink() {
        return homeLink;
    }

    public WebElement getContactFormLink() {
        return contactFormLink;
    }

    public WebElement getServiceLink() {
        return serviceLink;
    }

    public WebElement getMetalNColorLink() {
        return metalNColorLink;
    }

    public WebElement getDifferentElementsSubLink() {
        return differentElementsSubLink;
    }
}
