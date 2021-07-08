package ru.training.at.hw5.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import ru.training.at.hw5.context.TestContext;
import ru.training.at.hw5.driver.WebDriverSingleton;
import ru.training.at.hw5.testconfigs.UsingObjects;

public class CucumberHook {

    protected WebDriver driver;
    protected UsingObjects usingObjects;
    protected static final String USERNAME = "Roman";
    protected static final String PASSWORD = "Jdi1234";

    @Before
    public void start() {
        WebDriverSingleton.getDriver();
        usingObjects = new UsingObjects(WebDriverSingleton.getDriver());
    }

    @After
    public void close() {
        WebDriverSingleton.closeDriver();
        TestContext.getInstance().clean();
    }
}
