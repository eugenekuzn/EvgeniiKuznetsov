package ru.training.at.hw4.indexpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractIndexPage {
    protected WebDriver driver;

    protected AbstractIndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
