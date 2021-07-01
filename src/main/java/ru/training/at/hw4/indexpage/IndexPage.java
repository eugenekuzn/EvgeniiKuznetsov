package ru.training.at.hw4.indexpage;

import org.openqa.selenium.WebDriver;

public class IndexPage extends AbstractIndexPage {

    WebDriver driver;

    public IndexPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void open(String url) {
        driver.navigate().to(url);
    }
}
