package ru.training.at.hw4.failedtest;

import org.testng.annotations.Test;
import ru.training.at.hw4.TestConfig;

public class FailedTest extends TestConfig {

    @Test
    public void checkboxesRadioButtonsNDropdownsCheckingBadTest() {
        //1. Open test site by URL
        actionStep.openHomePage(url);

        //2. Assert Browser title
        assertionStep.assertHomePageIsOpened(checkingPage);

        //3. Perform login
        actionStep.login(login, password);

        //4. Assert Username is loggined
        assertionStep.assertUsernameIsLogged("ANDREY IVANOV");

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

