package com.automation.traditional;

import com.automation.Pages.HomePage;
import com.automation.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.*;
import java.util.stream.Collectors;

import static com.automation.Utils.DriverUtils.*;
import static com.automation.Utils.PropertyUtils.getPropertyByKey;

public class TableSortTraditionalTest {

    @BeforeClass
    public void beforeClassMethod() {
        initDriver();
    }

    @Test
    /**
     * This test verifies that the sorting of amount column is correct. Furthermore, it also confirms that data integrity is maintained and
     * the description matches the amount after sorting
     */
    public void testTableSort() {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        getDriver().get(getPropertyByKey("base.url"));
        loginPage.login("test", "test");

        HashMap<String, String> beforeSort;
        HashMap<String, String> afterSort;
        ArrayList<Double> beforeAmt;
        ArrayList<Double> afterAmt;

        beforeSort = homePage.getTableElements();
        beforeAmt = homePage.getAmountColumn();
        homePage.clickSort();
        afterSort = homePage.getTableElements();
        afterAmt = homePage.getAmountColumn();

        Collections.sort(beforeAmt);
        Assert.assertEquals(beforeAmt, afterAmt, "Column not sorted correctly");

        Map sortedMap = beforeSort.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        Assert.assertEquals(sortedMap, afterSort, "Data integrity lost- Description value mismatch!");

    }

    @AfterClass
    public void afterClassMethod() {
        tearDown();
    }
}
