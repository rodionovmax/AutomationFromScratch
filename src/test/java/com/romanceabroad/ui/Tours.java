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
//        main.clickMobileMenu(context);
        // Comment row under if uses BaseUITestWithSauceLabs class
        main.clickMobileMenu(getValue());

        Reports.log("Wait Tab Tours!");
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TAB_TOURS));

        Reports.log("Click tab Tours");
        driver.findElements(Locators.TAB_TOURS).get(Data.INDEX_TOUR).click();

        Reports.log("Take current URL");
        currentUrl = driver.getCurrentUrl();

        Reports.log("Current URL: " + currentUrl);

        Reports.log("Do comparison between current URL and Expected URL: " + Data.EXPECTED_URL_TOURS);
        Assert.assertEquals(currentUrl, Data.EXPECTED_URL_TOURS);
    }

//    @Test(groups = {"user"})
    public void testTabTours2(ITestContext context){
//        main.clickMobileMenu(context);
        // Comment row under if uses BaseUITestWithSauceLabs class
        main.clickMobileMenu(getValue());
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TAB_TOURS));
        driver.findElements(Locators.TAB_TOURS).get(Data.INDEX_TOUR).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, Data.EXPECTED_URL_TOURS);
    }

}
