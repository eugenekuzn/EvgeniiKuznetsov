package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage {
    private final LogPanelOfDifferentElementsPage logPanelOfDifferentElementsPage;

    @FindBy(css = ".label-checkbox:nth-of-type(1)")
    WebElement waterCheckBox;
    @FindBy(css = ".label-checkbox:nth-of-type(3)")
    WebElement windCheckBox;
    @FindBy(css = ".label-radio:nth-of-type(4)")
    WebElement selenRadioButton;
    @FindBy(className = "colors")
    WebElement colorsDropdownMenu;
    @FindBy(css = "option:nth-of-type(4)")
    WebElement yellowOption;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        logPanelOfDifferentElementsPage = new LogPanelOfDifferentElementsPage(driver);
    }

    public LogPanelOfDifferentElementsPage getLogPanelOfDifferentElementsPage() {
        return logPanelOfDifferentElementsPage;
    }

    public WebElement getWaterCheckBox() {
        return waterCheckBox;
    }

    public WebElement getWindCheckBox() {
        return windCheckBox;
    }

    public WebElement getSelenRadioButton() {
        return selenRadioButton;
    }

    public WebElement getYellowOption() {
        colorsDropdownMenu.click();
        return yellowOption;
    }
}
