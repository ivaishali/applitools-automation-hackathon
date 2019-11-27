package com.automation.visualAI;

import com.applitools.eyes.selenium.Eyes;
import com.automation.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.automation.Utils.DriverUtilsForVisualAI.*;
import static com.automation.Utils.PropertyUtils.getPropertyByKey;

public class LoginDataDrivenVisualAITest {

    @BeforeClass
    public void beforeClassMethod() {
        initDriverForApplitools();
    }

    @Test
    public void verifyLoginVisualAITest (){

        WebDriver driver = getApplitoolDriver();
        Eyes eyes = getEyeInstance();
        LoginPage loginPage = new LoginPage();

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

    @AfterClass
    public void afterClassMethod() {
        tearDownForApplitools();
    }

}
