package com.mominv.qa.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    public static String url = null;

    //every time a test thread is created a new browser will open
    public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

    //Instantiating Chromedriver
    public void initialization() {
        String chromedriverFilePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromedriverFilePath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("chrome.switches", "--disable-extensions");
        driver = new ChromeDriver();

        setWebDriver(driver);
        getWebDriver().manage().window().maximize();
        getWebDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        url = "https://assessment-e2e-simple-login.herokuapp.com/";

    }


    public WebDriver getWebDriver() {
        return dr.get();
    }

    public void setWebDriver(WebDriver driver) {
        dr.set(driver);
    }
}
