package org.yandrut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CloudPage extends AbstractPage {

    private final WebDriver driver;
    private final By SEARCH_BUTTON = By.xpath("//div[@class='YSM5S']");
    private final By SEARCH_FIELD = By.xpath("//input[@type='text']");
    private final By SEARCH_RESULTS = By.xpath("//a[@track-type='search-result']");

    public CloudPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getPageName() {
        return driver.getTitle();
    }

    public void sendKeys(WebElement element, String keysToSend) {
        element.sendKeys(keysToSend);
    }

    public CloudPage clickOnTheSearchIcon() {
        driver.findElement(SEARCH_BUTTON).click();
        return this;
    }

    public CloudPage sendSearchDetailsAndSubmit(String details) {
        sendKeys(driver.findElement(SEARCH_FIELD), details);
        driver.findElement(SEARCH_FIELD).submit();
        return this;
    }

    public CalculatorPage clickOnPricingCalculator() {
        driver.findElements(SEARCH_RESULTS)
                .stream()
                .filter((element) -> element.getText().equals("Google Cloud Pricing Calculator"))
                .findAny()
                .ifPresent(WebElement::click);
        return new CalculatorPage(driver);
    }
}