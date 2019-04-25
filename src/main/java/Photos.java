import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Photos extends BaseActions {

    public Photos(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }


    public void selectPicture(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.PHOTO_TILES));
        driver.findElements(Locators.PICTURE).get(1).click();
    }


}
