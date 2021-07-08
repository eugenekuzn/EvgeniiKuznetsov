package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw4.indexpage.IndexPage;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Open test site by URL")
    public void openHomePage(String url) {
        new IndexPage(driver).open(url);
    }

    @Step("Perform login")
    public void login(String name, String password) {
        homePage.login(name, password);
    }

    @Step("Switch to the iframe and check that there is “Frame Button” in the iframe")
    public void switchNCheckTheFrame() {
        driver.switchTo().frame(homePage.getIFrame());
        homePage.getFrameOnHomePage().getFrameButton().isDisplayed();
    }

    @Step("Switch to original window back")
    public void switchBack() {
        driver.switchTo().defaultContent();
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        homePage.openDifferentElementsPage();
    }

    @Step("Select radio")
    public void selectCheckbox(String checkboxName) {
        differentElementsPage.selectCheckbox(checkboxName);
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void selectRadioButton(String buttonName) {
        differentElementsPage.selectRadioButton(buttonName);
    }

    @Step("Select in dropdown")
    public void selectColorOption(String colorName) {
        differentElementsPage.selectColorOption(colorName);
    }
}

