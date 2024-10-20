package com.epam.training.student_mykola_koltutskyi;

import com.epam.training.student_mykola_koltutskyi.utils.TestListener;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import com.epam.training.student_mykola_koltutskyi.models.Form;
import com.epam.training.student_mykola_koltutskyi.pages.CalculatorPage;
import com.epam.training.student_mykola_koltutskyi.pages.CloudPage;
import com.epam.training.student_mykola_koltutskyi.pages.DetailedViewPage;
import com.epam.training.student_mykola_koltutskyi.drivers.DriverProvider;
import com.epam.training.student_mykola_koltutskyi.service.DataReader;
import com.epam.training.student_mykola_koltutskyi.service.FormInitializer;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(TestListener.class)
public class AllTest extends BaseTest {

    public static final String SEARCH_PROMPT = DataReader.getTestData("data.provided.searchPrompt");
    public static final String CLOUD_URL = DataReader.getTestData("data.provided.cloudUrl");
    public static final String CALCULATOR_URL = DataReader.getTestData("data.provided.calculatorUrl");
    public static final String EXPECTED_PAGE_NAME = DataReader.getTestData("data.provided.expectedPageName");
    public static final int TAB_INDEX = Integer.parseInt(DataReader.getTestData("data.provided.tabIndex"));
    public static final String TAB_NAME = DataReader.getTestData("data.provided.tabInfo");


    @Test
    void redirectsToCalculatorPage() {
        CloudPage cloudPage = new CloudPage(DriverProvider.getInstance());

        var actual = cloudPage.navigateToUrl(CLOUD_URL)
                .clickOnTheSearchIcon()
                .sendSearchDetailsAndSubmit(SEARCH_PROMPT)
                .clickOnProvidedResult(SEARCH_PROMPT)
                .getPageName();
        assertEquals(EXPECTED_PAGE_NAME, actual);
    }

    @Test()
    void priceIsGettingEstimated() {
        CalculatorPage calculator = new CalculatorPage(DriverProvider.getInstance());
        Form form = FormInitializer.initializeForm();

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

        DetailedViewPage detailedView = new DetailedViewPage(DriverProvider.getInstance());
        calculator
                .clickOnDetailedView()
                .moveToTheTab(TAB_INDEX, TAB_NAME);
        assertEquals(TAB_NAME, detailedView.getPageName());

        SoftAssertions softAssert = new SoftAssertions();

        var numberOfInstancesActual = detailedView.getNumberOfInstancesText();
        softAssert.assertThat(numberOfInstancesActual).isEqualTo(form.getNumberOfInstances());

        String machineTypeActual = detailedView.getMachineTypeText();
        var expectedType = form.getMachineType();
        softAssert.assertThat(machineTypeActual).contains(expectedType);

        var addedGPUsActual = detailedView.getGpusBoolean();
        softAssert.assertThat(addedGPUsActual).isTrue();

        var gpuModelActual = detailedView.getGpuModelText();
        softAssert.assertThat(form.getGpuModel()).isEqualTo(gpuModelActual);

        String localSsdActual = detailedView.getLocalSsdText();
        softAssert.assertThat(form.getLocalSSD()).isEqualTo(localSsdActual);

        var locationActual = detailedView.getRegionText();
        softAssert.assertThat(form.getDataCenterLocation()).isEqualTo(locationActual);

        softAssert.assertAll();
    }
}