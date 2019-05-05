import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class LessonFourTests extends BaseUI {

    // if/else for WebElement
    @Test
    public void conditionForWebElement() {
        WebElement tabSearch = driver.findElement(Locators.TAB_SEARCH);

        if (tabSearch.getText().contains("PRETTY WOMEN")) {
            tabSearch.click();
        } else {
            Assert.fail("We can't find Pretty Woman tab");
        }
    }


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

    @Test
    public void verifyHowItWorksSideMenu(){
        main.goToHowItWorks();
        howItWorks.verifySideMenuElements();
        howItWorks.openEverySecondMenuElement();

        if(howItWorks.linksNumber <= 22){
            System.out.println("Test is correct");
        } else {
            Assert.fail("Actual number of links doesn't match with expected result");
        }

    }



}
