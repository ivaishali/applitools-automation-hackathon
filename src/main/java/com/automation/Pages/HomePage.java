package com.automation.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.automation.Utils.DriverUtils.getDriver;

public class HomePage {
    private WebDriver driver;

    @FindBy(id = "transactionsTable")
    public WebElement transtbl;

    @FindBy(id = "amount")
    public WebElement sortamount;

    @FindBy(id = "showExpensesChart")
    public WebElement showexpenseslink;

    @FindBy(xpath = "//*[@id='flashSale']/img[contains(@src,'flashSale.gif')]")
    public WebElement flashAd1;

    @FindBy(xpath = "//*[@id='flashSale2']/img[contains(@src,'flashSale2.gif')]")
    public WebElement flashAd2;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HashMap<String, String> getTableElements() {
        String company;
        String amount;
        HashMap<String, String> transactions = new HashMap<>();
        List<WebElement> rows = transtbl.findElements(By.tagName("tr"));
        for (int i = 1; i < rows.size(); ++i) {
            company = transtbl.findElement(By.xpath("//*[@id='transactionsTable']/tbody/tr[" + i + "]/td[3]/span")).getText();
            amount = transtbl.findElement(By.xpath("//*[@id='transactionsTable']/tbody/tr[" + i + "]/td[5]/span")).getText();
            transactions.put(company, amount);
        }
        return transactions;
    }

    public void clickSort() {
        sortamount.click();
    }

    public ArrayList<Double> getAmountColumn() {
        String amountcolumnvalue;
        ArrayList<Double> amountcol = new ArrayList<>();
        List<WebElement> rows = transtbl.findElements(By.tagName("tr"));
        for (int j = 1; j < rows.size(); ++j) {
            amountcolumnvalue = transtbl.findElement(By.xpath("//*[@id='transactionsTable']/tbody/tr[" + j + "]/td[5]/span")).getText();
            amountcol.add(Double.parseDouble(amountcolumnvalue.replace(" ", "")
                    .replace(",", "")
                    .replace("+", "")
                    .replace("USD", "")));
        }
        return amountcol;
    }

    public void clickCompareExpenses() {
        showexpenseslink.click();
    }

    public boolean isFirstAdPresent() {
        try {
            if (flashAd1.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isSecondAdPresent() {
        try {
            if (flashAd2.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
