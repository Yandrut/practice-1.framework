package com.epam.training.student_mykola_koltutskyi.drivers.manager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.epam.training.student_mykola_koltutskyi.config.ConfigFactory;

public class AndroidManager {

    private AndroidManager(){}

    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UI Automator 2");
        capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/android-app.apk");
        return new AndroidDriver(ConfigFactory.getConfig().localAppiumServerURL(), capabilities);
    }
}