package com.romanceabroad.ui;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AdditionalTests extends BaseUI{


    @Test
    public  void noTestNg(){
        String[] array1 = null;
        String nameOfGift;
        String requirement;


        try {
            array1 = Files.readAllLines(Paths.get("SearchGifts.csv")).stream().toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }

        main.goToGifts();

        for (int i = 0; i < array1.length; i++) {
            String[] data = array1[i].split(",");
            nameOfGift = data[0];
            requirement = data[1];
            gifts.searchGiftWithDataProvider(nameOfGift, requirement);
        }
    }

    @Test
    public void use2Lists(){
        main.goToGifts();
        List<WebElement> elements  = gifts.takeGiftsSearchField();
        //  elements.add(driver.findElement();
        List<String>values= new ArrayList<String>(Arrays.asList("0", "3", "2", "1", "7", "2"));

        for (int i = 0; i <6 ; i++) {
            elements.get(0).clear();
            elements.get(0).sendKeys(values.get(i));
            gifts.clickSearchGiftsButton();
            elements = gifts.takeGiftsSearchField();
        }
    }

    @Test
    public void useHash(){
        main.goToGifts();
        List<WebElement> elements = gifts.takeGiftsSearchField();

        HashMap<Integer, String> values = new HashMap<>();
        values.put(0, "2");
        values.put(1, "8");
        values.put(2, "8");
        values.put(3, "0");
        values.put(4, "3");
        values.put(5, "3");

        for (int i = 0; i <6 ; i++) {
            elements.get(0).clear();
            elements.get(0).sendKeys(values.get(i));
            gifts.clickSearchGiftsButton();
            elements = gifts.takeGiftsSearchField();
        }
    }


}
