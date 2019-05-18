import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class GiftsTests extends BaseUI {

    String actualUrlGifts;
    String giftTitle;
    String giftActualTitle;
    int articles;
    String articleTitle;
    String pageTitleGifts;
    String resultTitle;
    String productTitleInDescription;


    @DataProvider(name = "Gifts")
    public static Object[][] checkAllCountries(){
        return new Object[][]{

                {"Spa"},
                {"Chocolate and fruits"},
                {"Teddy bear"},
        };
    }

    @Test(dataProvider = "Gifts")
    public void verifyGiftsTest(String gift){
        System.out.println(gift);

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

    @Test(dataProvider = "gifts", dataProviderClass = DataProviders.class)
    public void searchGiftsTests(String gift, Boolean requirement){
        main.goToGifts();
        gifts.searchGiftWithDataProvider(gift, requirement);
    }


    /**  Test to search gifts using Data Provider and CSV file as a source*/
    @Test(dataProvider = "gifts2", dataProviderClass = DataProviders.class)
    public void searchGiftsTests(String gift, String requirement){
        main.goToGifts();
        gifts.searchGiftWithDataProvider(gift, requirement);
    }


    @Test(dataProvider = "gifts3", dataProviderClass = DataProviders.class)
    public void searchGiftsTests(String gift, String requirement, int number){
        main.goToGifts();
        gifts.searchGiftWithDataProvider(gift, requirement);
    }

    /** Test that opens gifts page, searches a product, verifies result, opens product description
     * and verifies title in description */
    @Test
    public void testSearchGiftsAndVerifyOutput(){
        pageTitleGifts = gifts.openGiftsTabAndVerifyTitle();
        Assert.assertEquals(pageTitleGifts, "Gifts", "Actual title doesn't match with Expected title: ");
        resultTitle = gifts.searchGiftAndVerifyResults();
        Assert.assertTrue(resultTitle.contains("Chocolate"));
        productTitleInDescription = gifts.openGiftDetailsAndVerifyPageTitle();
        Assert.assertTrue(productTitleInDescription.contains("Chocolate"));
    }

}
