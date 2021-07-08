package ru.training.at.hw5.ex1;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.training.at.hw5.testconfigs.TestEnvironment;
import ru.training.at.hw5.testconfigs.TextComponents;

public class CheckboxesRadioButtonsNDropdownsTest extends TestEnvironment implements TextComponents {

    @Given("I open JDI GitHub")
    public void openPage() {
        indexPage.openPage(url);
    }

    @And("I login as \"Roman Iovlev\"")
    public void login() {
        usingObjects.homePage().login(login, password);
    }

    @When("I click on \"Service\" button")
    public void clickOnServiceButton() {
        usingObjects.homePage().clickOnServiceButton();
    }

    @And("I click on Different Elements Page")
    public void openDifferentElementsPage() {
        usingObjects.homePage().openDifferentElementsPage();
    }

    @And("Select checkbox {string} ")
    public void selectWaterCheckbox(String item) {
        usingObjects.differentElementsPage().selectCheckboxes(item);
    }

    @And("Select checkbox {string}")
    public void selectWindCheckbox(String item) {
        usingObjects.differentElementsPage().selectCheckboxes(item);
    }

    @And("Select radio {string}")
    public void selectSelenRadioButton(String item) {
        usingObjects.differentElementsPage().selectRadioButtons(item);
    }

    @And("Select in dropdown {string}")
    public void selectYellowColor(String item) {
        usingObjects.differentElementsPage().selectDropdowns(item);
    }

    @Then("Log row displayed {string} after Water checkbox was selected")
    public void checkTheLogRowShowsCorrectInformationAboutWaterCheckbox(String currentText) {
        usingObjects.differentElementsPage().assertTheLogPanelRow(currentText);
    }

    @And("Log row displayed {string} after Wind checkbox was selected")
    public void checkTheLogRowShowsCorrectInformationAboutWindCheckbox(String currentText) {
        usingObjects.differentElementsPage().assertTheLogPanelRow(currentText);
    }

    @And("Log row displayed {string} after Selen radio button was selected")
    public void checkTheLogRowShowsCorrectInformationAboutRadioButton(String currentText) {
        usingObjects.differentElementsPage().assertTheLogPanelRow(currentText);
    }

    @And("Log row displayed {string} after Yellow color was selected")
    public void checkTheLogRowShowsCorrectInformationAboutColor(String currentText) {
        usingObjects.differentElementsPage().assertTheLogPanelRow(currentText);
    }
}

