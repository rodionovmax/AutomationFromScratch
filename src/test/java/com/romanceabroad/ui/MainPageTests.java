package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MainPageTests extends BaseUI{


    @Test
    public void test6(){
        main.clickJoinButton();
        registrationForm.getStarted();

        WebElement checkbox = driver.findElement(Locators.CONFIRMATION_CHECKBOX);

        if(!checkbox.isSelected()){
            checkbox.click();
            System.out.println("Checkbox is selected!");
        }
    }


    @Test
    public void openAllLinksInHeader(){

        String actualTitle;
        String actualUrlPrettyWoman;
        String info;

        List<WebElement> links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        System.out.println(links.size());
        for (int i = 0; i < links.size(); i++) {
            info = links.get(i).getText();
            System.out.println(info);
//            links.get(i).click();

            // Here we replaced regular click on Ajax click
            main.ajaxClick(links.get(i));

            if (info.contains("WORK")){
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                Assert.assertEquals(Data.expectedTitleWork, actualTitle);
            }

            if (info.contains("PRETTY WOMAN")){
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlPrettyWoman = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedTitlePrettyWoman, actualTitle);
                Assert.assertEquals(actualUrlPrettyWoman, Data.expectedUrlSearch);
                driver.findElement(Locators.IMAGES).isDisplayed();
                if(actualUrlPrettyWoman.contains("#")){
                    Assert.fail("It contains restricted # ");
                } else {
                    System.out.println("No special characters. This URL is dope");
                }
            }

            driver.get(Data.MAIN_URL);
            links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        }
    }
}
