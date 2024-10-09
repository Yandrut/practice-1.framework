package org.yandrut;

import org.testng.annotations.Test;
import org.yandrut.models.Form;
import org.yandrut.pages.CalculatorPage;
import org.yandrut.pages.CloudPage;
import org.yandrut.selenium.DriverProvider;
import org.yandrut.service.FormInitializer;

import static org.testng.AssertJUnit.assertEquals;

public class SmokeTests extends BaseTest {
    private final String searchPrompt = "Google Cloud Pricing Calculator";
    private final String CALCULATOR_URL = "https://cloud.google.com/products/calculator";

    @Test
    public void redirectsToCalculatorPage() {
        CloudPage cloudPage = new CloudPage(DriverProvider.getInstance());

        cloudPage
                .clickOnTheSearchIcon()
                .sendSearchDetailsAndSubmit(searchPrompt)
                .clickOnPricingCalculator();

        String actual = cloudPage.getPageName();
        assertEquals(searchPrompt, actual);
    }

    @Test
    public void allowsToFillTheForm() {
        CalculatorPage calculator = new CalculatorPage(DriverProvider.getInstance());
        Form form = FormInitializer.initializeForm();

        calculator.navigateToUrl(CALCULATOR_URL)
                .clickOnComputeEngine()
                .setNumberOfInstances(form.getNumberOfInstances())
                .setMachineType(form.getMachineType())
                .addGpuModel(form.getGpuModel())
                .setLocalSSD(form.getLocalSSD())
                .setLocation(form.getDataCenterLocation())
                .clickOnCommitedUsage();
        form.setEstimatedCost(calculator.getEstimatedCost());
    }
}