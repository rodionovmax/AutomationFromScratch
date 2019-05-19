package com.romanceabroad.ui;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class BaseActions {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BaseActions(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    public void getDropDownListByIndex(By locator, int index){
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }

    public void getDropDownListByText(By locator, String text){
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }

    public void getDropDownListByValue(By locator, String value){
//        wait.until(ExpectedConditions.elementToBeSelected(com.romanceabroad.ui.Locators.DROPDOWN_SORT_BY));
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }

    // Different varieties of Ajax click
    public void ajaxClick(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void ajaxClick(By by){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElement(by));
    }

    public void ajaxClick(By by, int index){
        wait.until(ExpectedConditions.elementToBeClickable(by));
        ajaxClick(driver.findElements(by).get(index));
    }

    public void performClick(By locator){
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    public void performClick(By locator, int index){
        WebElement element = driver.findElements(locator).get(index);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    public void performClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        actions.click().build().perform();
    }

    public void clickUnselectedCheckbox(By checkbox){
        WebElement currentCheckbox = driver.findElement(checkbox);
        if (!currentCheckbox.isSelected()){
            ajaxClick(currentCheckbox);
        }
    }

    public void clickUnselectedCheckbox(WebElement currentCheckbox){
        if (!currentCheckbox.isSelected()){
            ajaxClick(currentCheckbox);
        }
    }

    public void clickUnselectedCheckbox(By checkbox, int index){
        WebElement currentCheckbox = driver.findElements(checkbox).get(index);
        if (!currentCheckbox.isSelected()){
            ajaxClick(currentCheckbox);
        }
    }

    // Scrolls
    public void scrollToBottomOfPage(){
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void ajaxScroll(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void ajaxScrollUp(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-250)", "");
    }

    public void javaWait(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public void javaWaitSec(int sec){
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    // Method for link verification
    public void verifyLinkActive(String linkUrl){
        try {
            URL url = new URL(linkUrl);
            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
            httpURLConnect.setConnectTimeout(3000);
            httpURLConnect.connect();
            if (httpURLConnect.getResponseCode() == 200){
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }
            if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND){
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

//    public void checkImages(List<WebElement> imagetags) throws IOException {
//        javaWaitSec(5);
//        for (WebElement imtag : imagetags){
//            if(!imtag.getAttribute("src").trim() == null) && !(imtag.getAttribute("src").equals());
//            //get Status code
//            int statusCode = getResponseCode(imtag.getAttribute("src").trim());
//            //invalid or broken image
//            if(statusCode == 404){
//                System.out.println("Invalid or broken image url # " + imtag.getAttribute("src").trim());
//            } else {
//                System.out.println(imtag.getAttribute("src") + "OK");
//            }
//        }
//    }

    public static int getResponseCode(String urlString) throws MalformedURLException, IOException {
        URL u = new URL(urlString);
        HttpURLConnection huc = (HttpURLConnection) u.openConnection();
        huc.setRequestMethod("GET");
        huc.connect();
        return huc.getResponseCode();
    }

//    public static String generateEmail(String domain, int length){
//        return RandomStringUtils.random(length, "abcdefghojklmnopqrstuvwxyz") + "@" + domain;
//    }


//    public void switchBrowserFirstAction(){
//        javaWaitSec(5);
//        ArrayList<String> tabs = new ArrayList<~>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        driver.manage().window().maximize();
//        javaWaitSec(7);
//        String currentURL = driver.getCurrentUrl();
//        System.out.println(currentURL);
//        logJavaScriptConsoleError();
//    }

    public void uploadFileRobot(){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e){
            e.printStackTrace();
        }

        StringSelection sel = new StringSelection("C:\\Users....");
        javaWaitSec(5);

        //Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        //Release CTRL+V
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        //Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(1000);
    }

    public static String generateNewNumber(String name, int length){
        return name + RandomStringUtils.random(length, "172984757");
    }

    public static String generateRandomString(){
        return new BigInteger(120, new SecureRandom()).toString(32);
    }

    //Method for random choice from dropdown list
    public void selectItemDropDownRandomOption(By locator, String dropDownName){
        try {
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            Select select = new Select(driver.findElement(locator));
            select.selectByIndex((int) (Math.random() * (select.getOptions().size() - 1)) + 1);
            System.out.println(dropDownName + ": " + select.getFirstSelectedOption().getText());
        } catch (NoSuchElementException e){

        }
    }



}



