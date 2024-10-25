package com.epam.training.student_mykola_koltutskyi.drivers;

import com.epam.training.student_mykola_koltutskyi.drivers.manager.SafariManager;
import org.openqa.selenium.WebDriver;
import com.epam.training.student_mykola_koltutskyi.enums.BrowserType;
import com.epam.training.student_mykola_koltutskyi.drivers.manager.ChromeManager;
import com.epam.training.student_mykola_koltutskyi.drivers.manager.EdgeManager;
import com.epam.training.student_mykola_koltutskyi.drivers.manager.FirefoxManager;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {

    private DriverFactory() {}

    private static final Map<BrowserType, Supplier<WebDriver>> ENUM_MAP =
            new EnumMap<>(BrowserType.class);

    static {
        ENUM_MAP.put(BrowserType.CHROME, ChromeManager::getDriver);
        ENUM_MAP.put(BrowserType.FIREFOX, FirefoxManager::getDriver);
        ENUM_MAP.put(BrowserType.EDGE, EdgeManager::getDriver);
        ENUM_MAP.put(BrowserType.SAFARI, SafariManager::getDriver);
    }

    public static WebDriver getDriver(BrowserType browserType) {
        return ENUM_MAP.get(browserType).get();
    }
}