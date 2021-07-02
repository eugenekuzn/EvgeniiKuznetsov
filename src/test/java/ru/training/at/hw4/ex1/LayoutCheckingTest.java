package ru.training.at.hw4.ex1;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import ru.training.at.hw4.TestConfig;

public class LayoutCheckingTest extends TestConfig {

    @Feature("Layout Testing")
    @Story("Checking the layout")
    @Test
    public void layoutCheckingTest() {
        //1. Open test site by URL
        actionStep.openHomePage(url);

        //2. Assert Browser title
        assertionStep.assertHomePageIsOpened(checkingPage);

        //3. Perform login
        actionStep.login(login, password);

        //4. Assert Username is loggined
        assertionStep.assertUsernameIsLogged(checkingUserName);

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        assertionStep.assertHeaderElementsAreDisplayed(headerElements);

        //6. Assert that there are 4 images on the Index Page and they are displayed
        assertionStep.assertAllImageIsDisplayed();

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        assertionStep.assertTextUnderImagesAreDisplayed(textUnderImages);

        //8. Assert that there is the iframe with “Frame Button” exist
        assertionStep.assertFrameExist();

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        actionStep.switchNCheckTheFrame();

        //10. Switch to original window back
        actionStep.switchBack();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        assertionStep.assertLeftSideMenuElementsAreDisplayed(leftSideMenuElements);
    }
}

