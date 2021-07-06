package ru.training.at.hw5.differentelementspage;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage {
    private Checkboxes checkboxes;
    private RadioButtons radioButtons;
    private Dropdowns dropdowns;
    private LogPanel logPanel;

    public DifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        checkboxes = new Checkboxes(driver);
        radioButtons = new RadioButtons(driver);
        dropdowns = new Dropdowns(driver);
        logPanel = new LogPanel(driver);
    }

    public void selectCheckboxes(String item) {
        checkboxes.clickCheckbox(item);
    }

    public void selectSergeyIvanCheckbox() {
        checkboxes.clickSergeyIvanCheckbox();
    }

    public void selectRadioButtons(String item) {
        radioButtons.clickRadioButton(item);
    }

    public void selectDropdowns(String item) {
        dropdowns.clickColorOption(item);
    }

    public void assertTheLogPanelRow(String text) {
        Assert.assertTrue(logPanel.getLogText(text).contains(text));
    }
}
