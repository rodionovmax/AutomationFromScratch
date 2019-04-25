import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main extends BaseActions{


    public Main(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void clickJoinButton(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.JOIN_BUTTON));
        driver.findElement(Locators.JOIN_BUTTON).click();
    }

    public void goToBlog(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TAB_BLOG));
        driver.findElement(Locators.TAB_BLOG).click();
    }

    public void goToPhotos(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TAB_PHOTOS));
        driver.findElement(Locators.TAB_PHOTOS).click();
    }

    public void goToHowItWorks(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TAB_HOW_IT_WORKS));
        driver.findElement(Locators.TAB_HOW_IT_WORKS).click();
    }



}
