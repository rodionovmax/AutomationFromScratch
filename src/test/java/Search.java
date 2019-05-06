import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Search extends BaseUI{

    String currentUrl;
    public static final boolean testCase1234 = true;
    public static final boolean testCase56789 = false;

    int minAge;
    int maxAge;



    @Test(dataProvider = "ValueOfDropDownList", dataProviderClass = DataProviders.class)
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


    @Test
    public void testTabSearchWithRandomChoice() throws Exception {

        wait.until(ExpectedConditions.elementToBeClickable(Locators.TAB_SEARCH));
        driver.findElement(Locators.TAB_SEARCH).click();
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, Data.expectedUrlSearch);
        for (int i = 0; i < 15; i++) {
            prettyWoman.selectItemDropDownRandomOption(Locators.FILTER_MIN_AGE, "Minimum age");
            prettyWoman.selectItemDropDownRandomOption(Locators.FILTER_MAX_AGE, "Maximum age");

            Boolean filterIsPresent = driver.findElements(Locators.DROPDOWN_SORT_BY).size() > 0;

            if (filterIsPresent){
                prettyWoman.selectItemDropDownRandomOption(Locators.DROPDOWN_SORT_BY, "Filter");
                prettyWoman.clickSearchButton();
            } else {
                prettyWoman.clickSearchButton();
            }
            Thread.sleep(3000);
        }

    }




}
