package com.automation.visualAI;

import com.automation.Utils.DriverUtilsForVisualAI;
import org.testng.annotations.Test;

import static com.automation.Utils.PropertyUtils.getPropertyByKey;

public class CanvasVisualAITest extends DriverUtilsForVisualAI {

    @Test
    /**
     * Selenium has a limitation while attempting to get the javascript data from the chart. Hence this test only checks the presence of the chart and
     * if the chart is still present after clicking on Show next year data.
     */
    public void verifyCanvasChartVisualAITest() {

        getApplitoolDriver().get(getPropertyByKey("base.url"));
        getApplitoolDriver().manage().window().maximize();
        loginPage.login("test", "test");
        homePage.clickCompareExpenses();

        getEyeInstance().open(getApplitoolDriver(), "Hackathon App", "Canvas Chart Visual AI Test");
        getEyeInstance().checkWindow("Compare Expenses Chart");

        canvasPage.clickShowDataNextYear();
        getEyeInstance().checkWindow("Compare Expenses Chart Next Year");
    }
}
