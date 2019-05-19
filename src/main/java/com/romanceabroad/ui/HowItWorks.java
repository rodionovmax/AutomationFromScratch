package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HowItWorks extends BaseActions {

    int linksNumber;
    String menuBullet;
    List<WebElement> links;

    public HowItWorks(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    /** Method that verifies and returns number of elements in the side menu */
    public List<WebElement> verifySideMenuElements(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.HOW_IT_WORKS_SIDE_MENU));
        links = driver.findElements(By.xpath("//div[@class='inside account_menu']//a"));
        linksNumber = links.size();
        System.out.println("There are: "+ linksNumber + " links in side menu. \nLet's look all of them.");
        return links;
    }

    /** Method that opens every second element in the side menu */
    public void openEverySecondMenuElement(){
        for(int i = 0; i < linksNumber; i++){
            menuBullet = links.get(i).getText();
            System.out.println("* "+ menuBullet);

            if(i%2==0) {
                links.get(i).click();
                driver.get(Data.HOW_IT_WORKS_URL);
                links = driver.findElements(By.xpath("//div[@class='inside account_menu']//a"));
            } else {
                continue;
            }
        }
    }
}
