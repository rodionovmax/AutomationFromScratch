import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Search extends BaseUI{

    String currentUrl;
    public static final boolean testCase1234 = true;
    public static final boolean testCase56789 = false;

    @DataProvider(name = "ValueOfDropDownList")
    public static Object[][] checkAllCountries(){
        return new Object[][]{

                {"20", "44", "views_count ", true},
                {"33", "50", "date_created", false},
                {"44", "55", "name", false},
        };
    }

    @Test(dataProvider = "ValueOfDropDownList")
    public void testTabSearch(String minAge,  String maxAge, String filterOfSearch, boolean requirement){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TAB_SEARCH));
        driver.findElement(Locators.TAB_SEARCH).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, Data.expectedUrlSearch);

        if (requirement) {
            prettyWoman.getDropDownListByValue(Locators.FILTER_MIN_AGE, minAge);
        }
        else {
            prettyWoman.getDropDownListByValue(Locators.FILTER_MAX_AGE, maxAge);
            prettyWoman.getDropDownListByValue(Locators.DROPDOWN_SORT_BY, filterOfSearch);
        }
        prettyWoman.clickSearchButton();
    }


    @Test(priority = 2, enabled = testCase56789, groups = {"user"})
    public void testTabTours(){
        wait.until(ExpectedConditions.elementToBeClickable(Locators.TAB_TOURS));
        driver.findElements(Locators.TAB_TOURS).get(Data.INDEX_TOUR).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, Data.EXPECTED_URL_TOURS);
    }




}
