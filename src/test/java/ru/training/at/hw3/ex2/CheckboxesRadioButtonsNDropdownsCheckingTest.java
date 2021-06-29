package ru.training.at.hw3.ex2;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.training.at.hw3.DifferentElementsPage;
import ru.training.at.hw3.HomePage;
import ru.training.at.hw3.NewPage;
import ru.training.at.hw3.TestProperties;

public class CheckboxesRadioButtonsNDropdownsCheckingTest extends TestProperties {

    @Test
    public void checkboxesRadioButtonsNDropdownsCheckingTest() {
        //1. Open test site by URL
        new NewPage(webDriver).open(url);

        //2. Assert Browser title
        Assert.assertEquals(webDriver.getTitle(), "Home Page");

        //3. Perform login
        HomePage homePage = PageFactory.initElements(webDriver, HomePage.class);
        homePage.login(login, password);

        //4. Assert Username is loggined
        Assert.assertEquals(homePage.getHeaderOfHomePageObjects().getUsername(), "ROMAN IOVLEV");

        //5. Open through the header menu Service -> Different Elements Page
        homePage.openDifferentElementsPage();

        //6. Select checkboxes
        DifferentElementsPage differentElementsPage = new DifferentElementsPage(webDriver);
        //Water
        differentElementsPage.getWaterCheckBox().click();
        //Wind
        differentElementsPage.getWindCheckBox().click();

        //7. Select radio
        //Selen
        differentElementsPage.getSelenRadioButton().click();

        //8. Select in dropdown
        differentElementsPage.getYellowOption().click();

        //9. Assert that:
        //9.1 for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //water checkbox
        Assert.assertTrue(differentElementsPage.getLogPanelOfDifferentElementsPage().getLogForWaterCheckBox()
                                               .contains("Water: condition changed to true"));
        //wind checkbox
        Assert.assertTrue(differentElementsPage.getLogPanelOfDifferentElementsPage().getLogForWindCheckBox()
                                               .contains("Wind: condition changed to true"));
        //9.2 for radio button there is a log row and value is corresponded to the status of radio button
        Assert.assertTrue(differentElementsPage.getLogPanelOfDifferentElementsPage().getLogForSelenRadioButton()
                                               .contains("metal: value changed to Selen"));
        //9.3 for dropdown there is a log row and value is corresponded to the selected value
        Assert.assertTrue(differentElementsPage.getLogPanelOfDifferentElementsPage().getLogForYellowOption()
                                               .contains("Colors: value changed to Yellow"));
    }
}

