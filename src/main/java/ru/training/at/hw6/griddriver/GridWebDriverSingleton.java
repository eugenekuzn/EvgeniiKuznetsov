package ru.training.at.hw6.griddriver;

import java.util.Objects;
import org.openqa.selenium.WebDriver;

public class GridWebDriverSingleton {

    private static WebDriver driver;

    private GridWebDriverSingleton() {
    }

    public static WebDriver getDriver() {
        String driverType = System.getProperty("driver.type") == null ? "local" : System.getProperty("driver.type");
        String browserName = System.getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        if (Objects.isNull(driver)) {
            driver = GridWebDriverFactory.createWebDriver(browserName);
        }
        return driver;
    }

    public static void closeDriver() {
        driver.close();
        driver = null;
    }
}
