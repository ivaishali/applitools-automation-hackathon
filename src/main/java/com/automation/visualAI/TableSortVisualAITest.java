package com.automation.visualAI;

import com.applitools.eyes.selenium.Eyes;
import com.automation.Pages.HomePage;
import com.automation.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.automation.Utils.DriverUtilsForVisualAI.*;
import static com.automation.Utils.PropertyUtils.getPropertyByKey;

public class TableSortVisualAITest {

    @BeforeClass
    public void beforeClassMethod() {
        initDriverForApplitools();
    }

    @Test
    public void verifyTableSortVisualAITest() {

        WebDriver driver = getApplitoolDriver();
        Eyes eyes = getEyeInstance();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        driver.get(getPropertyByKey("base.url"));

        driver.manage().window().maximize();
        loginPage.login("test", "test");
        homePage.clickSort();

        eyes.open(driver, "Hackathon App", "Table Sort Visual AI Test");
        eyes.checkWindow("Verify Table Sort");
    }

    @AfterClass
    public void afterClassMethod() {
        tearDownForApplitools();
    }
}
