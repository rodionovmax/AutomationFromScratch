package com.romanceabroad.ui;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class BaseUITestWithSauceLabs {

    private String value;
    public BaseUITestWithSauceLabs(){value = null;}

    WebDriver driver;
    WebDriverWait wait;
    MainPage main;
    RegistrationFormPage registrationForm;
    PrettyWomanPage prettyWoman;
    BlogPage blog;
    GiftsPage gifts;
    PhotosPage photos;
    HowItWorks howItWorks;


    @BeforeMethod
    public void setup(Method method) throws MalformedURLException {
        Reports.start(method.getName());

//        DesiredCapabilities capabilities = new DesiredCapabilities();
        DesiredCapabilities capabilities = DesiredCapabilities.safari();

//        DesiredCapabilities capabilities = DesiredCapabilities.edge();
        capabilities.setCapability("username", "nevermind1985");
        capabilities.setCapability("accessKey", "d872082c-ab3a-4eec-a579-c2207148359a");

        /*capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("version", "59.0");*/

        capabilities.setCapability("platform", "macOS 10.14");
        capabilities.setCapability("version", "12.0");
        capabilities.setCapability("name", method.getName());

        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("version", "16.16299");

        driver = new RemoteWebDriver(new URL("http://ondemand.saucelabs.com:80/wd/hub"), capabilities);

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

    public String getValue(){
        return value;
    }


    @AfterMethod(groups = {"admin", "user"})
    public void tearDown(ITestResult testResult) {
        // Local reports
        if(testResult.getStatus()==ITestResult.FAILURE){
            Reports.fail(driver, testResult.getName());
        }
        Reports.stop();

        // SauceLabs
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (testResult.isSuccess() ? "passed":"failed"));
        driver.quit();
    }
}
