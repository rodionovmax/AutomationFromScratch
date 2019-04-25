import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationForm extends BaseActions{

    public RegistrationForm(WebDriver driver, WebDriverWait wait){
        super(driver, wait);
    }

    public void getStarted(){
        driver.findElement(Locators.EMAIL_JOIN).sendKeys(Data.EMAIL);
        driver.findElement(Locators.PASSWORD_JOIN).sendKeys(Data.PASSWORD);
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
        driver.findElement(Locators.PROFILE_NEXT_BUTTON).click();
    }
}
