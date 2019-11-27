package com.automation.visualAI;

import com.automation.Pages.CanvasPage;
import com.automation.Pages.HomePage;
import com.automation.Pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.automation.Utils.DriverUtilsForVisualAI.*;
import static com.automation.Utils.PropertyUtils.getPropertyByKey;

public class CanvasVisualAITest {

    @BeforeClass
    public void beforeClassMethod() {
        initDriverForApplitools();
    }

    @Test
    /**
     * Selenium has a limitation while attempting to get the javascript data from the chart. Hence this test only checks the presence of the chart and
     * if the chart is still present after clicking on Show next year data.
     */
    public void verifyCanvasChartVisualAITest() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        CanvasPage canvasPage = new CanvasPage();

        getApplitoolDriver().get(getPropertyByKey("base.url"));
        getApplitoolDriver().manage().window().maximize();
        loginPage.login("test", "test");
        homePage.clickCompareExpenses();

        getEyeInstance().open(getApplitoolDriver(), "Hackathon App", "Canvas Chart Visual AI Test");
        getEyeInstance().checkWindow("Compare Expenses Chart");

        canvasPage.clickShowDataNextYear();
        getEyeInstance().checkWindow("Compare Expenses Chart Next Year");
    }

    @AfterClass
    public void afterClassMethod() {
        tearDownForApplitools();
    }
}
