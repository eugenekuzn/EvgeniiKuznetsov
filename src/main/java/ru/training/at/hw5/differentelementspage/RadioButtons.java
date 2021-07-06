package ru.training.at.hw5.differentelementspage;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RadioButtons {

    @FindBy(className = "label-radio")
    private List<WebElement> radioButtons;

    public RadioButtons(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickRadioButton(String buttonName) {
        for (WebElement radio : radioButtons) {
            if (buttonName.equals(radio.getText())) {
                radio.click();
            }
        }
    }
}

