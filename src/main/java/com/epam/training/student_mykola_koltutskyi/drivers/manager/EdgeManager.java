package com.epam.training.student_mykola_koltutskyi.drivers.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public final class EdgeManager {

    private EdgeManager() {}

    public static WebDriver getDriver() {
        return new EdgeDriver();
    }
}