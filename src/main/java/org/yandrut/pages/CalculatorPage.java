package org.yandrut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.yandrut.models.FormModel;

import java.util.stream.Collectors;

public class CalculatorPage {
    private final WebDriver driver;

    private final By ADD_TO_ESTIMATE = By.xpath("//button[@data-idom-class='xhASFc']");
    private final By COMPUTE_ENGINE = By.linkText("Compute Engine");
    private final By NUMBER_OF_INSTANCES = By.xpath("//input[@id='i6']");
    private final By ADD_GPU = By.xpath("//button[@aria-label='Add GPUs']");
    private final By GPU_MODEL_DROPDOWN = By.className("VfPpkd-TkwUic");
    private final By GPU_NUMBER_LIST = By.xpath("//*[contains(text(), 'NVIDIA')]");
    private final By LOCAL_SSD_DROPDOWN = By.xpath("//*[text()='Local SSD']");
    private final By LOCAL_SSD_LIST = By.xpath("//*[contains(text(), '375 GB')]");
    private final By LOCATION_DROPDOWN = By.className("VfPpkd-aPP78e");
    private final By LOCATIONS_LIST = By.xpath("//*[contains(text(), 'europe')]");
    private final By COMMITED_USAGE = By.id("1161-year");
    private final By MACHINE_TYPE = By.className("VfPpkd-aPP78e");
    private final By MACHINE_TYPES_LIST = By.xpath("//*[contains(text(), 'n1-standard')]");
    private final By ESTIMATED_PRICE = By.xpath("//*[@class='wFCpDb ']//label");

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnComputeEngine() {
        driver.findElement(ADD_TO_ESTIMATE).click();
        driver.findElement(COMPUTE_ENGINE).click();
    }

    public void fillOutTheForm(FormModel form) {
        setNumberOfInstances(form.getNumberOfInstances());
        setMachineType(form.getMachineType());
        addGpuModel(form.getGpuModel());
        setLocalSSD(form.getLocalSSD());
        setLocation(form.getDataCenterLocation());
        clickOnCommitedUsage();
        form.setEstimatedCost(getEstimatedCost());
    }

    public void setNumberOfInstances(int numberOfInstances) {
        driver.findElement(NUMBER_OF_INSTANCES).sendKeys(String.valueOf(numberOfInstances));
    }

    public void setMachineType(String machineType) {
        driver.findElement(MACHINE_TYPE).click();
        selectFromDropdownList(MACHINE_TYPES_LIST, machineType);
    }

    public void addGpuModel(String gpuModel) {
        driver.findElement(ADD_GPU).click();
        driver.findElement(GPU_MODEL_DROPDOWN).click();
        selectFromDropdownList(GPU_NUMBER_LIST, gpuModel);
    }

    public void setLocalSSD(String ssdName) {
        driver.findElement(LOCAL_SSD_DROPDOWN).click();
        selectFromDropdownList(LOCAL_SSD_LIST, ssdName);
    }

    public void setLocation(String location) {
        driver.findElement(LOCATION_DROPDOWN).click();
        selectFromDropdownList(LOCATIONS_LIST, location);
    }

    public void selectFromDropdownList(By dropdownList, String dropdownElementName) {
        driver.findElements(dropdownList)
                .stream()
                .filter((element -> element.getText().equals(dropdownElementName)))
                .collect(Collectors.toList())
                .get(0)
                .click();
    }

    public void clickOnCommitedUsage() {
        driver.findElement(COMMITED_USAGE).click();
    }

    public String getEstimatedCost() {
        return driver.findElement(ESTIMATED_PRICE).getText();
    }
}