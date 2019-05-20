package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class Tours extends BaseUI{

    String currentUrl;


    @Test(groups = {"admin"})
    public void testTabTours(ITestContext context){
        main.clickMobileMenu(context);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TAB_TOURS));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElements(Locators.TAB_TOURS).get(Data.INDEX_TOUR).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, Data.EXPECTED_URL_TOURS);
    }

//    @Test(groups = {"user"})
    public void testTabTours2(ITestContext context){
        main.clickMobileMenu(context);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TAB_TOURS));
        driver.findElements(Locators.TAB_TOURS).get(Data.INDEX_TOUR).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, Data.EXPECTED_URL_TOURS);
    }

}
