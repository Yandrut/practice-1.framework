package com.epam.training.student_mykola_koltutskyi.drivers.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.epam.training.student_mykola_koltutskyi.service.DataReader;

public final class ChromeManager {

    private ChromeManager(){}

    public static WebDriver getDriver() {
        String downloadFilepath = DataReader.getTestData("data.provided.downloadPath");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("download.default_directory", downloadFilepath);
        return new ChromeDriver(options);
    }
}
