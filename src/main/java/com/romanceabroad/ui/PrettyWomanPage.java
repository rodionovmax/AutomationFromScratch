package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrettyWomanPage extends BaseActions{

    public PrettyWomanPage(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }


    public void clickSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.FILTER_SEARCH_BUTTON));
        driver.findElement(Locators.FILTER_SEARCH_BUTTON).click();
    }
}
