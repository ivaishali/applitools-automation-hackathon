package com.automation.visualAI;

import com.applitools.eyes.selenium.Eyes;
import com.automation.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.automation.Utils.DriverUtilsForVisualAI.*;
import static com.automation.Utils.PropertyUtils.getPropertyByKey;

public class AdvertisementVisualAITest {

    @BeforeClass
    public void beforeClassMethod() {
        initDriverForApplitools();
    }

    @Test
    public void verifyDynamicContentVisualAITest() {

        WebDriver driver = getApplitoolDriver();
        LoginPage loginPage = new LoginPage();
        Eyes eyes = getEyeInstance();
        driver.get(getPropertyByKey("base.url"));
        driver.manage().window().maximize();
        loginPage.login("test", "test");

        eyes.checkWindow("Verify presence of dynamic content");

    }

    @AfterClass
    public void afterClassMethod() {
        tearDownForApplitools();
    }

}
