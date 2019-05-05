import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Registration extends BaseUI{
    @DataProvider(name = "Registration")
    public static Object[][] checkRegistration() {
        return new Object[][]{
                {"streetracer@gmail.com", "Password", "Matt_Damon", "20", "May", "2000", "123456789", "New York"},
//                {"harrypotter@hotmail.com", "Pass!222", "Harry", "25", "Nov", "1990", "345687923412", "Chicago"},
//                {"fbi.agent@fbi.kz", "P@@$$w00r%", "James", "31", "Dec", "1955", "1323434534", "Norilsk"},
        };
    }


    @Test(dataProvider = "Registration")
    public void testLoginViaJoinButtonUsingDataProvider(String email, String password, String nickname, String dayOfBirth,
                                       String monthOfBirth, String yearOfBirth, String phoneNumber, String city){
        main.clickJoinButton();
        registrationForm.getStartedWithDataProvider(email, password);
        registrationForm.getStartedSecondPageWithDataProvider(nickname, dayOfBirth, monthOfBirth, yearOfBirth, phoneNumber, city);
    }
}
