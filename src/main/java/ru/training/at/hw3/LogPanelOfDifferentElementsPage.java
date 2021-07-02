package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogPanelOfDifferentElementsPage {
    @FindBy(xpath = "//li[contains(text(),'Water')]")
    private WebElement logForWaterCheckBox;
    @FindBy(xpath = "//li[contains(text(),'Wind')]")
    private WebElement logForWindCheckBox;
    @FindBy(xpath = "//li[contains(text(),'Selen')]")
    private WebElement logForSelenRadioButton;
    @FindBy(xpath = "//li[contains(text(),'Yellow')]")
    private WebElement logForYellowOption;

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
