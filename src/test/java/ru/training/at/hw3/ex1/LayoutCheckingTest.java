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
        Assert.assertEquals(homePage.getHeaderOfHomePageObjects().getHeaderElementText(home), "HOME");
        Assert.assertEquals(homePage.getHeaderOfHomePageObjects().getHeaderElementText(contactForm), "CONTACT FORM");
        Assert.assertEquals(homePage.getHeaderOfHomePageObjects().getHeaderElementText(service), "SERVICE");
        Assert
            .assertEquals(homePage.getHeaderOfHomePageObjects().getHeaderElementText(metalsNColors), "METALS & COLORS");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        homePage.getFirstImg().isDisplayed();
        homePage.getSecondImg().isDisplayed();
        homePage.getThirdImg().isDisplayed();
        homePage.getFourthImg().isDisplayed();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        Assert.assertEquals(homePage.getTextUnderFirstImg(), "To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project");
        Assert.assertEquals(homePage.getTextUnderSecondImg(), "To be flexible and\n"
            + "customizable");
        Assert.assertEquals(homePage.getTextUnderThirdImg(), "To be multiplatform");
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
        Assert.assertEquals(homePage.getLeftSideMenuOfHomePageObjects().getLeftSideMenuElementText(home), "Home");
        Assert.assertEquals(homePage.getLeftSideMenuOfHomePageObjects().getLeftSideMenuElementText(contactForm),
            "Contact form");
        Assert.assertEquals(homePage.getLeftSideMenuOfHomePageObjects().getLeftSideMenuElementText(service), "Service");
        Assert.assertEquals(homePage.getLeftSideMenuOfHomePageObjects().getLeftSideMenuElementText(metalsNColors),
            "Metals & Colors");
        Assert.assertEquals(homePage.getLeftSideMenuOfHomePageObjects().getLeftSideMenuElementText(elementsPacks),
            "Elements packs");
    }
}

