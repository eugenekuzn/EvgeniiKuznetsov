package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;

public class NewPage extends AbstractDriverActivator {

    WebDriver driver;

    public NewPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void open(String url) {
        driver.navigate().to(url);
    }
}
