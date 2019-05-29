package com.romanceabroad.ui;

import com.romanceabroad.ui.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Cookie;


public class BaseUI {

    WebDriver driver;
    WebDriverWait wait;
    MainPage main;
    RegistrationFormPage registrationForm;
    PrettyWomanPage prettyWoman;
    BlogPage blog;
    GiftsPage gifts;
    PhotosPage photos;
    HowItWorks howItWorks;

    protected TestBox testBox;
    protected TestBrowser testBrowser;

    protected enum TestBox {
        WEB, MOBILE
    }

    protected enum TestBrowser {
        CHROME, FIREFOX, IE
    }


    @BeforeMethod(groups = {"admin", "user"})
    @Parameters({"browser", "testBox", "mobileDevice"})
    public void setup(@Optional("chrome") String browser, @Optional("web") String box, @Optional String device, Method method) {
        Reports.start(method.getName());

        if (box.equalsIgnoreCase("web")) {
            testBox = TestBox.WEB;
        } else if (box.equalsIgnoreCase("mobile")) {
            testBox = TestBox.MOBILE;
        }
        if (browser.equalsIgnoreCase("chrome")) {
            testBrowser = TestBrowser.CHROME;
        } else if (browser.equalsIgnoreCase("firefox")) {
            testBrowser = TestBrowser.FIREFOX;
        } else if (browser.equalsIgnoreCase("ie")) {
            testBrowser = TestBrowser.IE;
        }

        switch (testBox) {

            case WEB:

                switch (testBrowser) {
                    case FIREFOX:
                        System.setProperty("webdriver.gecko.driver", "geckodriver");
                        driver = new FirefoxDriver();
                        break;

                    case CHROME:
                        System.setProperty("webdriver.chrome.driver", "chromedriver");
                        driver = new ChromeDriver();
                        driver.get("chrome://settings/clearBrowserData");
                        break;

                    case IE:
                        System.setProperty("webdriver.ie.driver", "IEDriverServer");
                        driver = new InternetExplorerDriver();
                        driver.manage().addCookie(new Cookie("test", "test"));
                        break;

                    default:
                        System.setProperty("webdriver.chrome.driver", "chromedriver");
                        driver = new ChromeDriver();
                        driver.get("chrome://settings/clearBrowserData");
                        break;
                }
                break;

            case MOBILE:
                switch (testBrowser) {
                    case CHROME:
                        Map<String, String> mobileEmulation = new HashMap<String, String>();
                        mobileEmulation.put("deviceName", device);
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                        System.setProperty("webdriver.chrome.driver", "chromedriver");
                        driver = new ChromeDriver(chromeOptions);
                        driver.get("chrome://settings/clearBrowserData");
                        break;
                }

        }


        wait = new WebDriverWait(driver, 5);
        main = new MainPage(driver, wait);
        registrationForm = new RegistrationFormPage(driver, wait);
        prettyWoman = new PrettyWomanPage(driver, wait);
        gifts = new GiftsPage(driver, wait);
        blog = new BlogPage(driver, wait);
        photos = new PhotosPage(driver, wait);
        howItWorks = new HowItWorks(driver, wait);
        driver.manage().window().maximize();
        driver.get(Data.MAIN_URL);
    }


    @AfterMethod(groups = {"admin", "user"})
    public void tearDown(ITestResult testResult) {
        if(testResult.getStatus()==ITestResult.FAILURE){
            Reports.fail(driver, testResult.getName());
        }
        Reports.stop();
//        driver.quit();
        System.out.println("Close browser");
    }
}
