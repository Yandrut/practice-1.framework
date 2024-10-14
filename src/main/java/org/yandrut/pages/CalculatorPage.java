package org.yandrut.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class CalculatorPage extends AbstractPage {
    private final WebDriver driver;
    private static final Logger log = LogManager.getLogger(CalculatorPage.class);

    @FindBy(xpath = "//button[@data-idom-class='xhASFc']")
    private WebElement addToEstimate;
    @FindBy(xpath = "//div[@data-service-form='8']")
    private WebElement computeEngine;
    @FindBy(xpath = "//input[@max='50000']")
    private WebElement numberOfInstancesInput;
    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    private WebElement addGpu;
    @FindBy(xpath = "//div[@data-field-input-type='2' and @data-field-type='158']" )
    private WebElement gpuModelDropdown;
    @FindBy(xpath = "    //*[@id=\"ow8\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[2]")
    private List<WebElement> gpuNumberList;
    @FindBy(xpath = "//ul[@aria-label='Local SSD']/../..")
    private WebElement localSsdDropdown;
    @FindBy(xpath = "//ul[@aria-label='Local SSD']/li")
    private List<WebElement> localSsdList;
    @FindBy(xpath = "//ul[@aria-label='Region']/../..")
    private WebElement locationDropdown;
    @FindBy(xpath = "//ul[@aria-label='Region']/li")
    private List<WebElement> locationsList;
    @FindBy(xpath = "//label[text()='1 year']/..")
    private WebElement commitedUsage;
    @FindBy(xpath = "//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[3]/div/div/div/div[1]")
    private WebElement machineTypeDropdown;
    @FindBy(xpath = "//ul[@aria-label='Machine type']/li")
    private List<WebElement> machineTypesList;
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

    public CalculatorPage clickOnComputeEngine() {
        addToEstimate.click();
        computeEngine.click();
        log.info("Clicked on compute engine");
        return this;
    }

    public CalculatorPage setNumberOfInstances(String numberOfInstances) {
        numberOfInstancesInput.clear();
        numberOfInstancesInput.sendKeys(numberOfInstances);
        log.info("Number of instances is {}", numberOfInstances);
        return this;
    }

    public CalculatorPage setMachineType(String machineType) {
        machineTypeDropdown.click();
        selectFromDropdownList(machineTypesList, machineType);
        log.info("Machine type is {}", machineType);
        return this;
    }

    public CalculatorPage addGpuModel(String gpuModel) {
        addGpu.click();
        gpuModelDropdown.click();
        selectFromDropdownList(gpuNumberList, gpuModel);
        log.info("GPU model is {}", gpuModel);
        return this;
    }

    public CalculatorPage setLocalSSD(String ssdName) {
        localSsdDropdown.click();
        selectFromDropdownList(localSsdList, ssdName);
        log.info("Local SSD is {}", ssdName);
        return this;
    }

    public CalculatorPage setLocation(String location) {
        locationDropdown.click();
        selectFromDropdownList(locationsList, location);
        log.info("{} location selected", location);
        return this;
    }

    public void clickOnCommitedUsage() {
        commitedUsage.click();
    }

    public String getEstimatedCost() {
        String priceText = estimatedCost.getText();
        log.info("Estimated price is {}", estimatedCost);
        return priceText;
    }

    private void selectFromDropdownList(List<WebElement> dropdownList, String dropdownElementName) {
        dropdownList.stream()
                .filter((e) -> e.getText().equals(dropdownElementName))
                .findAny()
                .ifPresent(WebElement::click);
        log.info("{} option selected", dropdownElementName);
    }
}