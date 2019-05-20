package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.List;

public class PhotosTests extends BaseUI {



    @Test
    public void swipePictures(ITestContext context){
        main.clickMobileMenu(context);
        main.goToPhotos();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.PICTURE));
        List<WebElement> pictures = driver.findElements(Locators.PICTURE);
        for (int i = 0; i < 7; i++) {
            System.out.println("!!!!! " + i);
            pictures.get(i).click();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            if(i == 2){
                main.ajaxScrollUp("window.scrollBy(0,150)");
                continue;
            }
            driver.findElement(Locators.CLOSE_PICTURE).click();
            pictures = driver.findElements(Locators.PICTURE);
        }
    }





}
