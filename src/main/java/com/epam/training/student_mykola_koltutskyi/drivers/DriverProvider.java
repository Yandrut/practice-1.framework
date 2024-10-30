package com.epam.training.student_mykola_koltutskyi.drivers;

import com.epam.training.student_mykola_koltutskyi.enums.BrowserType;
import org.openqa.selenium.WebDriver;
import com.epam.training.student_mykola_koltutskyi.configure.ConfigFactory;

import java.util.Objects;

public final class DriverProvider {
    private static final ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    private DriverProvider() {}

    public static void initializeDriver() {
        if (Objects.isNull(getDriver())) {
            BrowserType browser = ConfigFactory.getConfig().browser();
            setDriver(DriverFactory.getDriver(browser));
        }
    }

    public static void quit() {
        if (Objects.nonNull(getDriver())) {
            getDriver().quit();
            remove();
        }
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    public static void setDriver(WebDriver driver) {
        threadLocalDriver.set(driver);
    }

    public static void remove() {
        threadLocalDriver.remove();
    }
}