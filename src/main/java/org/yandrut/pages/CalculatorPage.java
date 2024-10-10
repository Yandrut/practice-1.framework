package org.yandrut.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

public class CalculatorPage extends AbstractPage {
    private final WebDriver driver;
    private static final Logger log = LogManager.getLogger(CalculatorPage.class);

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
        super(driver);
        this.driver = driver;
    }

    public CalculatorPage navigateToUrl(String url) {
        driver.get(url);
        log.info("Moving to URL: {}", url);
        return this;
    }

    public CalculatorPage clickOnComputeEngine() {
        driver.findElement(ADD_TO_ESTIMATE).click();
        driver.findElement(COMPUTE_ENGINE).click();
        log.info("Clicked on compute engine");
        return this;
    }

    public CalculatorPage setNumberOfInstances(String numberOfInstances) {
        WebElement inputField = driver.findElement(NUMBER_OF_INSTANCES);
        inputField.clear();
        inputField.sendKeys(numberOfInstances);
        log.info("Number of instances is {}", numberOfInstances);
        return this;
    }

    public CalculatorPage setMachineType(String machineType) {
        driver.findElement(MACHINE_TYPE).click();
        selectFromDropdownList(MACHINE_TYPES_LIST, machineType);
        log.info("Machine type is {}", machineType);
        return this;
    }

    public CalculatorPage addGpuModel(String gpuModel) {
        driver.findElement(ADD_GPU).click();
        driver.findElement(GPU_MODEL_DROPDOWN).click();
        selectFromDropdownList(GPU_NUMBER_LIST, gpuModel);
        log.info("GPU model is {}", gpuModel);
        return this;
    }

    public CalculatorPage setLocalSSD(String ssdName) {
        driver.findElement(LOCAL_SSD_DROPDOWN).click();
        selectFromDropdownList(LOCAL_SSD_LIST, ssdName);
        log.info("Local SSD is {}", ssdName);
        return this;
    }

    public CalculatorPage setLocation(String location) {
        driver.findElement(LOCATION_DROPDOWN).click();
        selectFromDropdownList(LOCATIONS_LIST, location);
        log.info("{} location selected", location);
        return this;
    }

    public void selectFromDropdownList(By dropdownList, String dropdownElementName) {
        driver.findElements(dropdownList)
                .stream()
                .filter((e) -> e.getText().equals(dropdownElementName))
                .findAny()
                .ifPresent(WebElement::click);
        log.info("{} option selected", dropdownElementName);
    }

    public void clickOnCommitedUsage() {
        driver.findElement(COMMITED_USAGE).click();
    }

    public String getEstimatedCost() {
        String estimatedPrice = driver.findElement(ESTIMATED_PRICE).getText();
        log.info("Estimated price is {}", estimatedPrice);
        return estimatedPrice;
    }
}