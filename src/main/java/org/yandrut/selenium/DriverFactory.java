package org.yandrut.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.yandrut.config.ConfigFactory;
import org.yandrut.service.DriverData;

public final class DriverFactory {

    public static WebDriver getDriver(DriverData driverData) {

        return new ChromeDriver();
    }
}
