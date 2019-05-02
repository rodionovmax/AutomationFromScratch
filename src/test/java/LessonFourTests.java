import org.openqa.selenium.WebElement;
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

    /**
     * This test fails due to some driver error below
     * Starting ChromeDriver 73.0.3683.68 (47787ec04b6e38e22703e856e101e840b65afe72) on port 25604
     * Only local connections are allowed.
     * Please protect ports used by ChromeDriver and related test frameworks to prevent access by malicious code.
     * Apr 23, 2019 10:07:45 AM org.openqa.selenium.remote.ProtocolHandshake createSession
     * INFO: Detected dialect: OSS
     *
     * java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
     */
    @Test
    public void swipePictures() throws InterruptedException {
        main.goToPhotos();
        Thread.sleep(3000);
        List<WebElement> pictures = driver.findElements(Locators.PICTURE);
        for (int i = 0; i < 4; i++) {
            Thread.sleep(3000);
            pictures.get(i).click();
            main.ajaxClick(Locators.CLOSE_PICTURE, i);
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
