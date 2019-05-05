import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RegistrationForm extends BaseActions{

    public RegistrationForm(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void getStarted(){
        driver.findElement(Locators.EMAIL_JOIN).sendKeys(Data.email1);
        driver.findElement(Locators.PASSWORD_JOIN).sendKeys(Data.password);
        driver.findElement(Locators.NEXT_BUTTON).click();
    }

    public void getStartedSecondPage(){
        driver.findElement(Locators.NICKNAME).sendKeys(Data.REGISTRATION_NICKNAME);

        driver.findElement(Locators.LIST_DAYS).click();
        driver.findElements(Locators.DAY_OF_BIRTH).get(Data.LIST_DAY_INDEX).click();
        driver.findElement(Locators.LIST_MONTH).click();
        driver.findElement(Locators.MONTH_OF_BIRTH).click();
        driver.findElement(Locators.LIST_YEAR).click();
        driver.findElement(Locators.YEAR_OF_BIRTH).click();

        driver.findElement(Locators.PHONE_NUMBER).sendKeys(Data.REGISTRATION_PHONE_NUMBER);
        driver.findElement(Locators.LOCATION).sendKeys(Data.REGISTRATION_LOCATION_CITY);
//        wait.until(ExpectedConditions.elementToBeClickable(Locators.LOCATION_FROM_DROPDOWN));
//        driver.findElement(Locators.LOCATION_FROM_DROPDOWN).click();
        driver.findElement(Locators.CONFIRMATION_CHECKBOX).click();
//        driver.findElement(Locators.PROFILE_NEXT_BUTTON).click(); It's not working
    }


    // Option 2 for using with DataProvider
    public void getStartedWithDataProvider(String email, String password){
        driver.findElement(Locators.EMAIL_JOIN).sendKeys(email);
        driver.findElement(Locators.PASSWORD_JOIN).sendKeys(password);
        driver.findElement(Locators.NEXT_BUTTON).click();
    }

    public void getStartedSecondPageWithDataProvider(String nickname, String dayOfBirth, String monthOfBirth, String yearOfBirth,
                                                     String phoneNumber, String city){
        driver.findElement(Locators.NICKNAME).sendKeys(generateNewNumber(nickname, 7));
        clickDayOfBirth(dayOfBirth);
        clickMonthOfBirth(monthOfBirth);
        clickYearOfBirth(yearOfBirth);
        driver.findElement(Locators.PHONE_NUMBER).sendKeys(phoneNumber);
        driver.findElement(Locators.CONFIRMATION_CHECKBOX).click();
        selectSpecificLocation(city);
    }

    public void clickDayOfBirth(String day){
        driver.findElement(Locators.LIST_DAYS).click();
        List<WebElement> days = driver.findElements(Locators.MONTH_OF_BIRTH);
        for (int i = 0; i < days.size() ; i++) {
            WebElement dayValue = days.get(i);
            if(dayValue.getText().contains(day)){
                dayValue.click();
            }
        }
    }

    public void clickMonthOfBirth(String month){
        driver.findElement(Locators.LIST_MONTH).click();
        List<WebElement> months = driver.findElements(Locators.MONTH_OF_BIRTH);
        for (int i = 0; i < months.size() ; i++) {
            WebElement monthValue = months.get(i);
            if(monthValue.getText().contains(month)){
                monthValue.click();
            }
        }
    }

    public void clickYearOfBirth(String year){
        driver.findElement(Locators.LIST_YEAR).click();
        List<WebElement> years = driver.findElements(Locators.YEAR_OF_BIRTH);
        for (int i = 0; i < years.size() ; i++) {
            WebElement yearValue = years.get(i);
            if(yearValue.getText().contains(year)){
                yearValue.click();
            }
        }
    }

    public void selectSpecificLocation(String city){
        driver.findElement(Locators.LOCATION).clear();
        driver.findElement(Locators.LOCATION).sendKeys(city);
        wait.until(ExpectedConditions.elementToBeClickable(Locators.LIST_OF_LOCATIONS));
        List<WebElement> locations = driver.findElements(Locators.VALUE_OF_LOCATION_LIST);
        for (int i = 0; i < locations.size(); i++) {
             WebElement location = locations.get(i);
             if(location.getText().contains(city)){
                 location.click();
             }
        }
    }
}
