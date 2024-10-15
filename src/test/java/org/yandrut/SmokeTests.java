package org.yandrut;

import org.testng.annotations.Test;
import org.yandrut.models.Form;
import org.yandrut.pages.CalculatorPage;
import org.yandrut.pages.CloudPage;
import org.yandrut.selenium.DriverProvider;
import org.yandrut.service.DataReader;
import org.yandrut.service.FormInitializer;
import static org.testng.AssertJUnit.assertEquals;

public class SmokeTests extends BaseTest {
    public static final String SEARCH_PROMPT = DataReader.getTestData("data.provided.searchPrompt");
    public static final String CLOUD_URL = DataReader.getTestData("data.provided.cloudUrl");
    public static final String CALCULATOR_URL = DataReader.getTestData("data.provided.calculatorUrl");
    public static final String EXPECTED_PAGE_NAME = DataReader.getTestData("data.provided.expectedPageName");

    @Test
    public void redirectsToCalculatorPage() {
        CloudPage cloudPage = new CloudPage(DriverProvider.getInstance());

        String actual = cloudPage.navigateToUrl(CLOUD_URL)
                .clickOnTheSearchIcon()
                .sendSearchDetailsAndSubmit(SEARCH_PROMPT)
                .clickOnProvidedResult(SEARCH_PROMPT)
                .getPageName();
        assertEquals(EXPECTED_PAGE_NAME, actual);
    }

    @Test
    public void priceIsGettingEstimated() {
        CalculatorPage calculator = new CalculatorPage(DriverProvider.getInstance());
        Form form = FormInitializer.initializeForm();
        String expected = form.getEstimatedCost();
        String actual = calculator.navigateToUrl(CALCULATOR_URL)
                .clickOnComputeEngine()
                .setNumberOfInstances(form.getNumberOfInstances())
                .setMachineType(form.getMachineType())
                .addGpuModel(form.getGpuModel())
                .setLocalSSD(form.getLocalSSD())
                .setLocation(form.getDataCenterLocation())
                .clickOnCommitedUsage()
                .getEstimatedCost();

        assertEquals(expected, actual);
    }

}
