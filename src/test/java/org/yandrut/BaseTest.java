package org.yandrut;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.yandrut.selenium.DriverProvider;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    @BeforeMethod
    public void openBrowser() {
        WebDriver driver = DriverProvider.getInstance();
        driver.get("https://cloud.google.com");
    }

    @AfterMethod
    public void quitBrowser() {
        DriverProvider.quit();
    }
}