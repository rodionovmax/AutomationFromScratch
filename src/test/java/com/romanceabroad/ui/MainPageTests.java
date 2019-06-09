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

    @Test
    public void checkAllLinks(){
        Reports.log("Start checking all links on main page");
        main.checkLinksOnWebPage("//a", "href");
        Reports.log("I collect tabs in list");
        List<WebElement> links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        for (int i = 0; i < links.size(); i++) {
            Reports.log("I click this tab: " + links.get(i).getText());
            main.ajaxClick(links.get(i));
            Reports.log("I collect all links on this tab");
            main.checkLinksOnWebPage("//a", "href");
            Reports.log("I return to main page");
            driver.get(Data.MAIN_URL);
            Reports.log("I collect new list of tabs");
            links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);

        }
    }

    @Test
    public void checkAllImages (){
        Reports.log("Start checking all images on main page");
        main.checkLinksOnWebPage("//img", "src");
        Reports.log("I collect tabs in list");
        List<WebElement> links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        for (int i = 0; i < links.size(); i++) {
            Reports.log("I click this tab: " + links.get(i).getText());
            main.ajaxClick(links.get(i));
            Reports.log("I collect all images on this tab");
            main.checkLinksOnWebPage("//img", "src");
            Reports.log("I return to main page");
            driver.get(Data.MAIN_URL);
            Reports.log("I collect new list of tabs");
            links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);

        }
    }
}
