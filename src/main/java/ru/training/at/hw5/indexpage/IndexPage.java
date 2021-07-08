package ru.training.at.hw5.indexpage;

import org.openqa.selenium.WebDriver;

public class IndexPage extends AbstractIndexPage {
    private WebDriver driver;

    public IndexPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void openPage(String url) {
        driver.navigate().to(url);
    }
}
