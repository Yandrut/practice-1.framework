package com.epam.training.student_mykola_koltutskyi.pages;

import com.epam.training.student_mykola_koltutskyi.elements.Button;
import com.epam.training.student_mykola_koltutskyi.elements.ElementList;
import com.epam.training.student_mykola_koltutskyi.elements.InputText;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class CloudPage extends Page {

    private final WebDriver driver;

    @FindBy(xpath = "//div[@class='YSM5S']")
    private Button searchButton;

    @FindBy(xpath = "//input[@type='text']")
    private InputText searchField;

    @FindBy(xpath = "//a[@track-type='search-result']")
    private ElementList searchResults;

    public CloudPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CloudPage navigateToUrl(String url) {
        super.navigateToUrl(url);
        return this;
    }

    public CloudPage clickOnTheSearchIcon() {
        log.info("Click on the search Icon");
        searchButton.waitAndClick();
        return this;
    }

    public CloudPage sendSearchDetailsAndSubmit(String details) {
        log.info("Search prompt is: {}", details);
        searchField.sendKeys(details);
        searchField.submit();
        return this;
    }

    public CalculatorPage clickOnProvidedResult(String prompt) {
        searchResults.selectFromList(prompt);
        log.info("Pricing calculator opened");
        return new CalculatorPage(driver);
    }
}