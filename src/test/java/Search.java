import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Search extends BaseUI{

    String currentUrl;
    public static final boolean testCase1234 = true;
    public static final boolean testCase56789 = false;

    @Test(priority = 1, enabled = testCase1234, groups = {"admin"})
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

    @Test(priority = 2, enabled = testCase56789, groups = {"user"})
    public void testTabTours(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TAB_TOURS));
        driver.findElements(Locators.TAB_TOURS).get(Data.INDEX_TOUR).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, Data.EXPECTED_URL_TOURS);
    }




}
