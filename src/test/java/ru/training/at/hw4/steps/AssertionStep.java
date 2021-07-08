package ru.training.at.hw4.steps;

import io.qameta.allure.Step;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AssertionStep extends AbstractStep {

    public AssertionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Assert Browser title")
    public void assertHomePageIsOpened(String nameOfPage) {
        Assert.assertEquals(driver.getTitle(), nameOfPage);
    }

    @Step("Assert Username is loggined")
    public void assertUsernameIsLogged(String checkingUsername) {
        Assert.assertEquals(homePage.getHeaderOfHomePageObjects().getUsername(), checkingUsername);
    }

    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertHeaderElementsAreDisplayed(String[] checkingElements) {
        List<String> headerElements = Arrays.asList(checkingElements);
        headerElements
            .forEach(currentElement -> Assert
                .assertEquals(homePage.getHeaderOfHomePageObjects().getHeaderElementText(currentElement),
                    currentElement));
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void assertAllImageIsDisplayed() {
        homePage.getFirstImg().isDisplayed();
        homePage.getSecondImg().isDisplayed();
        homePage.getThirdImg().isDisplayed();
        homePage.getFourthImg().isDisplayed();
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertTextUnderImagesAreDisplayed(String[] checkingElements) {
        List<String> textUnderImages = Arrays.asList(checkingElements);
        textUnderImages
            .forEach(currentElement -> Assert
                .assertEquals(homePage.getTextUnderImages(currentElement),
                    currentElement));
    }

    @Step("Assert that there is the iframe with 'Frame Button' exist")
    public void assertFrameExist() {
        homePage.getIFrame().isDisplayed();
    }

    @Step("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void assertLeftSideMenuElementsAreDisplayed(String[] checkingElements) {
        List<String> leftSideMenuElements = Arrays.asList(checkingElements);
        leftSideMenuElements
            .forEach(currentElement -> Assert
                .assertEquals(homePage.getLeftSideMenuOfHomePageObjects().getLeftSideMenuElementText(currentElement),
                    currentElement));
    }

    @Step("Assert that all logs row and values are corresponded to the status")
    public void assertLogRowNStatus(String[] checkingElements) {
        List<String> logRowElements = Arrays.asList(checkingElements);
        logRowElements
            .forEach(currentElement -> Assert
                .assertTrue(differentElementsPage.getLogPanelOfDifferentElementsPage().getLogText(currentElement)
                                                 .contains(currentElement)));
    }
}

