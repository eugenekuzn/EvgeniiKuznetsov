package ru.training.at.hw5.testconfigs;

import ru.training.at.hw5.driver.WebDriverSingleton;
import ru.training.at.hw5.indexpage.IndexPage;

public class TestEnvironment {
    protected IndexPage indexPage;
    protected UsingObjects usingObjects;

    protected TestEnvironment() {
        indexPage = new IndexPage(WebDriverSingleton.getDriver());
        usingObjects = new UsingObjects(WebDriverSingleton.getDriver());
    }
}
