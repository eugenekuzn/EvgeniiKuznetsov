package ru.training.at.hw3.ex1;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw3.HomePage;
import ru.training.at.hw3.NewPage;
import ru.training.at.hw3.TestProperties;

public class LayoutCheckingTest extends TestProperties {

    @Test
    public void layoutCheckingTest() {
        HomePage homePage = new HomePage(webDriver);

        //1. Open test site by URL
        new NewPage(webDriver).open(url);

        //2. Assert Browser title
        Assert.assertEquals(webDriver.getTitle(), "Home Page");

        //3. Perform login
        homePage.login(login, password);

        //4. Assert Username is loggined
        Assert.assertEquals(homePage.getHeaderOfHomePageObjects().getUsername(), "ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        Assert.assertEquals(homePage.getHeaderOfHomePageObjects().getHomeLink().getText(), "HOME");
        Assert.assertEquals(homePage.getHeaderOfHomePageObjects().getContactFormLink().getText(), "CONTACT FORM");
        Assert.assertEquals(homePage.getHeaderOfHomePageObjects().getServiceLink().getText(), "SERVICE");
        Assert.assertEquals(homePage.getHeaderOfHomePageObjects().getMetalNColorLink().getText(), "METALS & COLORS");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        //check the first image
        homePage.getFirstImg().isDisplayed();
        //check the second image
        homePage.getSecondImg().isDisplayed();
        //check the third image
        homePage.getThirdImg().isDisplayed();
        //check the fourth image
        homePage.getFourthImg().isDisplayed();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        //check the first text
        Assert.assertEquals(homePage.getTextUnderFirstImg(), "To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project");
        //check the second text
        Assert.assertEquals(homePage.getTextUnderSecondImg(), "To be flexible and\n"
            + "customizable");
        //check the third text
        Assert.assertEquals(homePage.getTextUnderThirdImg(), "To be multiplatform");
        //check the fourth text
        Assert.assertEquals(homePage.getTextUnderFourthImg(), "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…");

        //8. Assert that there is the iframe with “Frame Button” exist
        homePage.getIFrame().isDisplayed();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame(homePage.getIFrame());
        homePage.getFrameOnHomePage().getFrameButton().isDisplayed();

        //10. Switch to original window back
        webDriver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        Assert.assertEquals(homePage.getLeftSideMenuOfHomePageObjects().getLeftHomeLink().getText(), "Home");
        Assert.assertEquals(homePage.getLeftSideMenuOfHomePageObjects().getLeftContactFormLink().getText(),
            "Contact form");
        Assert.assertEquals(homePage.getLeftSideMenuOfHomePageObjects().getLeftServiceLink().getText(), "Service");
        Assert.assertEquals(homePage.getLeftSideMenuOfHomePageObjects().getLeftMetalNColorLink().getText(),
            "Metals & Colors");
        Assert.assertEquals(homePage.getLeftSideMenuOfHomePageObjects().getLeftElementsPacksLink().getText(),
            "Elements packs");
    }
}

