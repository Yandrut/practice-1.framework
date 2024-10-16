package com.epam.training.student_mykola_koltutskyi.drivers;

import org.openqa.selenium.WebDriver;
import com.epam.training.student_mykola_koltutskyi.enums.MobilePlatformType;
import com.epam.training.student_mykola_koltutskyi.drivers.manager.AndroidManager;
import com.epam.training.student_mykola_koltutskyi.drivers.manager.IOsManager;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class MobileDriverFactory {

    private MobileDriverFactory() {}

    private static final Map<MobilePlatformType, Supplier<WebDriver>> ENUM_MAP =
            new EnumMap<>(MobilePlatformType.class);

    static {
        ENUM_MAP.put(MobilePlatformType.ANDROID, AndroidManager::getDriver);
        ENUM_MAP.put(MobilePlatformType.IOS, IOsManager::getDriver);
    }

    public static WebDriver getDriver(MobilePlatformType platformType) {
        return ENUM_MAP.get(platformType).get();
    }
}