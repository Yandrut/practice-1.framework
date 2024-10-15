package org.yandrut.selenium;

import org.openqa.selenium.WebDriver;
import org.yandrut.enums.BrowserType;
import org.yandrut.selenium.manager.ChromeManager;
import org.yandrut.selenium.manager.EdgeManager;
import org.yandrut.selenium.manager.FirefoxManager;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class LocalDriverFactory {

    private LocalDriverFactory() {}

    private static final Map<BrowserType, Supplier<WebDriver>> ENUM_MAP =
            new EnumMap<>(BrowserType.class);

    static {
        ENUM_MAP.put(BrowserType.CHROME, ChromeManager::getDriver);
        ENUM_MAP.put(BrowserType.FIREFOX, FirefoxManager::getDriver);
        ENUM_MAP.put(BrowserType.EDGE, EdgeManager::getDriver);
    }

    public static WebDriver getDriver(BrowserType browserType) {
        return ENUM_MAP.get(browserType).get();
    }
}