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
    public void openAllLinksInHeaderLessonFour(){
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
    public void Test8(){

        WebElement placePhoneNumber = driver.findElement(By.xpath("//i[@class='fa fa-phone fa-2x mb-3 sr-contact']//a[text()='+1(888)599-7816']"));
//        By linkSignIn = By.xpath("//div[@class='col-lg-12 text-center']//a[@href='#']");

        // Ajax click
//        main.ajaxClick(Locators.TAB_OF_MAIN_PAGE, 3);

        // Perform click. Works very well for Internet Explorer
//        main.performClick(Locators.TAB_OF_MAIN_PAGE, 4);

        // Scroll to the page bottom
//        main.scrollToBottomOfPage();

        // Ajax scroll
//        main.ajaxScroll(placePhoneNumber);
//        String phoneNumber = placePhoneNumber.getText();
//        System.out.println("!!!!" + phoneNumber);
//        Assert.assertEquals(phoneNumber, "+1(888)599-7816");

        main.scrollToBottomOfPage();

        // Scroll up
        main.ajaxScrollUp();
        main.javaWait(5);
    }









}
