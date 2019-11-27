package com.automation.traditional;

import com.automation.Pages.LoginPage;
import com.automation.Utils.PropertyUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.automation.Utils.DriverUtils.*;

public class LoginDataDrivenTraditionalTest {

    @BeforeClass
    public void beforeClassMethod() {
        initDriver();
    }

    @Test
    /**
     * This test verifies the four combination of attempted logins and returns error if the error message is incorrect or if the correct combination
     * of credentials returns an error message
     */
    public void testLoginMessages() {
        LoginPage loginPage = new LoginPage();
        WebDriver driver = getDriver();
        driver.get(PropertyUtils.getPropertyByKey("base.url"));
        Assert.assertEquals(loginPage.login("", ""), "Both Username and Password must be present", "Error message incorrect when username and password is missing");
        Assert.assertEquals(loginPage.login("test", ""), "Password must be present", "Error message incorrect when password is missing");
        loginPage.usernameTxtField.clear();
        Assert.assertEquals(loginPage.login("", "test"), "Username must be present", "Error message incorrect when username is missing");
        loginPage.usernameTxtField.clear();
        Assert.assertEquals(loginPage.login("test", "test"), null, "User unable to login when valid credentials are provided");
    }

    @AfterClass
    public void afterClassMethod() {
        tearDown();
    }

}
