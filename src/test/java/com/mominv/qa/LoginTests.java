package com.mominv.qa;

import com.mominv.qa.base.TestBase;
import com.mominv.qa.pages.HomePage;
import com.mominv.qa.pages.LoginPage;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class LoginTests extends TestBase {

    private HomePage homePage;
    private TestBase testBase;

    @BeforeTest
    public void setUp() {
        initialization();
    }

    @Test()
    public void clearLoginDetailsOnReset() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        driver = getWebDriver();
        homePage = new HomePage(driver);
        testBase = new TestBase();
        LoginPage loginPage = homePage
                .launchSite()
                .clickLogin()
                .populateLoginDetails(person.getEmail(), person.getPassword())
                .clickReset();
    }

    @Test()
    public void invalidLoginDetails() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        driver = getWebDriver();
        homePage = new HomePage(driver);
        testBase = new TestBase();
        LoginPage loginPage = homePage
                .launchSite()
                .clickLogin()
                .populateLoginDetails(person.getEmail(), person.getPassword())
                .clickSubmit();
        Assert.assertEquals(loginPage.loginStatusMsg(), "Invalid email or password");
    }

    @AfterTest
    public void closeDown() {
        driver.quit();
    }

}
