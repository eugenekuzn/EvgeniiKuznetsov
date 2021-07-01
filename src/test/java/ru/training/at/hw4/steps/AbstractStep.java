package ru.training.at.hw4.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.training.at.hw4.differentelementspageobjects.DifferentElementsPage;
import ru.training.at.hw4.homepageobjects.HomePage;

public abstract class AbstractStep {
    protected WebDriver driver;
    protected HomePage homePage;
    protected DifferentElementsPage differentElementsPage;

    public AbstractStep(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        homePage = new HomePage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
    }
}
