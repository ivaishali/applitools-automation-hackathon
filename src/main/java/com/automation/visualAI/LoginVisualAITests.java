package com.automation.visualAI;

import com.automation.Utils.DriverUtilsForVisualAI;
import org.testng.annotations.Test;

import static com.automation.Utils.PropertyUtils.getPropertyByKey;

public class LoginVisualAITests extends DriverUtilsForVisualAI {

    @Test
    public void verifyUIVisualAITest() {

        driver.get(getPropertyByKey("base.url"));
        driver.manage().window().maximize();
        eyes.open(driver, "Hackathon App", "Login UI Visual AI Test");
        eyes.checkWindow("Login Page");

        loginPage.togglethemeLink.click();
        eyes.checkWindow("Login Page after theme change");
    }
}
