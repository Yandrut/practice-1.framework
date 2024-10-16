package com.epam.training.student_mykola_koltutskyi;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.epam.training.student_mykola_koltutskyi.models.Form;
import com.epam.training.student_mykola_koltutskyi.pages.CalculatorPage;
import com.epam.training.student_mykola_koltutskyi.pages.CloudPage;
import com.epam.training.student_mykola_koltutskyi.pages.DetailedViewPage;
import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import com.epam.training.student_mykola_koltutskyi.service.DataReader;
import com.epam.training.student_mykola_koltutskyi.service.FormInitializer;
import static org.testng.AssertJUnit.assertEquals;

public class AllTest extends BaseTest {

    public static final String SEARCH_PROMPT = DataReader.getTestData("data.provided.searchPrompt");
    public static final String CLOUD_URL = DataReader.getTestData("data.provided.cloudUrl");
    public static final String CALCULATOR_URL = DataReader.getTestData("data.provided.calculatorUrl");
    public static final String EXPECTED_PAGE_NAME = DataReader.getTestData("data.provided.expectedPageName");
    public static final int TAB_INDEX = Integer.parseInt(DataReader.getTestData("data.provided.tabIndex"));
    public static final String TAB_NAME = DataReader.getTestData("data.provided.tabInfo");
    private CalculatorPage calculator;
    private Form form;
    private DetailedViewPage detailedView;
    private static final WebDriver driver = DriverProvider.getInstance();


    @Test
    public void redirectsToCalculatorPage() {
        CloudPage cloudPage = new CloudPage(driver);

        var actual = cloudPage.navigateToUrl(CLOUD_URL)
                .clickOnTheSearchIcon()
                .sendSearchDetailsAndSubmit(SEARCH_PROMPT)
                .clickOnProvidedResult(SEARCH_PROMPT)
                .getPageName();
        assertEquals(EXPECTED_PAGE_NAME, actual);
    }

    @Test
    public void priceIsGettingEstimated() {
        calculator = new CalculatorPage(driver);
        form = FormInitializer.initializeForm();

        var expected = form.getEstimatedCost();
        var actual = calculator.navigateToUrl(CALCULATOR_URL)
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

    @Test(dependsOnMethods = "priceIsGettingEstimated")
    public void redirectsToDetailedView() {
        detailedView = calculator
                .clickOnDetailedView()
                .moveToTheTab(TAB_INDEX, TAB_NAME);
        assertEquals(TAB_NAME, detailedView.getPageName());
    }

    @Test(dependsOnMethods = "redirectsToDetailedView")
    public void correctDataProvided() {
        SoftAssert softAssert = new SoftAssert();

        var numberOfInstancesActual = detailedView.getNumberOfInstancesText();
        softAssert.assertEquals(form.getNumberOfInstances(), numberOfInstancesActual);

        String machineTypeActual = detailedView.getMachineTypeText();
        var expectedType = form.getMachineType();
        softAssert.assertTrue(machineTypeActual.contains(expectedType));

        var addedGPUsActual = detailedView.getGpusBoolean();
        softAssert.assertTrue(addedGPUsActual);

        var gpuModelActual = detailedView.getGpuModelText();
        softAssert.assertEquals(form.getGpuModel(), gpuModelActual);

        String localSsdActual = detailedView.getLocalSsdText();
        softAssert.assertEquals(form.getLocalSSD(), localSsdActual);

        var locationActual = detailedView.getRegionText();
        softAssert.assertEquals(form.getDataCenterLocation(), locationActual);

        softAssert.assertAll();
    }
}