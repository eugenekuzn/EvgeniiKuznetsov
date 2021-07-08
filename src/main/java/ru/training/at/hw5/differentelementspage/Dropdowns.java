package ru.training.at.hw5.differentelementspage;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dropdowns {

    @FindBy(css = "option")
    private List<WebElement> colorOptions;

    public Dropdowns(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickColorOption(String colorName) {
        for (WebElement option : colorOptions) {
            if (colorName.equals(option.getText())) {
                option.click();
            }
        }
    }
}
