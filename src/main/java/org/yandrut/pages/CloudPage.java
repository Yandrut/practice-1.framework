package org.yandrut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.stream.Collectors;


public class CloudPage {

    private final WebDriver driver;
    private final By SEARCH_BUTTON = By.xpath("//div[@class='YSM5S']");
    private final By SEARCH_FIELD = By.xpath("//input[@type='text']");
    private final By SEARCH_RESULTS = By.xpath("//a[@track-type='search-result']");

    public CloudPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageName() {
        return driver.getTitle();
    }

    public void sendKeys(WebElement element, String keysToSend) {
        element.sendKeys(keysToSend);
    }

    public void clickOnTheSearchIcon() {
        driver.findElement(SEARCH_BUTTON).click();
    }

    public void sendSearchDetailsAndSubmit(String details) {
        sendKeys(driver.findElement(SEARCH_FIELD), details);
        driver.findElement(SEARCH_FIELD).submit();
    }

    public CalculatorPage clickOnPricingCalculator() {
        driver.findElements(SEARCH_RESULTS)
                .stream()
                .filter((element) -> element.getText().equals("Google Cloud Pricing Calculator"))
                .collect(Collectors.toList())
                .get(0)
                .click();
        return new CalculatorPage(driver);
    }
}