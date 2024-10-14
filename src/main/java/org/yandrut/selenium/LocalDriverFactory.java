package org.yandrut.selenium;

import org.openqa.selenium.WebDriver;
import org.yandrut.selenium.manager.ChromeManager;
import org.yandrut.selenium.manager.EdgeManager;
import org.yandrut.selenium.manager.FirefoxManager;

import java.time.Duration;

public class LocalDriverFactory {

    private LocalDriverFactory() {}

    public static WebDriver getDriver() {
        WebDriver driver;
        String driverName = System.getProperty("browser", "CHROME").toUpperCase();

        switch (driverName) {
            case "CHROME":
                driver = ChromeManager.getDriver();
                break;
            case "FIREFOX":
                driver = FirefoxManager.getDriver();
                break;
            case "EDGE":
                driver = EdgeManager.getDriver();
                break;
            default:
                throw new RuntimeException("Invalid name of the driver");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }
}