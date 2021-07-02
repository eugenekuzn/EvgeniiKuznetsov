package ru.training.at.hw3;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class TestProperties {

    protected final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    protected final String login = "Roman";
    protected final String password = "Jdi1234";

    protected final String home = "Home";
    protected final String contactForm = "Contact form";
    protected final String service = "Service";
    protected final String metalsNColors = "Metals & Colors";
    protected final String elementsPacks = "Elements packs";

    protected static WebDriver webDriver;

    @BeforeTest
    public void setUpTest() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    public void setUpEnvironment() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void closingTest() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}
