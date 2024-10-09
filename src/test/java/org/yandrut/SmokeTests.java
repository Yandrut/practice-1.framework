package org.yandrut;

import org.testng.annotations.Test;
import org.yandrut.pages.CloudPage;
import selenium.DriverProvider;

import static org.testng.AssertJUnit.assertEquals;

public class SmokeTests extends BaseTest {
    private final String searchPrompt = "Google Cloud Pricing Calculator";

    @Test
    public void redirectsToCalculatorPage() {
        CloudPage cloudPage = new CloudPage(DriverProvider.getInstance());
        cloudPage.clickOnTheSearchIcon();

        cloudPage.sendSearchDetailsAndSubmit(searchPrompt);
        cloudPage.clickOnPricingCalculator();

        String expected = searchPrompt;
        String actual = cloudPage.getPageName();
        assertEquals(expected, actual);
    }
}
