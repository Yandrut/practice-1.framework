package com.epam.training.student_mykola_koltutskyi.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class Page {
    protected WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;
    }

    protected Page navigateToUrl(String url) {
        log.info("Moving to URL: ");
        driver.get(url);
        return this;
    }
}