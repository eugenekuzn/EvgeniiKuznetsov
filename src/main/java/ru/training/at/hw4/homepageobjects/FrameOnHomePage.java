package ru.training.at.hw4.homepageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrameOnHomePage {
    @FindBy(id = "frame-button")
    private WebElement frameButton;

    protected FrameOnHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getFrameButton() {
        return frameButton;
    }
}
