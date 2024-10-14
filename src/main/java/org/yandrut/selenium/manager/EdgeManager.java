package org.yandrut.selenium.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public final class EdgeManager {

    private EdgeManager() {}

    public static WebDriver getDriver() {
        return new EdgeDriver();
    }
}