package org.yandrut;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.yandrut.selenium.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.yandrut.utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeMethod
    @Description("Opening new browser instance")
    public void openBrowser() {
        WebDriver driver = DriverProvider.getInstance();
    }

    @AfterMethod
    @Description("Closing browser instance")
    public void quitBrowser() {
        DriverProvider.quit();
    }
}