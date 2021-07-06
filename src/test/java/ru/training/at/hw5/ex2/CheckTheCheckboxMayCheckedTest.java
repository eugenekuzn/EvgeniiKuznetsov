package ru.training.at.hw5.ex2;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ru.training.at.hw5.testconfigs.TestEnvironment;
import ru.training.at.hw5.testconfigs.TextComponents;

public class CheckTheCheckboxMayCheckedTest extends TestEnvironment implements TextComponents {

    @Given("I open JDI GitHub test site")
    public void openPage() {
        indexPage.openPage(url);
    }

    @And("I login as user with username \"Roman Iovlev\"")
    public void login() {
        usingObjects.homePage().login(login, password);
    }

    @And("I click on \"Service\" in Header")
    public void clickOnServiceButton() {
        usingObjects.homePage().clickOnServiceButton();
    }

    @And("I click on \"User Table\" button in opened Service dropdown")
    public void clickOnUserTableInServiceDropdown() {
        usingObjects.homePage().clickOnUserTableLink();
    }

    @When("I select 'vip' checkbox for \"Sergey Ivan\"")
    public void selectCheckboxForSergeyIvan() {
        usingObjects.differentElementsPage().selectSergeyIvanCheckbox();
    }

    @Then("1 log row has {string} text in log section")
    public void checkTheLogTextInLogSelection(String text) {
        usingObjects.differentElementsPage().assertTheLogPanelRow(text);
    }
}
