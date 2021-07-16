package ru.training.at.hw6.testinit;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import ru.training.at.hw6.griddriver.GridWebDriverSingleton;
import ru.training.at.hw6.steps.ActionStep;
import ru.training.at.hw6.steps.AssertionStep;

public class TestInit extends AbstractTextTestComponent {
    protected static WebDriver webDriver;

    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeTest
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.edgedriver().setup();
    }

    @BeforeMethod
    public void setUpEnvironment(ITestContext testContext) {
        webDriver = GridWebDriverSingleton.getDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        actionStep = new ActionStep(webDriver);
        assertionStep = new AssertionStep(webDriver);
        testContext.setAttribute("driver", webDriver);
    }

    @AfterClass
    public void closingTest() {
        GridWebDriverSingleton.closeDriver();
    }
}

