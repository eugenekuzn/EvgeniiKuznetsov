package ru.training.at.hw4.homepageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftSideMenuOfHomePageObjects {
    @FindBy(xpath = "//span[text() = 'Home']")
    private WebElement leftHomeLink;
    @FindBy(xpath = "//span[text() = 'Contact form']")
    private WebElement leftContactFormLink;
    @FindBy(xpath = "//span[text() = 'Service']")
    private WebElement leftServiceLink;
    @FindBy(xpath = "//span[text() = 'Metals & Colors']")
    private WebElement leftMetalNColorLink;
    @FindBy(xpath = "//span[text() = 'Elements packs']")
    private WebElement leftElementsPacksLink;

    protected LeftSideMenuOfHomePageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getLeftSideMenuElementText(String nameOfCheckingElement) {
        switch (nameOfCheckingElement) {
            case "Home":
                return leftHomeLink.getText();
            case "Contact form":
                return leftContactFormLink.getText();
            case "Service":
                return leftServiceLink.getText();
            case "Metals & Colors":
                return leftMetalNColorLink.getText();
            case "Elements packs":
                return leftElementsPacksLink.getText();
            default:
                return "matches not found";
        }
    }
}


