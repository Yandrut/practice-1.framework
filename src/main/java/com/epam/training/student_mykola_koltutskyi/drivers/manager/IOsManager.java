package com.epam.training.student_mykola_koltutskyi.drivers.manager;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;import com.epam.training.student_mykola_koltutskyi.configure.ConfigFactory;

public final class IOsManager {

    private IOsManager(){}

    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.IOS);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPod touch (7th generation)");
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir"+"/ios-app.zip"));
        return new IOSDriver(ConfigFactory.getConfig().localAppiumServerURL(), capabilities);
    }
}
