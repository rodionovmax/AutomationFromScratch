import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gifts extends BaseActions{

    String pageTitleGifts;
    String resultTitle;
    String productTitleInDescription;

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

}
