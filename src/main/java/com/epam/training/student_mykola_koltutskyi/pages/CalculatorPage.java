package com.epam.training.student_mykola_koltutskyi.pages;

import com.epam.training.student_mykola_koltutskyi.elements.*;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class CalculatorPage extends Page {

    @FindBy(xpath = "//button[@data-idom-class='xhASFc']")
    private Button addToEstimate;
    @FindBy(xpath = "//div[@role='button' and @data-idx='0']")
    private Button computeEngine;

    @FindBy(xpath = "//ul[@aria-label='GPU Model']/../..")
    private Button gpuModelDropdown;
    @FindBy(xpath = "//ul[@aria-label='Region']/..//..")
    private Button locationDropdown;
    @FindBy(xpath = "//ul[@aria-label='Local SSD']/../..")
    private Button localSsdDropdown;
    @FindBy(xpath = "//ul[@aria-label='Machine type']/../..")
    private Button machineTypeDropdown;

    @FindBy(xpath = "//ul[@aria-label='GPU Model']/li")
    private ElementList gpuModelElementList;
    @FindBy(xpath = "//ul[@aria-label='Local SSD']/li")
    private ElementList localSsdElementList;
    @FindBy(xpath = "//ul[@aria-label='Region']/li")
    private ElementList locationsElementList;
    @FindBy(xpath = "//ul[@aria-label='Machine type']/li")
    private ElementList machineTypesElementList;

    @FindBy(xpath = "//input[@value='1']")
    private InputText numberOfInstancesInput;
    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    private Button addGpu;
    @FindBy(xpath = "//label[text()='1 year']/..")
    private Button commitedUsage;
    @FindBy(xpath = "//div[text()='Estimated cost']/following::label")
    private Label estimatedCost;
    @FindBy(xpath = "//a[@aria-label='Open detailed view']")
    private Button openDetailedView;

    private final String suffixForTextLocators = "/../..//div/span/following-sibling::span/span";
    private final String machineTextSelectorString = "//ul[@aria-label='Machine type']" + suffixForTextLocators;
    @FindBy(xpath = machineTextSelectorString)
    private Label machineTypeText;

    private final String gpuTextSelectorString = "//ul[@aria-label='GPU Model']" + suffixForTextLocators;
    @FindBy(xpath = gpuTextSelectorString)
    private Label gpuModelText;

    private final String localSSDTextLocatorString = "//ul[@aria-label='Local SSD']" + suffixForTextLocators;
    @FindBy(xpath = localSSDTextLocatorString)
    private Label localSSDText;

    private final String regionTextLocatorString = "//ul[@aria-label='Region']" + suffixForTextLocators;
    @FindBy(xpath = regionTextLocatorString)
    private Label regionTextLocator;

    private final WebDriver driver;


    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public CalculatorPage navigateToUrl(String url) {
        super.navigateToUrl(url);
        return this;
    }

    public String getPageName() {
        return driver.getTitle();
    }

    public CalculatorPage clickOnComputeEngine() {
        addToEstimate.waitAndClick();
        computeEngine.waitAndClick();
        log.info("Clicked on compute engine");
        return this;
    }

    public CalculatorPage setNumberOfInstances(String numberOfInstances) {
        numberOfInstancesInput.clear();
        numberOfInstancesInput.sendKeys(numberOfInstances);
        log.info("Number of instances is: {}", numberOfInstances);
        return this;
    }

    public CalculatorPage setMachineType(String machineType) {
        machineTypeDropdown.waitAndClick();
        machineTypesElementList.selectFromList(machineType);
        log.info("Machine type is: {} ", machineTypeText.getText());
        return this;
    }

    public CalculatorPage addGpuModel(String gpuModel) {
        addGpu.waitAndClick();
        gpuModelDropdown.waitAndClick();
        gpuModelElementList.selectFromList(gpuModel);
        log.info("GPU model is: {} ", gpuModelText.getText());
        return this;
    }

    public CalculatorPage setLocalSSD(String ssdName) {
        localSsdDropdown.waitAndClick();
        localSsdElementList.selectFromList(ssdName);
        log.info("Local SSD is: {} ", localSSDText.getText());
        return this;
    }

    public CalculatorPage setLocation(String location) {
        locationDropdown.waitAndClick();
        locationsElementList.selectFromList(location);
        log.info("Location is: {} ", regionTextLocator.getText());
        return this;
    }

    public CalculatorPage clickOnCommitedUsage() {
        commitedUsage.waitAndClick();
        return this;
    }

    public String getEstimatedCost() {
        var priceText = estimatedCost.getText();
        log.info("Actual price is {}", priceText);
        return priceText;
    }

    public DetailedViewPage clickOnDetailedView() {
        openDetailedView.waitAndClick();
        log.info("Opening detailed view");
        return new DetailedViewPage(driver);
    }
}