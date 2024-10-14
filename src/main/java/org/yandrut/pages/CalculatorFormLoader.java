package org.yandrut.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalculatorFormLoader extends CalculatorPage {

    @FindBy(xpath = "//input[@max='50000']")
    private WebElement numberOfInstancesInput;
    @FindBy(xpath = "//button[@aria-label='Add GPUs']")
    private WebElement addGpu;
    @FindBy(xpath = "//div[@data-field-input-type='2' and @data-field-type='158']" )
    private WebElement gpuModelDropdown;
    @FindBy(xpath = "//ul[@aria-label='GPU Model'")
    private List<WebElement> gpuModelList;
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
    @FindBy(xpath = "//ul[@aria-label='Machine type']/..")
    private WebElement machineTypeDropdown;
    @FindBy(xpath = "//ul[@aria-label='Machine type']/li")
    private List<WebElement> machineTypesList;

    private static final Logger log = LogManager.getLogger(CalculatorFormLoader.class);

    public CalculatorFormLoader(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CalculatorFormLoader setNumberOfInstances(String numberOfInstances) {
        numberOfInstancesInput.clear();
        numberOfInstancesInput.sendKeys(numberOfInstances);
        log.info("Number of instances is {}", numberOfInstances);
        return this;
    }

    public CalculatorFormLoader setMachineType(String machineType) {
        machineTypeDropdown.click();
        selectFromDropdownList(machineTypesList, machineType);
        log.info("Machine type is {}", machineType);
        return this;
    }

    public CalculatorFormLoader addGpuModel(String gpuModel) {
        addGpu.click();
        gpuModelDropdown.click();
        selectFromDropdownList(gpuModelList, gpuModel);
        log.info("GPU model is {}", gpuModel);
        return this;
    }

    public CalculatorFormLoader setLocalSSD(String ssdName) {
        localSsdDropdown.click();
        selectFromDropdownList(localSsdList, ssdName);
        log.info("Local SSD is {}", ssdName);
        return this;
    }

    public CalculatorFormLoader setLocation(String location) {
        locationDropdown.click();
        selectFromDropdownList(locationsList, location);
        log.info("{} location selected", location);
        return this;
    }

    public void clickOnCommitedUsage() {
        commitedUsage.click();
    }

    private void selectFromDropdownList(List<WebElement> dropdownList, String dropdownElementName) {
        dropdownList.stream()
                .filter((e) -> e.getText().equals(dropdownElementName))
                .findAny()
                .ifPresent(WebElement::click);
        log.info("{} option selected", dropdownElementName);
    }
}