package ru.training.at.hw5.differentelementspage;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkboxes {
    @FindBy(className = "label-checkbox")
    private List<WebElement> checkboxes;
    @FindBy(id = "ivan")
    private WebElement sergeyIvanCheckbox;

    protected Checkboxes(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCheckbox(String checkboxName) {
        for (WebElement checkbox : checkboxes) {
            if (checkboxName.equals(checkbox.getText())) {
                checkbox.click();
            }
        }
    }

    public void clickSergeyIvanCheckbox() {
        sergeyIvanCheckbox.click();
    }
}
