package ru.training.at.hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import ru.training.at.hw4.steps.ActionStep;
import ru.training.at.hw4.steps.AssertionStep;

public class TestConfig extends AbstractTextComponents {

    protected final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    protected final String login = "Roman";
    protected final String password = "Jdi1234";

    protected final String checkingPage = "Home Page";
    protected final String checkingUserName = "ROMAN IOVLEV";

    protected final String[] headerElements = {"HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS"};
    protected final String[] leftSideMenuElements =
        {"Home", "Contact form", "Service", "Metals & Colors", "Elements packs"};
    protected final String[] textUnderImages =
        {textUnderFirstImg, textUnderSecondImg, textUnderThirdImg, textUnderFourthImg};
    protected final String[] logTextComponents =
        {waterCheckboxLog, windCheckboxLog, selenRadioButtonLog, yellowColorLog};

    protected static WebDriver webDriver;

    protected ActionStep actionStep;
    protected AssertionStep assertionStep;

    @BeforeTest
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setUpEnvironment(ITestContext testContext) {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        actionStep = new ActionStep(webDriver);
        assertionStep = new AssertionStep(webDriver);
        testContext.setAttribute("driver", webDriver);
    }

    @AfterClass
    public void closingTest() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}
