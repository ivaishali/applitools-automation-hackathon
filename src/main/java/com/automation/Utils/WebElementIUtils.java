package com.automation.Utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.automation.Utils.DriverUtils.getDriver;

public class WebElementIUtils {

    static Long timeout = Long.parseLong("30");
    static WebDriverWait wait = new WebDriverWait(getDriver(), timeout);

    public static void waitForVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
