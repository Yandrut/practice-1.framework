package com.epam.training.student_mykola_koltutskyi.drivers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DriverWaiter {
    public static final Duration VISIBILITY_TIMEOUT_SECONDS = Duration.ofSeconds(10L);
    private static final WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), VISIBILITY_TIMEOUT_SECONDS);

    public static WebElement waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static WebElement waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitForElementToBeInvisible(WebElement element) {
        wait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }

    public static WebElement waitForAttributeToBe(WebElement elementLocator, String attribute, String value) {
        wait.until(ExpectedConditions.attributeToBe(elementLocator, attribute, value));
        return elementLocator;
    }
}