import org.testng.annotations.Test;

public class Registration extends BaseUI{


    /** Test for Join web-form */
    @Test
    public void testLoginViaJoinButton(){
        main.clickJoinButton();
        registrationForm.getStarted();
        registrationForm.getStartedSecondPage();
    }


    @Test(dataProvider = "Registration", dataProviderClass = DataProviders.class)
    public void testLoginViaJoinButtonUsingDataProvider(String email, String password, String nickname, String dayOfBirth,
                                       String monthOfBirth, String yearOfBirth, String phoneNumber, String city){
        main.clickJoinButton();
        registrationForm.getStartedWithDataProvider(email, password);
        registrationForm.getStartedSecondPageWithDataProvider(nickname, dayOfBirth, monthOfBirth, yearOfBirth, phoneNumber, city);
    }


    @Test(dataProvider = "Registration2", dataProviderClass = DataProviders.class)
    public void testLoginViaJoinButtonUsingDataProviderWithCsvFile(String email, String password, String nickname, String dayOfBirth,
                                                        String monthOfBirth, String yearOfBirth, String phoneNumber, String city){
        main.clickJoinButton();
        registrationForm.getStartedWithDataProvider(email, password);
        registrationForm.getStartedSecondPageWithDataProvider(nickname, dayOfBirth, monthOfBirth, yearOfBirth, phoneNumber, city);
    }

}
