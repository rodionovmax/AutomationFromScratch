import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


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

//    @BeforeMethod
//    public void setUp(){
//        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver, 5);
//        main = new Main(driver, wait);
//        registrationForm = new RegistrationForm(driver, wait);
//        prettyWoman = new PrettyWoman(driver, wait);
//        gifts = new Gifts(driver, wait);
//        blog = new Blog(driver, wait);
//        photos = new Photos(driver, wait);
//        howItWorks = new HowItWorks(driver, wait);
//        System.setProperty("webdriver.chrome.driver", "chromedriver");
//        driver.manage().window().maximize();
//        driver.get(Data.MAIN_URL);
//    }

    @BeforeMethod
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser,Method method)

    {
        // Check if parameter passed from TestNG is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {
            // Create firefox instance
            System.setProperty("webdriver.gecko.driver", "geckodriver");
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("chrome")) {
            // Set path to chromedriver
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            // Create chrome instance
            driver = new ChromeDriver();
            driver.get("chrome://settings/clearBrowserData");
        } else if (browser.equalsIgnoreCase("IE")) {
            // Set path to IE driver
            System.setProperty("webdriver.ie.driver", "IEDriverServer");
            // Create IE instance
            driver = new InternetExplorerDriver();
            driver.manage().addCookie(new Cookie("test", "test"));
        } else {
            // If no browser passed throw exception
            // throw new Exception ("Browser is not correct");
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            // Create chrome instance
            driver = new ChromeDriver();
            driver.get("chrome://settings/clearBrowserData");
        }

        wait = new WebDriverWait(driver, 5);
        main = new Main(driver, wait);
        registrationForm = new RegistrationForm(driver, wait);
        prettyWoman = new PrettyWoman(driver, wait);
        gifts = new Gifts(driver, wait);
        blog = new Blog(driver, wait);
        photos = new Photos(driver, wait);
        howItWorks = new HowItWorks(driver, wait);
        driver.manage().window().maximize();
        driver.get(Data.MAIN_URL);
    }


    @AfterMethod
    public void tearDown() {
//        driver.quit();
        System.out.println("Close browser");
    }
}
