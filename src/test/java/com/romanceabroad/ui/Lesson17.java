package com.romanceabroad.ui;


import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners(VideoListener.class)


public class Lesson17 extends BaseUI{


    @Test
    public void test2(){
        main.javaWaitSec(2);
        WebElement element = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/RRECuJzm3IY?start=85']"));
        driver.switchTo().frame(element);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
    }

    @Test
    @Video(name = "test_three")
    public void test3(){
        main.clickTabSearch();
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();

    }

    @Test
    public void nestedLoops(){
        for (int i = 0; i < 10; i++) {
            main.clickTabSearch();

            List<WebElement> profiles = driver.findElements(By.xpath("//div[@class='g-users-gallery__photo']//a"));
            for (int j = 0; j < 3; j++) {
                profiles.get(j).click();
                driver.navigate().back();
                profiles = driver.findElements(By.xpath("//div[@class='g-users-gallery__photo']//a"));
            }
            driver.get(Data.MAIN_URL);
        }
    }

}
