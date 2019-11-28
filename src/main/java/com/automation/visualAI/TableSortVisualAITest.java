package com.automation.visualAI;

import com.automation.Utils.DriverUtilsForVisualAI;
import org.testng.annotations.Test;

import static com.automation.Utils.PropertyUtils.getPropertyByKey;

public class TableSortVisualAITest extends DriverUtilsForVisualAI {

    @Test
    public void verifyTableSortVisualAITest() {

        driver.get(getPropertyByKey("base.url"));

        driver.manage().window().maximize();
        loginPage.login("test", "test");
        homePage.clickSort();

        eyes.open(driver, "Hackathon App", "Table Sort Visual AI Test");
        eyes.checkWindow("Verify Table Sort");
    }
}
