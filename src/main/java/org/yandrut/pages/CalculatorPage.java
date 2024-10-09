package org.yandrut.pages;

import org.openqa.selenium.*;

public class CalculatorPage {
    private final WebDriver driver;

    private final By ADD_TO_ESTIMATE = By.xpath("//button[@data-idom-class='xhASFc']");
    private final By COMPUTE_ENGINE = By.xpath("//div[@data-service-form='8']");
    private final By NUMBER_OF_INSTANCES = By.xpath("//input[@max='50000']");
    private final By ADD_GPU = By.xpath("//button[@aria-label='Add GPUs']");
    private final By GPU_MODEL_DROPDOWN = By.xpath("//div[@data-field-input-type='2' and @data-field-type='158']");
    private final By GPU_NUMBER_LIST = By.xpath("    //*[@id=\"ow8\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[27]/div/div[1]/div/div/div/div[2]");
    private final By LOCAL_SSD_DROPDOWN = By.xpath("//ul[@aria-label='Local SSD']/../..");
    private final By LOCAL_SSD_LIST = By.xpath("//ul[@aria-label='Local SSD']/li");
    private final By LOCATION_DROPDOWN = By.xpath("//ul[@aria-label='Region']/../..");
    private final By LOCATIONS_LIST = By.xpath("//ul[@aria-label='Region']/li");
    private final By COMMITED_USAGE = By.xpath("//label[text()='1 year']/..");
    private final By MACHINE_TYPE = By.xpath("//*[@id=\"ucj-1\"]/div/div/div/div/div/div/div/div[1]/div/div[2]/div[3]/div[11]/div/div/div[2]/div/div[1]/div[3]/div/div/div/div[1]");
    private final By MACHINE_TYPES_LIST = By.xpath("//ul[@aria-label='Machine type']/li");
    private final By ESTIMATED_PRICE = By.xpath("//div[text()='Estimated cost']/following::label");

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToUrl(String url) {
        driver.get(url);
    }

    public void clickOnComputeEngine() {
        driver.findElement(ADD_TO_ESTIMATE).click();
        driver.findElement(COMPUTE_ENGINE).click();
    }

    public void setNumberOfInstances(int numberOfInstances) {
        WebElement inputField = driver.findElement(NUMBER_OF_INSTANCES);
        inputField.clear();
        inputField.sendKeys(String.valueOf(numberOfInstances));
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
                .filter((e) -> e.getText().equals(dropdownElementName))
                .findAny()
                .ifPresent(WebElement::click);
    }

    public void clickOnCommitedUsage() {
        driver.findElement(COMMITED_USAGE).click();
    }

    public String getEstimatedCost() {
        return driver.findElement(ESTIMATED_PRICE).getText();
    }
}