import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LessonFiveTests extends BaseUI {

    @Test
    public void verifyGiftsTest(){

        String actualUrlGifts;
        String giftCardAllText;
        String giftTitle;

        main.goToGifts();
        actualUrlGifts = driver.getCurrentUrl();
        Assert.assertEquals(actualUrlGifts, Data.expectedUrlGifts);

        List<WebElement> giftPictures = driver.findElements(Locators.GIFT_PICTURES);
        for (int i = 0; i < giftPictures.size(); i++) {
            giftCardAllText = giftPictures.get(i).getText();
            System.out.println(giftCardAllText);
            giftTitle = driver.findElements(Locators.GIFT_TITLE).get(i).getText();
            if(giftTitle.contains("Spa")){
                System.out.println("We found Spa gift");
                wait.until(ExpectedConditions.elementToBeClickable(Locators.GIFT_QIUCK_VIEW));
                driver.findElements(Locators.GIFT_QIUCK_VIEW).get(i).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.GIFT_DESCRIPTION_TITLE));
                String giftActualTitle = driver.findElement(Locators.GIFT_DESCRIPTION_TITLE).getText();
                Assert.assertEquals(giftActualTitle, "Spa");
                wait.until(ExpectedConditions.elementToBeClickable(Locators.GIFT_CLOSE_QIUCK_VIEW));
                driver.findElement(Locators.GIFT_CLOSE_QIUCK_VIEW).click();
                continue;
            }
            if(giftTitle.contains("Chocolate and fruits")){
                System.out.println("We found Chocolate and fruits");
                wait.until(ExpectedConditions.elementToBeClickable(Locators.GIFT_QIUCK_VIEW));
                driver.findElements(Locators.GIFT_QIUCK_VIEW).get(i).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.GIFT_DESCRIPTION_TITLE));
                String giftActualTitle = driver.findElement(Locators.GIFT_DESCRIPTION_TITLE).getText();
                Assert.assertEquals(giftActualTitle, "Chocolate and fruits");
                wait.until(ExpectedConditions.elementToBeClickable(Locators.GIFT_CLOSE_QIUCK_VIEW));
                driver.findElement(Locators.GIFT_CLOSE_QIUCK_VIEW).click();
                continue;
            }
            if(giftTitle.contains("Teddy bear")){
                System.out.println("We found Teddy bear");
                wait.until(ExpectedConditions.elementToBeClickable(Locators.GIFT_QIUCK_VIEW));
                driver.findElements(Locators.GIFT_QIUCK_VIEW).get(i).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.GIFT_DESCRIPTION_TITLE));
                String giftActualTitle = driver.findElement(Locators.GIFT_DESCRIPTION_TITLE).getText();
                Assert.assertEquals(giftActualTitle, "Teddy bear");
                wait.until(ExpectedConditions.elementToBeClickable(Locators.GIFT_CLOSE_QIUCK_VIEW));
                driver.findElement(Locators.GIFT_CLOSE_QIUCK_VIEW).click();
                continue;
            }
            if(giftTitle.contains("Flower basket")){
                System.out.println("We found Flower basket");
                wait.until(ExpectedConditions.elementToBeClickable(Locators.GIFT_QIUCK_VIEW));
                driver.findElements(Locators.GIFT_QIUCK_VIEW).get(i).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.GIFT_DESCRIPTION_TITLE));
                String giftActualTitle = driver.findElement(Locators.GIFT_DESCRIPTION_TITLE).getText();
                Assert.assertEquals(giftActualTitle, "Flower basket");
                wait.until(ExpectedConditions.elementToBeClickable(Locators.GIFT_CLOSE_QIUCK_VIEW));
                driver.findElement(Locators.GIFT_CLOSE_QIUCK_VIEW).click();
                continue;
            }
            if(giftTitle.contains("Sushi sets")){
                System.out.println("We found Sushi sets");
                wait.until(ExpectedConditions.elementToBeClickable(Locators.GIFT_QIUCK_VIEW));
                driver.findElements(Locators.GIFT_QIUCK_VIEW).get(i).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.GIFT_DESCRIPTION_TITLE));
                String giftActualTitle = driver.findElement(Locators.GIFT_DESCRIPTION_TITLE).getText();
                Assert.assertEquals(giftActualTitle, "Sushi sets");
                wait.until(ExpectedConditions.elementToBeClickable(Locators.GIFT_CLOSE_QIUCK_VIEW));
                driver.findElement(Locators.GIFT_CLOSE_QIUCK_VIEW).click();
                continue;
            }
            if(giftTitle.contains("TOURS TO UKRAINE")){
                System.out.println("We found TOURS TO UKRAINE");
                wait.until(ExpectedConditions.elementToBeClickable(Locators.GIFT_QIUCK_VIEW));
                driver.findElements(Locators.GIFT_QIUCK_VIEW).get(i).click();
                wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.GIFT_DESCRIPTION_TITLE));
                String giftActualTitle = driver.findElement(Locators.GIFT_DESCRIPTION_TITLE).getText();
                Assert.assertEquals(giftActualTitle, "TOURS TO UKRAINE");
                wait.until(ExpectedConditions.elementToBeClickable(Locators.GIFT_CLOSE_QIUCK_VIEW));
                driver.findElement(Locators.GIFT_CLOSE_QIUCK_VIEW).click();
                continue;
            }
            else {
                Assert.fail("We didn't find any of expected gifts");
            }

        }

    }
}
