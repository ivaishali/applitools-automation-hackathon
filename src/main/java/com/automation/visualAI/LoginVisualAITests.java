package com.automation.visualAI;

import com.applitools.eyes.selenium.Eyes;
import com.automation.Pages.HomePage;
import com.automation.Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.automation.Utils.DriverUtilsForVisualAI.getApplitoolDriver;
import static com.automation.Utils.DriverUtilsForVisualAI.getEyeInstance;
import static com.automation.Utils.PropertyUtils.getPropertyByKey;

public class LoginVisualAITests {


    @Test
    public void verifyUIVisualAITest(){
        WebDriver driver = getApplitoolDriver();
        Eyes eyes = getEyeInstance();
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();

        driver.get(getPropertyByKey("base.url"));
        driver.manage().window().maximize();
        eyes.open(driver, "Hackathon App", "Login UI Visual AI Test");
        eyes.checkWindow("Login Page");

        loginPage.togglethemeLink.click();
        eyes.checkWindow("Login Page after theme change");
    }
}
