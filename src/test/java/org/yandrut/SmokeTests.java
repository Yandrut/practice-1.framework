package org.yandrut;

import org.testng.annotations.Test;
import org.yandrut.models.FormModel;
import org.yandrut.pages.CalculatorPage;
import org.yandrut.pages.CloudPage;
import selenium.DriverProvider;

import static org.testng.AssertJUnit.assertEquals;

public class SmokeTests extends BaseTest {
    private final String searchPrompt = "Google Cloud Pricing Calculator";
    private final String CALCULATOR_URL = "https://cloud.google.com/products/calculator";
    private CloudPage cloudPage;
    private CalculatorPage calculator;

    @Test
    public void redirectsToCalculatorPage() {
        cloudPage = new CloudPage(DriverProvider.getInstance());
        cloudPage.clickOnTheSearchIcon();

        cloudPage.sendSearchDetailsAndSubmit(searchPrompt);
        cloudPage.clickOnPricingCalculator();

        String expected = searchPrompt;
        String actual = cloudPage.getPageName();
        assertEquals(expected, actual);
    }

    @Test
    public void fillOutTheForm() {
        calculator = new CalculatorPage(DriverProvider.getInstance());
        FormModel form = new FormModel();

        calculator.navigateToUrl(CALCULATOR_URL);
        calculator.clickOnComputeEngine();
        calculator.setNumberOfInstances(form.getNumberOfInstances());
        calculator.setMachineType(form.getMachineType());
        calculator.addGpuModel(form.getGpuModel());
        calculator.setLocalSSD(form.getLocalSSD());
        calculator.setLocation(form.getDataCenterLocation());
        calculator.clickOnCommitedUsage();
        calculator.getEstimatedCost();
    }
}
