package org.yandrut.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;

public class EmailGeneratorPage extends AbstractPage {
    private final WebDriver driver;
    @Getter
    String generatedEmail;

    public EmailGeneratorPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void generateEmail() {}

    public CalculatorPage returnToCalculator() {
        return new CalculatorPage(driver);
    }

}
