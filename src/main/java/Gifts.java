import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gifts extends BaseActions{

    String pageTitleGifts;
    String resultTitle;
    String productTitleInDescription;
    String giftActualTitle;

    public Gifts(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }


    public String openGiftsTabAndVerifyTitle(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TAB_GIFTS));
        driver.findElement(Locators.TAB_GIFTS).click();
        // Verify title of the page
        pageTitleGifts = driver.findElement(Locators.GIFTS_TITLE_PAGE).getText();
        return pageTitleGifts;
    }

    public String searchGiftAndVerifyResults(){
        driver.findElement(Locators.GIFTS_SEARCH).sendKeys("chocolate");
        driver.findElement(Locators.GIFTS_SEARCH_BUTTON).click();
        resultTitle = driver.findElement(Locators.GIFTS_SEARCH_RESULT_TITLE).getText();
        return resultTitle;
    }

    public String openGiftDetailsAndVerifyPageTitle(){
        driver.findElement(Locators.GIFTS_QUICK_VIEW_BUTTON).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.GIFTS_PRODUCT_TITLE));
        productTitleInDescription = driver.findElement(Locators.GIFTS_PRODUCT_TITLE).getText();
        return productTitleInDescription;
    }

    public String getGiftDescriptionTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.GIFT_DESCRIPTION_TITLE));
        giftActualTitle = driver.findElement(Locators.GIFT_DESCRIPTION_TITLE).getText();
        return giftActualTitle;
    }

    public String getFirstTitle(int index){
        String title = driver.findElements(Locators.GIFT_TITLE).get(index).getText();
        return title;
    }

    public void clickQuickViewButton(int index){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.GIFT_QIUCK_VIEW));
        driver.findElements(Locators.GIFT_QIUCK_VIEW).get(index).click();
    }

    public void clickCloseGiftButton(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.GIFT_CLOSE_QIUCK_VIEW));
        driver.findElement(Locators.GIFT_CLOSE_QIUCK_VIEW).click();
    }

}
