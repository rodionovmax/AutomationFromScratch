import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MyTests extends BaseUI{

    String blogHeader;
    int articles;
    String articleTitle;
    String pageTitleGifts;
    String resultTitle;
    String productTitleInDescription;

    /** Test that verifies number of articles on Blog page on opens first article */
    @Test
    public void testOpenBlogVerifyNumberOfArticlesThenOpenFirstone(){
        main.goToBlog();
        articles = blog.verifyNumberOfArticles();
        // Verify number of articles
        Assert.assertEquals(articles, 15, "Actual number of articles not equal to expected: ");
        articleTitle = blog.findArticleInTheListThenClickAndVerifyTitle();
        // Verify title of opened article
        Assert.assertEquals(articleTitle, Data.BLOG_EXPECTED_ARTICLE);
    }

    /** Test for Join web-form */
    @Test
    public void testLoginViaJoinButton(){
        main.clickJoinButton();
        registrationForm.getStarted();
        registrationForm.getStartedSecondPage();
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


    @Test
    public void test5(){
        WebElement tabSearch = driver.findElement(Locators.TAB_SEARCH);

        if(tabSearch.isDisplayed()){
            tabSearch.click();
        } else {
            Assert.fail("We can't find Pretty Woman tab");
        }
    }

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
        List<WebElement> links = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
        System.out.println(links.size());
        for (int i = 0; i < links.size(); i++) {
            String info = links.get(i).getText();
            System.out.println(info);
            links.get(i).click();
            driver.get(Data.MAIN_URL);
            links = driver.findElements(By.xpath("//ul[@class='navbar-nav']//li"));
        }
    }







}
