package ru.training.at.hw4.ex2;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.training.at.hw4.TestConfig;
import ru.training.at.hw4.listener.AllureListener;

@Listeners(AllureListener.class)
public class CheckboxesRadioButtonsNDropdownsCheckingTest extends TestConfig {

    @Feature("Layout Testing")
    @Story("Checking radio buttons, checkboxes and dropdowns work")
    @Test
    public void checkboxesRadioButtonsNDropdownsCheckingTest() {
        //1. Open test site by URL
        actionStep.openHomePage(url);

        //2. Assert Browser title
        assertionStep.assertHomePageIsOpened(checkingPage);

        //3. Perform login
        actionStep.login(login, password);

        //4. Assert Username is loggined
        assertionStep.assertUsernameIsLogged(checkingUserName);

        //5. Open through the header menu Service -> Different Elements Page
        actionStep.openDifferentElementsPage();

        //6. Select checkboxes
        actionStep.selectCheckbox("Water");
        actionStep.selectCheckbox("Wind");

        //7. Select radio
        actionStep.selectRadioButton("Selen");

        //8. Select in dropdown
        actionStep.selectColorOption("Yellow");

        //9. Assert that:
        //9.1 for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //9.2 for radio button there is a log row and value is corresponded to the status of radio button
        //9.3 for dropdown there is a log row and value is corresponded to the selected value
        assertionStep.assertLogRowNStatus(logTextComponents);
    }
}

