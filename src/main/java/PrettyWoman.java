import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrettyWoman extends BaseActions{

    public PrettyWoman(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }


    public void clickSearchButton(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.FILTER_SEARCH_BUTTON));
        driver.findElement(Locators.FILTER_SEARCH_BUTTON).click();
    }
}
