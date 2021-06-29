package ru.training.at.hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractDriverActivator {
    WebDriver driver;

    public AbstractDriverActivator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
