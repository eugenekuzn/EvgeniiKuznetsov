package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogPanelOfDifferentElementsPage {
    @FindBy(xpath = "//li[contains(text(),'Water')]")
    WebElement logForWaterCheckBox;
    @FindBy(xpath = "//li[contains(text(),'Wind')]")
    WebElement logForWindCheckBox;
    @FindBy(xpath = "//li[contains(text(),'Selen')]")
    WebElement logForSelenRadioButton;
    @FindBy(xpath = "//li[contains(text(),'Yellow')]")
    WebElement logForYellowOption;

    protected LogPanelOfDifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getLogForWaterCheckBox() {
        return logForWaterCheckBox.getText();
    }

    public String getLogForWindCheckBox() {
        return logForWindCheckBox.getText();
    }

    public String getLogForSelenRadioButton() {
        return logForSelenRadioButton.getText();
    }

    public String getLogForYellowOption() {
        return logForYellowOption.getText();
    }
}
