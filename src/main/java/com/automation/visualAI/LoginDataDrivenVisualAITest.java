package com.automation.visualAI;

import com.automation.Utils.DriverUtilsForVisualAI;
import org.testng.annotations.Test;

import static com.automation.Utils.PropertyUtils.getPropertyByKey;

public class LoginDataDrivenVisualAITest extends DriverUtilsForVisualAI {

    @Test
    public void verifyLoginVisualAITest (){

        driver.get(getPropertyByKey("base.url"));
        driver.manage().window().maximize();
        eyes.open(driver, "Hackathon App", "Data driven Visual AI tests");

        loginPage.login("", "");
        eyes.checkWindow("Login Page blank credentials");

        loginPage.login("test","");
        eyes.checkWindow("Login Page blank password");

        loginPage.usernameTxtField.clear();
        loginPage.login("","test");
        eyes.checkWindow("Login Page blank username");

        loginPage.usernameTxtField.clear();
        loginPage.passwordTxtField.clear();
        loginPage.login("test","test");
        eyes.checkWindow("Login Page correct credentials");

    }
}
