package org.yandrut.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.yandrut.selenium.DriverProvider;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {
    private static final Logger log = LogManager.getLogger(TestListener.class);


    @Override
    public void onTestFailure(ITestResult testResult) {
        saveScreenshot();
        log.info("Screenshot taken");
    }

    public void saveScreenshot() {
        TakesScreenshot screenshot = (TakesScreenshot) DriverProvider.getInstance();
        File screenCapture = screenshot.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenCapture,
                    new File(".//target/screenshots/" + getCurrentTime() + ".png"));

        } catch (IOException e) {
            log.error(e.getLocalizedMessage());
        }
    }

    public String getCurrentTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}