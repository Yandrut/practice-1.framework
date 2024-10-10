package org.yandrut.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CloudPage extends AbstractPage {

    private final WebDriver driver;
    private final By SEARCH_BUTTON = By.xpath("//div[@class='YSM5S']");
    private final By SEARCH_FIELD = By.xpath("//input[@type='text']");
    private final By SEARCH_RESULTS = By.xpath("//a[@track-type='search-result']");
    private static final Logger log = LogManager.getLogger(CloudPage.class);

    public CloudPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public CloudPage navigateToUrl(String url) {
        driver.get(url);
        log.info("Moving to URL: {}", url);
        return this;
    }

    public String getPageName() {
        return driver.getTitle();
    }


    public void sendKeys(WebElement element, String keysToSend) {
        log.info("Send character sequence: {}", keysToSend);
        element.sendKeys(keysToSend);
    }

    public CloudPage clickOnTheSearchIcon() {
        driver.findElement(SEARCH_BUTTON).click();
        return this;
    }

    public CloudPage sendSearchDetailsAndSubmit(String details) {
        log.info("Search prompt is: {}", details);
        sendKeys(driver.findElement(SEARCH_FIELD), details);
        driver.findElement(SEARCH_FIELD).submit();
        return this;
    }

    public CalculatorPage clickOnPricingCalculator() {
        final String prompt = "Google Cloud Pricing Calculator";

        driver.findElements(SEARCH_RESULTS)
                .stream()
                .filter((element) -> element.getText().equals(prompt))
                .findAny()
                .ifPresent(WebElement::click);
        log.info("Pricing calculator opened");
        return new CalculatorPage(driver);
    }
}