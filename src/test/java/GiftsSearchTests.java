import org.testng.annotations.Test;

public class GiftsSearchTests extends BaseUI{

    @Test(dataProvider = "gifts", dataProviderClass = DataProviders.class)
    public void searchGiftsTests(String gift, Boolean requirement){
        main.goToGifts();
            gifts.searchGiftWithDataProvider(gift);
    }
}
