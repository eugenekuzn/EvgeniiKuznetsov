package ru.training.at.hw2.ex1;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LayoutCheckingTest {

    private final String url = "https://jdi-testing.github.io/jdi-light/index.html";
    private final String login = "Roman";
    private final String password = "Jdi1234";

    private static WebDriver webDriver;

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

    @Test
    public void firstTest() {
        //1. Open test site by URL
        webDriver.navigate().to(url);

        //2. Assert Browser title
        Assert.assertEquals(webDriver.getTitle(), "Home Page");

        //3. Perform login
        //open input fields
        webDriver.findElement(By.className("profile-photo")).click();
        //input name and password values in corresponding fields
        webDriver.findElement(By.id("name")).sendKeys(login);
        webDriver.findElement(By.id("password")).sendKeys(password);
        //push "Enter" button
        webDriver.findElement(By.id("login-button")).click();
        ;

        //4. Assert Username is loggined
        WebElement username = webDriver.findElement(By.id("user-name"));
        Assert.assertEquals(username.getText(), "ROMAN IOVLEV");

        //5. Assert that there are 4 items on the header section are displayed and they have proper texts
        //HOME
        WebElement homeElement = webDriver.findElement(By.xpath("//*[@href=\"index.html\"]"));
        Assert.assertEquals(homeElement.getText(), "HOME");
        //CONTACT FORM
        WebElement contactFormElement = webDriver.findElement(By.xpath("//*[@href=\"contacts.html\"]"));
        Assert.assertEquals(contactFormElement.getText(), "CONTACT FORM");
        //SERVICE
        WebElement serviceElement = webDriver.findElement(By.xpath("//*[@class=\"dropdown-toggle\"]"));
        Assert.assertEquals(serviceElement.getText(), "SERVICE");
        //METALS & COLORS
        WebElement metalNColorsElement = webDriver.findElement(By.xpath("//*[@href=\"metals-colors.html\"]"));
        Assert.assertEquals(metalNColorsElement.getText(), "METALS & COLORS");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        //check the first image
        webDriver.findElement(By.xpath("//*[@class=\"icons-benefit icon-practise\"]"));
        //check the second image
        webDriver.findElement(By.xpath("//*[@class=\"icons-benefit icon-custom\"]"));
        //check the third image
        webDriver.findElement(By.xpath("//*[@class=\"icons-benefit icon-multi\"]"));
        //check the fourth image
        webDriver.findElement(By.xpath("//*[@class=\"icons-benefit icon-base\"]"));

        //7. Assert that there are 4 texts on the Index Page under icons and they have proper text
        //check the first text
        WebElement textUnderFirstImage = webDriver.findElement(By.xpath("//span[contains(text(), 'good practices')]"));
        Assert.assertEquals(textUnderFirstImage.getText(), "To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project");
        //check the second text
        WebElement textUnderSecondImage = webDriver.findElement(By.xpath("//span[contains(text(), 'flexible')]"));
        Assert.assertEquals(textUnderSecondImage.getText(), "To be flexible and\n"
            + "customizable");
        //check the third text
        WebElement textUnderThirdImage = webDriver.findElement(By.xpath("//span[contains(text(), 'multiplatform')]"));
        Assert.assertEquals(textUnderThirdImage.getText(), "To be multiplatform");
        //check the fourth text
        WebElement textUnderFourthImage = webDriver.findElement(By.xpath("//span[contains(text(), 'have good base')]"));
        Assert.assertEquals(textUnderFourthImage.getText(), "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…");

        //8. Assert that there is the iframe with “Frame Button” exist
        webDriver.findElement(By.cssSelector("iframe[id='frame']"));

        //9. Switch to the iframe and check that there is “Frame Button” in the iframe
        webDriver.switchTo().frame("frame");
        webDriver.findElement(By.id("frame-button"));

        //10. Switch to original window back
        webDriver.switchTo().defaultContent();

        //11. Assert that there are 5 items in the Left Section are displayed and they have proper text
        //Home
        WebElement homeElemOnLeftSIde = webDriver.findElement(By.xpath("//span[text() = 'Home']"));
        Assert.assertEquals(homeElemOnLeftSIde.getText(), "Home");
        //Contact form
        WebElement contactFormElemOnLeftSIde = webDriver.findElement(By.xpath("//span[text() = 'Contact form']"));
        Assert.assertEquals(contactFormElemOnLeftSIde.getText(), "Contact form");
        //Service
        WebElement serviceElemOnLeftSIde =
            webDriver.findElement(By.xpath("//span[text() = 'Service']"));
        Assert.assertEquals(serviceElemOnLeftSIde.getText(), "Service");
        //Metals & Colors
        WebElement metalNColorsElemOnLeftSIde =
            webDriver.findElement(By.xpath("//span[text() = 'Metals & Colors']"));
        Assert.assertEquals(metalNColorsElemOnLeftSIde.getText(), "Metals & Colors");
        //Elements packs
        WebElement elementPacksElemOnLeftSIde = webDriver
            .findElement(By.xpath("//span[text() = 'Elements packs']"));
        Assert.assertEquals(elementPacksElemOnLeftSIde.getText(), "Elements packs");
    }

    //Close Browser
    @AfterTest
    public void closingTest() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }
    }
}
