package ru.training.at.hw2.ex2;

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

public class CheckboxesRadioButtonsNDropdownsCheckingTest {

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
    public void secondTest() {
        //1. Open test site by URL
        webDriver.navigate().to(url);

        //2. Assert Browser title
        Assert.assertEquals(webDriver.getTitle(), "Home Page");

        //3. Perform login
        //open input fields
        webDriver.findElement(By.xpath("//li[@class = 'dropdown uui-profile-menu']")).click();
        //input name and password values in corresponding fields
        webDriver.findElement(By.xpath("//input[@id = 'name']")).sendKeys(login);
        webDriver.findElement(By.xpath("//input[@id = 'password']")).sendKeys(password);
        //push "Enter" button
        webDriver.findElement(By.cssSelector("button[type ='submit")).click();

        //4. Assert Username is loggined
        WebElement username = webDriver.findElement(By.id("user-name"));
        Assert.assertEquals(username.getText(), "ROMAN IOVLEV");

        //5. Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.xpath("//*[@class=\"dropdown-toggle\"]")).click();
        webDriver.findElement(By.xpath("//*[@href=\"different-elements.html\"]")).click();

        //6. Select checkboxes
        //Water
        webDriver.findElement(By.xpath("//label[1]//input[@type=\"checkbox\"]")).click();
        //Wind
        webDriver.findElement(By.xpath("//label[3]//input[@type=\"checkbox\"]")).click();

        //7. Select radio
        //Selen
        webDriver.findElement(By.xpath("//label[4]//input[@type=\"radio\"]")).click();

        //8. Select in dropdown
        webDriver.findElement(By.cssSelector("select[class = 'uui-form-element']")).click();
        webDriver.findElement(By.xpath("//select//option[contains(text(), 'Yellow')]")).click();

        //9. Assert that:
        //9.1 for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //water checkbox
        WebElement waterCheckbox =
            webDriver.findElement(By.xpath("//ul[@class=\"panel-body-list logs\"]//li[contains(text(), 'Water')]"));
        Assert.assertTrue(waterCheckbox.getText().contains("Water: condition changed to true"));
        //wind checkbox
        WebElement windCheckbox =
            webDriver.findElement(By.xpath("//ul[@class=\"panel-body-list logs\"]//li[contains(text(), 'Wind')]"));
        Assert.assertTrue(windCheckbox.getText().contains("Wind: condition changed to true"));
        //9.2 for radio button there is a log row and value is corresponded to the status of radio button
        WebElement selenRadiobutton =
            webDriver.findElement(By.xpath("//ul[@class=\"panel-body-list logs\"]//li[contains(text(), 'Selen')]"));
        Assert.assertTrue(selenRadiobutton.getText().contains("metal: value changed to Selen"));
        //9.3 for dropdown there is a log row and value is corresponded to the selected value
        WebElement yellowColor =
            webDriver.findElement(By.xpath("//ul[@class=\"panel-body-list logs\"]//li[contains(text(), 'Yellow')]"));
        Assert.assertTrue(yellowColor.getText().contains("Colors: value changed to Yellow"));
    }

    //Close Browser
    @AfterTest
    public void closingTest() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}

