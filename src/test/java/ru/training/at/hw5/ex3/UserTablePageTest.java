package ru.training.at.hw5.ex3;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.training.at.hw5.testconfigs.TestEnvironment;
import ru.training.at.hw5.testconfigs.TextComponents;

public class UserTablePageTest extends TestEnvironment implements TextComponents {

    @Given("I open JDI GitHub site")
    public void openPage() {
        indexPage.openPage(url);
    }

    @And("I login as user \"Roman Iovlev\"")
    public void login() {
        usingObjects.homePage().login(login, password);
    }

    @And("I click on \"Service\" button in Header")
    public void clickOnServiceButton() {
        usingObjects.homePage().clickOnServiceButton();
    }

    @And("I click on \"User Table\" button in Service dropdown")
    public void clickOnUserTableInServiceDropdown() {
        usingObjects.homePage().clickOnUserTableLink();
    }

    @Then("{string} page should be opened")
    public void assertThatUserTablePageIsOpened(String pageName) {
        Assert.assertEquals(usingObjects.userTablePage().getPageName(), pageName);
    }

    @And("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void checkNumberTypeDropdownsOnUserTablePageAreDisplayed() {
        usingObjects.userTablePage().numberTypeDropdownIsDisplayed();
    }

    @And("6 Usernames should be displayed on Users Table on User Table Page")
    public void checkUsersOnUserTablePageAreDisplayed() {
        usingObjects.userTablePage().usernamesIsDisplayed(usernames);
    }

    @And("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void checkTextsUnderImageOnUserTablePageAreDisplayed() {
        usingObjects.userTablePage().descriptionIsDisplayed(descriptions);
    }

    @And("6 checkboxes should be displayed on Users Table on User Table Page")
    public void checkCheckboxesOnUserTablePageAreDisplayed() {
        usingObjects.userTablePage().checkboxesIsDisplayed();
    }

    @And("User table should contain following values:")
    public void checkUserTableOnUserTableContainsValues(DataTable dataTable) {
        List<List<String>> values = dataTable.asLists();
        List<String> actualStrings = new ArrayList<>();
        List<String> usernames = usingObjects.userTablePage().getUsernameOnUserTable().stream()
                                             .map(WebElement::getText)
                                             .collect(Collectors.toList());
        List<String> descriptions = usingObjects.userTablePage().getDescriptionOnUserTable().stream()
                                                .map(WebElement::getText)
                                                .collect(Collectors.toList());

        values.forEach(value -> {
            String actualString = String.join(" ", value);
            actualStrings.add(actualString);
        });

        for (int point = 0; point < values.size() - 1; point++) {

            String expected = String.valueOf(point + 1).concat(" ")
                                    .concat(usernames.get(point)).concat(" ")
                                    .concat(descriptions.get(point)).replaceAll("\n|\r\n", " ");

            Assert.assertEquals(actualStrings.get(point + 1), expected);
        }
    }

    @And("droplist should contain in column Type for user Roman")
    public void checkDropListContainsValues(DataTable dataTable) {
        List<String> expectedTypes = dataTable.asList();
        List<String> actualTypes = usingObjects.userTablePage().getDropdownOptions().stream()
                                               .map(WebElement::getText)
                                               .collect(Collectors.toList());

        for (int iteration = 0; iteration < expectedTypes.size() - 1; iteration++) {
            Assert.assertEquals(actualTypes.get(iteration), expectedTypes.get(iteration + 1));
        }
    }
}
