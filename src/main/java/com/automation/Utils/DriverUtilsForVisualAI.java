package com.automation.Utils;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import com.automation.Pages.CanvasPage;
import com.automation.Pages.HomePage;
import com.automation.Pages.LoginPage;
import com.automation.visualAI.CanvasVisualAITest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.automation.Utils.PropertyUtils.getPropertyByKey;
import static com.automation.Utils.PropertyUtils.loadProperties;

public class DriverUtilsForVisualAI {
    public static WebDriver driver;
    public static Eyes eyes;
    public static BatchInfo batchInfo;
    public static ClassicRunner classicRunner;
    public static LoginPage loginPage;
    public static HomePage homePage;
    public static CanvasPage canvasPage;


    @BeforeClass
    public static void initDriverForApplitools() {
        if (driver == null) {
            loadProperties();
            initEye();
            if (getPropertyByKey("driver.name").equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
                ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless", "--disable-gpu", "--ignore-certificate-errors");
                driver = new ChromeDriver(options);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            loginPage = new LoginPage(getApplitoolDriver());
            homePage = new HomePage(getApplitoolDriver());
            canvasPage = new CanvasPage(getApplitoolDriver());
        }
    }

    public static WebDriver getApplitoolDriver() {
        if (driver == null) {
            initDriverForApplitools();
        }
        return driver;
    }

    @AfterClass
    public static void tearDownForApplitools() {
        closeApplitoolEye();
        driver.manage().deleteAllCookies();
        driver.quit();
    }


    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.moveFile(screenshot, new File("errorscreens/" + result.getName() + ".png"));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

    public static String getAdUrl() {
        if (getPropertyByKey("version").equalsIgnoreCase("v1")) {
            return getPropertyByKey("base.adUrl");
        } else {
            return getPropertyByKey("v2.adUrl");
        }
    }


    public static void initEye() {
        batchInfo = new BatchInfo("Hackathon Dynamic Content Batch");
        classicRunner = new ClassicRunner();
        eyes = new Eyes(classicRunner);
        eyes.setApiKey(getPropertyByKey("applitools.api.key"));
        eyes.setBatch(batchInfo);
    }

    public static Eyes getEyeInstance() {
        if (eyes == null) {
            initEye();
        }
        return eyes;
    }

    public static void closeApplitoolEye() {
        eyes.closeAsync();
        eyes.abortIfNotClosed();
    }
}
