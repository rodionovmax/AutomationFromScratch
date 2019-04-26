import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search extends BaseUI{

    String currentUrl;

    @Test
    public void testTabSearch(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TAB_SEARCH));
        driver.findElement(Locators.TAB_SEARCH).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, Data.expectedUrlSearch);

        prettyWoman.getDropDownListByValue(Locators.FILTER_MIN_AGE, "20");
        prettyWoman.getDropDownListByValue(Locators.FILTER_MAX_AGE, "27");
        prettyWoman.clickSearchButton();
        prettyWoman.getDropDownListByValue(Locators.DROPDOWN_SORT_BY, "views_count");
//        prettyWoman.getDropDownListByIndex(Locators.DROPDOWN_SORT_BY, 3);
    }




}
