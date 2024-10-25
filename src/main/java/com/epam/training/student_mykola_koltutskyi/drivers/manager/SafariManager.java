package com.epam.training.student_mykola_koltutskyi.drivers.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class SafariManager {

    private SafariManager() {}

    public static WebDriver getDriver() {
        return new SafariDriver();
    }
}
