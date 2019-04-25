import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseUI {

    WebDriver driver;
    WebDriverWait wait;
    Main main;
    RegistrationForm registrationForm;
    PrettyWoman prettyWoman;
    Blog blog;
    Gifts gifts;
    Photos photos;
    HowItWorks howItWorks;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 5);
        main = new Main(driver, wait);
        registrationForm = new RegistrationForm(driver, wait);
        prettyWoman = new PrettyWoman(driver, wait);
        gifts = new Gifts(driver, wait);
        blog = new Blog(driver, wait);
        photos = new Photos(driver, wait);
        howItWorks = new HowItWorks(driver, wait);
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver.manage().window().maximize();
        driver.get(Data.MAIN_URL);
    }

    @AfterMethod
    public void tearDown(){
//        driver.quit();
        System.out.println("Close browser");
    }
}
