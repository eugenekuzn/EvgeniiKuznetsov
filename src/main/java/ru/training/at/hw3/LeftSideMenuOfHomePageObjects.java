package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftSideMenuOfHomePageObjects {
    @FindBy(xpath = "//span[text() = 'Home']")
    WebElement leftHomeLink;
    @FindBy(xpath = "//span[text() = 'Contact form']")
    WebElement leftContactFormLink;
    @FindBy(xpath = "//span[text() = 'Service']")
    WebElement leftServiceLink;
    @FindBy(xpath = "//span[text() = 'Metals & Colors']")
    WebElement leftMetalNColorLink;
    @FindBy(xpath = "//span[text() = 'Elements packs']")
    WebElement leftElementsPacksLink;

    protected LeftSideMenuOfHomePageObjects(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getLeftHomeLink() {
        return leftHomeLink;
    }

    public WebElement getLeftContactFormLink() {
        return leftContactFormLink;
    }

    public WebElement getLeftServiceLink() {
        return leftServiceLink;
    }

    public WebElement getLeftMetalNColorLink() {
        return leftMetalNColorLink;
    }

    public WebElement getLeftElementsPacksLink() {
        return leftElementsPacksLink;
    }
}


