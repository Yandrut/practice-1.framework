package com.epam.training.student_mykola_koltutskyi.drivers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DriverWaiter {

    public static WebElement waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverProvider.getInstance(), Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static WebElement waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverProvider.getInstance(), Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public static WebElement waitForElementToBeInvisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverProvider.getInstance(), Duration.ofSeconds(10L));
        wait.until(ExpectedConditions.invisibilityOf(element));
        return element;
    }
}