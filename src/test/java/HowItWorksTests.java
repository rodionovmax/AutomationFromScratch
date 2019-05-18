import org.testng.Assert;
import org.testng.annotations.Test;

public class HowItWorksTests extends BaseUI {

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
