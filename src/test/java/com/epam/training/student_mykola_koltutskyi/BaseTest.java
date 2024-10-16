package com.epam.training.student_mykola_koltutskyi;

import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import org.openqa.selenium.WebDriver;
import com.epam.training.student_mykola_koltutskyi.utils.TestListener;

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