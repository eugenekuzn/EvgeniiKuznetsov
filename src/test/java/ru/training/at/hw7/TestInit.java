package ru.training.at.hw7;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class TestInit {

    @BeforeSuite(alwaysRun = true)
    public void setup() {
        initSite(JdiSite.class);
    }

    @AfterSuite
    public void stop() {
        killAllSeleniumDrivers();
    }
}
