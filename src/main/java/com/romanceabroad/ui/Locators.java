package com.romanceabroad.ui;

import org.openqa.selenium.By;

public class Locators {

    public static final By TAB_SEARCH = By.xpath("//a[@href='https://romanceabroad.com/users/search']");
    public static final By IMAGES_SEARCH = By.xpath("//div[@class='g-users-gallery__item col-xs-6 col-sm-3 col-md-3 col-lg-3 ']");
    public static final By TAB_TOURS = By.xpath("//a[@href='https://romanceabroad.com/store/sweets/20-tour_to_ukraine']");
    // locators for testOpenBlogVerifyNumberOfArticlesThenOpenFirstone()
    public static final By TAB_GIFTS = By.xpath("//a[@href='https://romanceabroad.com/store/category-sweets']");
    public static final By BLOG_HEADER = By.xpath("//h1[contains(text(),'com.romanceabroad.ui.BlogPage')]");
    public static final By BLOG_ARTICLES = By.xpath("//div[@class='info-content-block wysiwyg']/ul/li/a");
    public static final By ARTICLE_KHARKOV_AGENCY = By.xpath("//div[@class='info-content-block wysiwyg']/h1");
    // locators for testLoginViaJoinButton()
    public static final By JOIN_BUTTON = By.cssSelector("button#show-registration-block");
    public static final By EMAIL_JOIN = By.cssSelector("#email");
    public static final By PASSWORD_JOIN = By.cssSelector("input#password");
    public static final By NEXT_BUTTON = By.xpath("//button[@type='button'][contains(text(),'Next')]");
    public static final By NICKNAME = By.cssSelector("#nickname");

    public static final By LIST_DAYS = By.cssSelector("#daySelect");
    public static final By DAY_OF_BIRTH = By.xpath("//li[@data-handler='selectDay']//a");

    public static final By LIST_MONTH = By.cssSelector("#monthSelect");
    public static final By MONTH_OF_BIRTH = By.xpath("//ul//li[@data-handler='selectMonth']//a");

    public static final By LIST_YEAR = By.cssSelector("#yearSelect");
    public static final By YEAR_OF_BIRTH = By.xpath("//li[@data-handler='selectYear']//a");

    public static final By PHONE_NUMBER = By.cssSelector("[name='data[phone]']");
    public static final By LOCATION = By.cssSelector("input[name='region_name']");
    public static final By LIST_OF_LOCATIONS = By.xpath("//div[@class='dropdown dropdown_location']");
    public static final By VALUE_OF_LOCATION_LIST = By.xpath("//div[@class='dropdown dropdown_location']//ul//li");
    public static final By CONFIRMATION_CHECKBOX = By.cssSelector("#confirmation");
    public static final By PROFILE_NEXT_BUTTON = By.cssSelector("button[data-action='update-profile']");
    // locators for testSearchGiftsAndVerifyOutput()
    public static final By TAB_BLOG = By.xpath("//a[@href='https://romanceabroad.com/content/view/blog']");
    public static final By GIFTS_TITLE_PAGE = By.cssSelector(".title");
    public static final By GIFTS_SEARCH_FIELD = By.cssSelector("#search_product");
    public static final By GIFTS_SEARCH_BUTTON = By.cssSelector("button#search_friend");
    public static final By GIFTS_SEARCH_RESULT_TITLE = By.cssSelector(".title-block.pt5");
    public static final By GIFTS_QUICK_VIEW_BUTTON = By.xpath("//input[@value='Quick view']");
    public static final By GIFTS_PRODUCT_TITLE = By.cssSelector(".media-heading");

    public static final By DROPDOWN_SORT_BY = By.xpath("//div[@class='form-inline']//select");
    public static final By FILTER_MIN_AGE = By.xpath("//select[@id='age_min']");
    public static final By FILTER_MAX_AGE = By.cssSelector("#age_max");
    public static final By FILTER_SEARCH_BUTTON = By.cssSelector("#main_search_button_user_advanced");
    public static final By PHOTO_TILES = By.cssSelector("#gallery");
    public static final By TAB_PHOTOS = By.xpath("//a[@href='https://romanceabroad.com/media/index']");
    public static final By PICTURE = By.xpath("//div[@class='g-users-gallery__photo']//a");
    public static final By CLOSE_PICTURE = By.xpath("//div[@class='media-gallery-popup__close']//i[@class='fa fa-times']");
    public static final By TAB_HOW_IT_WORKS = By.xpath("//a[@href='https://romanceabroad.com/content/view/how-it-works']");
    public static final By HOW_IT_WORKS_SIDE_MENU = By.cssSelector(".inside.account_menu");
    public static final By TITLE_OF_PAGE = By.xpath("//h1");
    public static final By TAB_OF_MAIN_PAGE = By.xpath("//ul[@class='navbar-nav']//li");
    public static final By IMAGES = By.xpath("//a[@class='g-pic-border g-rounded']");

    public static final By GIFT_PICTURES = By.xpath("//div[@class='contrasting-block']");
    public static final By GIFT_TITLE = By.xpath("//div[@class='title-block pt5']");
    public static final By GIFT_QIUCK_VIEW = By.xpath("//div[@class='quick_view_wrapper']/input[@value='Quick view']");
    public static final By GIFT_CLOSE_QIUCK_VIEW = By.xpath("//div[@class='load_content_close clearfix'][@style='display: block;']/i");
    public static final By GIFT_DESCRIPTION_TITLE = By.xpath("//h4");
    public static final By GIFT_STORE_RESULTS = By.cssSelector(".col-xs-12.b-store-list");
    public static final By MOBILE_MENU = By.xpath("//span[@class='navbar-toggler-icon']");











}
