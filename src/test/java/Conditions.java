import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Conditions extends BaseUI{


    // Condition for Int
    int dice;

    @Test
    public void conditionForInt() {
        Random rand = new Random();
        int dice = rand.nextInt(3);

        if (dice == 0) {
            System.out.println("You won a Ferrari!");
        } else if (dice == 1) {
            System.out.println("You won a penthouse in New York!");
        } else if (dice == 2) {
            System.out.println("You won a million dollars!");
        } else if (dice == 3) {
            System.out.println("Sorry, you are loser");
        }
    }

    // Condition for String
    @Test
    public void conditionForString() {

        ConditionsHelper conditionsHelper = new ConditionsHelper();

        if (conditionsHelper.inputString == "money") {
            System.out.println("You won $1000. Congratulations!");
        } else if (conditionsHelper.inputString == "prise") {
            System.out.println("You won a Ferrari!!!");
        } else {
            System.out.println("You made a typo, so you didn't win anything...");
        }

    }

    //Condition for boolean
    @Test
    public void conditionForBoolean() {
        boolean requirement = true;

        if (requirement) {
            System.out.println("Boolean is true!");
        } else {
            Assert.fail("Boolean is false");
        }
    }


    @Test
    public void test7() {
        List<String> crunchifyList1 = new ArrayList<>(Arrays.asList("kiwi", "orange", "melon"));
        // Method 1
//        String element = crunchifyList1.get(0);
//        System.out.println(element);

        // Method 2
        if (crunchifyList1.contains("orange")) {
            System.out.println(crunchifyList1);
        }
    }

    @Test
    public void test8() {
        List<Integer> crunchifyList1 = new ArrayList<>(Arrays.asList(5, 10, 19));
        int sum = crunchifyList1.get(1) + crunchifyList1.get(2);
        System.out.println(sum);
    }

    @Test
    public void test9() {
        List<Integer> crunchifyList1 = new ArrayList<>(Arrays.asList(5, 10, 19));
        System.out.println(crunchifyList1.size());
        crunchifyList1.add(10);
        System.out.println(crunchifyList1.size());
        for (int i = 0; i < crunchifyList1.size(); i++) {
            int element = crunchifyList1.get(i);
            System.out.println(element);
        }
    }

    @Test
    public void test10() {

        String phrase = "Melon inside list";
        List<String> crunchifyList1 = new ArrayList<>(Arrays.asList("apple", "kiwi", phrase));

        crunchifyList1.add("Melon");
        System.out.println(crunchifyList1);
        System.out.println(crunchifyList1.size());

        for (int i = 0; i < crunchifyList1.size(); i++) {
            String element = crunchifyList1.get(i);
            System.out.println(i + " iteration");

            if (element.contains("Me")) {
                System.out.println(phrase);
                continue;
            }
            if (element.equals("orange")){
                System.out.println("Orange");
            }
            if (element.contains("i")){
                System.out.println("IIIIIII");
            } else {
                System.out.println("Bad loop");
            }
        }
    }


    @Test
    public void openAllLinksInHeader(){

        String actualTitle;
        String actualUrlPrettyWoman;

        List<WebElement> links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        System.out.println(links.size());
        for (int i = 0; i < links.size(); i++) {
            String info = links.get(i).getText();
            System.out.println(info);
            links.get(i).click();
            if (info.contains("WORK")){
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                Assert.assertEquals(Data.expectedTitleWork, actualTitle);
            }

            if (info.contains("PRETTY WOMAN")){
                actualTitle = driver.findElement(Locators.TITLE_OF_PAGE).getText();
                actualUrlPrettyWoman = driver.getCurrentUrl();
                Assert.assertEquals(Data.expectedTitlePrettyWoman, actualTitle);
                Assert.assertEquals(actualUrlPrettyWoman, Data.expectedlUrlPrettyWoman);
                driver.findElement(Locators.IMAGES).isDisplayed();
            }

            driver.get(Data.MAIN_URL);
            links = driver.findElements(Locators.TAB_OF_MAIN_PAGE);
        }
    }


}