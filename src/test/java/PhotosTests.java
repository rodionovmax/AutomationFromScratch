import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class PhotosTests extends BaseUI {



    @Test
    public void swipePictures(){
        main.goToPhotos();
        wait.until(ExpectedConditions.elementToBeClickable(Locators.PICTURE));
        List<WebElement> pictures = driver.findElements(Locators.PICTURE);
        for (int i = 0; i < 5; i++) {
            System.out.println("!!!!! " + i);
            pictures.get(i).click();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            driver.findElement(Locators.CLOSE_PICTURE).click();
            pictures = driver.findElements(Locators.PICTURE);
        }
    }





}
