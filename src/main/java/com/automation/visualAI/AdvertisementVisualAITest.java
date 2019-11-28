package com.automation.visualAI;

import com.automation.Utils.DriverUtilsForVisualAI;
import org.testng.annotations.Test;

import static com.automation.Utils.PropertyUtils.getPropertyByKey;

public class AdvertisementVisualAITest extends DriverUtilsForVisualAI {

    @Test
    public void verifyDynamicContentVisualAITest() {
        driver.get(getPropertyByKey("base.url"));
        driver.manage().window().maximize();
        loginPage.login("test", "test");
        eyes.checkWindow("Verify presence of dynamic content");
    }
}

