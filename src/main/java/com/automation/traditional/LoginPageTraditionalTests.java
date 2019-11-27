package com.automation.traditional;

import com.automation.Pages.CanvasPage;
import com.automation.Pages.HomePage;
import com.automation.Pages.LoginPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.automation.Utils.DriverUtils.initDriver;
import static com.automation.Utils.DriverUtils.tearDown;

public class LoginPageTraditionalTests {

    @BeforeClass
    public void beforeClassMethod() {
        initDriver();
    }

    @Test
    public void testTraditional() {
        LoginPage loginPage = new LoginPage();
        HomePage homePage = new HomePage();
        CanvasPage canvasPage = new CanvasPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.verifyPageHeaderText(), "Page heading is not available or incorrect");
        softAssert.assertTrue(loginPage.verifyToggleLink(), "Toggle theme option is not enabled or not present on the page");
        softAssert.assertTrue(loginPage.verifyUsernameInput(), "Username input field is not enabled or not present on the page");
        softAssert.assertTrue(loginPage.verifyUsernameImage(), "Username image is not available or is different");
        softAssert.assertTrue(loginPage.verifyUsernameLbl(), "Username label is not displayed or is different");
        softAssert.assertTrue(loginPage.verifyPasswordInput(), "Password input field is not available or not enabled");
        softAssert.assertTrue(loginPage.verifyPasswordImg(), "Password image is not displayed or is different");
        softAssert.assertTrue(loginPage.verifyPasswordLbl(), "Password label is not displayed or is different");
        softAssert.assertTrue(loginPage.verifyLoginBtn(), "Login button is not enabled or is not present on the page");
        softAssert.assertTrue(loginPage.verifyRmbrMeCheckbox(), "Remember Me checkbox is not enabled or is not present on the page");
        softAssert.assertTrue(loginPage.verifyTwitterLinkIcon(), "Twitter link is not enabled or is different");
        softAssert.assertTrue(loginPage.verifyFbLinkIcon(), "Facebook link is not enabled or is different");
        softAssert.assertTrue(loginPage.verifyLinkedinLinkIcon(), "Linkedin link is not enabled or is different");
        softAssert.assertAll();
    }

    @AfterClass
    public void afterClassMethod() {
        tearDown();
    }
}
