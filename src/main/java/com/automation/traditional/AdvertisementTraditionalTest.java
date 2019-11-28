package com.automation.traditional;

import com.automation.Pages.HomePage;
import com.automation.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.automation.Utils.DriverUtils.*;
import static com.automation.Utils.PropertyUtils.getPropertyByKey;

public class AdvertisementTraditionalTest {

    @BeforeClass
    public void beforeClassMethod() {
        initDriver();
    }

    @Test
    /**
     * This test verifies the presence of flash sales ads- It expects to see a specific ad gif and flags if the gif is different or not present.
     */
    public void testDynamicContent() {
        WebDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        driver.get(getPropertyByKey("base.adUrl"));
        loginPage.login("test", "test");
        Assert.assertTrue(homePage.isFirstAdPresent(), "Flash Sale Ad-1 is missing or different from expected");
        Assert.assertTrue(homePage.isSecondAdPresent(), "Flash Sale Ad-2 is missing or different from expected");

    }

    @AfterClass
    public void afterClassMethod() {
        tearDown();
    }

}
