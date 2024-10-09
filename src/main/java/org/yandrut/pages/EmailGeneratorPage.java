package org.yandrut.pages;

import org.openqa.selenium.WebDriver;

public class EmailGeneratorPage {
    private final WebDriver driver;
    String generatedEmail;

    public EmailGeneratorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void generateEmail() {}

    public String getGeneratedEmail() {
        return generatedEmail;
    }

    public CalculatorPage returnToCalculator() {
        return new CalculatorPage(driver);
    }

}
