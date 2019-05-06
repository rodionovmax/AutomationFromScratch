import org.testng.annotations.Test;

public class GiftsSearchTests extends BaseUI{

    @Test(dataProvider = "gifts", dataProviderClass = DataProviders.class)
    public void searchGiftsTests(String gift, Boolean requirement){
        main.goToGifts();
        gifts.searchGiftWithDataProvider(gift, requirement);
    }


    /**  Test to search gifts using Data Provider and CSV file as a source*/
    @Test(dataProvider = "gifts2", dataProviderClass = DataProviders.class)
    public void searchGiftsTestsWithCsvFile(String gift){
        main.goToGifts();
        gifts.searchGiftWithDataProviderAndCsvFile(gift);
    }

}
