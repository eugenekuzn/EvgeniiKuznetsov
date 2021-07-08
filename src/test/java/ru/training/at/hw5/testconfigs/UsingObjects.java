package ru.training.at.hw5.testconfigs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw5.differentelementspage.DifferentElementsPage;
import ru.training.at.hw5.homepage.HomePage;
import ru.training.at.hw5.usertablepage.UserTablePage;

public class UsingObjects {
    protected WebDriver driver;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    public UsingObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
    }

    public HomePage homePage() {
        return homePage;
    }

    public DifferentElementsPage differentElementsPage() {
        return differentElementsPage;
    }

    public UserTablePage userTablePage() {
        return userTablePage;
    }
}
