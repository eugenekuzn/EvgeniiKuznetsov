package ru.training.at.hw4.differentelementspageobjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogPanelOfDifferentElementsPage {

    @FindBy(css = ".panel-body-list.logs > li")
    private List<WebElement> logElements;

    protected LogPanelOfDifferentElementsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getLogText(String text) {
        for (WebElement log : logElements) {
            if (log.getText().contains(text)) {
                return log.getText();
            }
        }
        return "matches not found";
    }
}
