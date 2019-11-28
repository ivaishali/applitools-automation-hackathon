package com.automation.traditional;

import com.automation.Pages.CanvasPage;
import com.automation.Pages.HomePage;
import com.automation.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.automation.Utils.DriverUtils.*;
import static com.automation.Utils.PropertyUtils.getPropertyByKey;

public class CanvasTraditionalTest {

    @BeforeClass
    public void beforeClassMethod() {
        initDriver();
    }

    @Test
    /**
     * Selenium has a limitation while attempting to get the javascript data from the chart. Hence this test only checks the presence of the chart and
     * if the chart is still present after clicking on Show next year data.
     */
    public void verifyCanvasChart() {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        CanvasPage canvasPage = new CanvasPage(driver);
        driver.get(getPropertyByKey("base.url"));
        loginPage.login("test", "test");
        homePage.clickCompareExpenses();
        Assert.assertTrue(canvasPage.isChartAvailable(), "Compare Expenses chart is not present on the page");
        canvasPage.clickShowDataNextYear();
        Assert.assertTrue(canvasPage.isChartAvailable(), "Compare expenses chart is not present on page when attempting to show data for next year");
    }

    @AfterClass
    public void afterClassMethod() {
        tearDown();
    }
}
