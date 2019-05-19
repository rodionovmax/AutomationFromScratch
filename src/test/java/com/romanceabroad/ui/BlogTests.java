package com.romanceabroad.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class BlogTests extends BaseUI{

    int articles;
    String articleTitle;

    /** Test that verifies number of articles on com.romanceabroad.ui.BlogPage page on opens first article */
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


    @Test
    public void Test8(){

        WebElement placePhoneNumber = driver.findElement(By.xpath("//i[@class='fa fa-phone fa-2x mb-3 sr-contact']//a[text()='+1(888)599-7816']"));
//        By linkSignIn = By.xpath("//div[@class='col-lg-12 text-center']//a[@href='#']");

        // Ajax click
//        main.ajaxClick(com.romanceabroad.ui.Locators.TAB_OF_MAIN_PAGE, 3);

        // Perform click. Works very well for Internet Explorer
//        main.performClick(com.romanceabroad.ui.Locators.TAB_OF_MAIN_PAGE, 4);

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
