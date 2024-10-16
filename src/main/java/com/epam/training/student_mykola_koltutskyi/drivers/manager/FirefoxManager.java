package com.epam.training.student_mykola_koltutskyi.drivers.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public final class FirefoxManager {

    private FirefoxManager() {}

    public static WebDriver getDriver() {
        return new FirefoxDriver();
    }
}
