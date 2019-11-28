package com.automation.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.automation.Utils.DriverUtils.getDriver;

public class CanvasPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='canvas']")
    public WebElement chart;

    @FindBy(xpath = "//*[@id='addDataset']")
    public WebElement showdatabtn;

    public CanvasPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isChartAvailable() {
        if (chart.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }

    public void clickShowDataNextYear() {
        showdatabtn.click();
    }

}