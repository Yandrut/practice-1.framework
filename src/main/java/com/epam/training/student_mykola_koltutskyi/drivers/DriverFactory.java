package com.epam.training.student_mykola_koltutskyi.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.epam.training.student_mykola_koltutskyi.service.DriverData;

public final class DriverFactory {

    public static WebDriver getDriver(DriverData driverData) {

        return new ChromeDriver();
    }
}
