package org.yandrut.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage extends AbstractPage {
    private final WebDriver driver;
    private static final Logger log = LogManager.getLogger(CalculatorPage.class);

    @FindBy(xpath = "//button[@data-idom-class='xhASFc']")
    private WebElement addToEstimate;
    @FindBy(xpath = "//div[@data-service-form='8']")
    private WebElement computeEngine;
    @FindBy(xpath = "//div[text()='Estimated cost']/following::label")
    private WebElement estimatedCost;

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CalculatorPage navigateToUrl(String url) {
        driver.get(url);
        log.info("Moving to URL: {}", url);
        return this;
    }

    public CalculatorFormLoader fillOutTheForm() {
        return new CalculatorFormLoader(driver);
    }

    public CalculatorPage clickOnComputeEngine() {
        addToEstimate.click();
        computeEngine.click();
        log.info("Clicked on compute engine");
        return this;
    }

    public String getEstimatedCost() {
        String priceText = estimatedCost.getText();
        log.info("Estimated price is {}", estimatedCost);
        return priceText;
    }
}