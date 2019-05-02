import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LessonFiveTests extends BaseUI {

    String actualUrlGifts;
    String giftTitle;
    String giftActualTitle;

    @Test
    public void verifyGiftsTest(){

        main.goToGifts();
        actualUrlGifts = driver.getCurrentUrl();
        Assert.assertEquals(actualUrlGifts, Data.expectedUrlGifts);

        List<WebElement> giftPictures = driver.findElements(Locators.GIFT_PICTURES);
        for (int i = 0; i < giftPictures.size(); i++) {

            giftTitle = gifts.getFirstTitle(i);
            gifts.clickQuickViewButton(i);
            giftActualTitle = gifts.getGiftDescriptionTitle();
            gifts.clickCloseGiftButton();

            if(giftTitle.contains(Data.expectedTitleSpa)){
                System.out.println("We found Spa gift");
                Assert.assertEquals(giftActualTitle, Data.expectedTitleSpa);
                continue;
            }
            if(giftTitle.contains(Data.expectedTitleChocolateAndFruits)){
                System.out.println("We found Chocolate and fruits");
                Assert.assertEquals(giftActualTitle, Data.expectedTitleChocolateAndFruits);
                continue;
            }
            if(giftTitle.contains(Data.expectedTitleTeddyBear)){
                System.out.println("We found Teddy bear");
                Assert.assertEquals(giftActualTitle, Data.expectedTitleTeddyBear);
                continue;
            }
            if(giftTitle.contains(Data.expectedTitleFlowerBasket)){
                System.out.println("We found Flower basket");
                Assert.assertEquals(giftActualTitle, Data.expectedTitleFlowerBasket);
                continue;
            }
            if(giftTitle.contains(Data.expectedTitleSushiSets)){
                System.out.println("We found Sushi sets");
                Assert.assertEquals(giftActualTitle, Data.expectedTitleSushiSets);
                continue;
            }
            if(giftTitle.contains(Data.expectedTitleUkraineTours)){
                System.out.println("We found TOURS TO UKRAINE");
                Assert.assertEquals(giftActualTitle, Data.expectedTitleUkraineTours);
            }
            else {
                Assert.fail("We didn't find any of expected gifts");
            }

        }

    }
}
