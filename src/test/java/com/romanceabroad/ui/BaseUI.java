package com.romanceabroad.ui;

import com.romanceabroad.ui.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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



    @BeforeMethod(groups = {"admin", "user"})
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser,Method method)

    {
        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "geckodriver");
            driver = new FirefoxDriver();

        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
            driver.get("chrome://settings/clearBrowserData");
        } else if (browser.equalsIgnoreCase("IE")) {
            System.setProperty("webdriver.ie.driver", "IEDriverServer");
            driver = new InternetExplorerDriver();
            driver.manage().addCookie(new Cookie("test", "test"));
        }

        else if (browser.equalsIgnoreCase("mobileChrome")) {
            Map<String, String> mobileEmulation = new HashMap<String, String>();
            mobileEmulation.put("deviceName", "iPhone X");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver(chromeOptions);
            driver.get("chrome://settings/clearBrowserData");
        }

        else {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
            driver.get("chrome://settings/clearBrowserData");
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
    public void tearDown() {
//        driver.quit();
        System.out.println("Close browser");
    }
}
