package com.epam.training.student_mykola_koltutskyi.pages;

import com.epam.training.student_mykola_koltutskyi.elements.Label;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class DetailedViewPage extends Page {

    private final WebDriver driver;

    @FindBy(xpath = "//span[contains(text(), 'n1')]")
    private Label machineTypeText;

    @FindBy(xpath = "//span[text()='GPU Model']/following-sibling::span")
    private Label gpuModel;

    @FindBy(xpath = "//*[text()='Number of Instances']/following-sibling::span")
    private Label numberOfInstances;

    @FindBy(xpath = "//*[text()='Add GPUs']/following-sibling::span")
    private Label addGpuBoolean;

    @FindBy(xpath = "//*[text()='Region']/following-sibling::span")
    private Label regionText;

    @FindBy(xpath = "//*[text()='Local SSD']/following-sibling::span")
    private Label localSsdText;

    public DetailedViewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public DetailedViewPage moveToTheTab(int tabIndex, String tabInfo) {
        Object [] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[tabIndex]);
        log.info("Switching to a new tab: {}\tAt index: {}", tabInfo, tabIndex);
        return this;
    }

    public String getPageName() {
        return driver.getTitle();
    }

    public String getMachineTypeText() {
        return machineTypeText.getText();
    }

    public String getGpuModelText() {
        return gpuModel.getText();
    }

    public String getNumberOfInstancesText() {
        return numberOfInstances.getText();
    }

    public boolean getGpusBoolean() {
        return Boolean.parseBoolean(addGpuBoolean.getText());
    }

    public String getRegionText() {
        return regionText.getText();
    }

    public String getLocalSsdText() {
        return localSsdText.getText();
    }
}