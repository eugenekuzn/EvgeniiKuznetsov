package ru.training.at.hw4.differentelementspageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage {
    private final LogPanelOfDifferentElementsPage logPanelOfDifferentElementsPage;

    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;
    @FindBy(className = "label-radio")
    private List<WebElement> radioButtons;
    @FindBy(css = "option")
    private List<WebElement> colorOptions;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        logPanelOfDifferentElementsPage = new LogPanelOfDifferentElementsPage(driver);
    }

    public LogPanelOfDifferentElementsPage getLogPanelOfDifferentElementsPage() {
        return logPanelOfDifferentElementsPage;
    }

    public void selectCheckbox(String checkboxName) {
        for (WebElement checkbox : checkboxes) {
            if (checkboxName.equals(checkbox.getText())) {
                checkbox.click();
            }
        }
    }

    public void selectRadioButton(String buttonName) {
        for (WebElement radio : radioButtons) {
            if (buttonName.equals(radio.getText())) {
                radio.click();
            }
        }
    }

    public void selectColorOption(String colorName) {
        for (WebElement option : colorOptions) {
            if (colorName.equals(option.getText())) {
                option.click();
            }
        }
    }
}
