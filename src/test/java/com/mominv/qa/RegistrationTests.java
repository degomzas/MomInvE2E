package com.mominv.qa;

import com.mominv.qa.base.TestBase;
import com.mominv.qa.pages.HomePage;
import com.mominv.qa.pages.LoginPage;
import com.mominv.qa.pages.RegistrationPage;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.testng.Assert;
import org.testng.annotations.*;


public class RegistrationTests extends TestBase {

    private HomePage homePage;

    @BeforeTest
    public void setUp() {
        initialization();
    }

    @Test()
    public void successful_Registration_Login_Logout() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        driver = getWebDriver();
        homePage = new HomePage(driver);

        RegistrationPage registrationPage = homePage
                .launchSite()
                .clickRegister()
                .populateRegForm(person.getUsername(), person.getEmail(), person.getPassword())
                .clickSubmit();
        Assert.assertEquals(registrationPage.regSuccessMsg(), "Registration successful");

        LoginPage loginPage = registrationPage
                .goToLoginScreen()
                .populateLoginDetails(person.getEmail(), person.getPassword())
                .clickSubmit();
        Assert.assertEquals(loginPage.loginStatusMsg(), "login successful");
        Assert.assertEquals(loginPage.loginWelcomeMsg(), "Hello " + person.getUsername());
        loginPage
                .clickLogout();
        Assert.assertEquals(loginPage.loginPageHeader(), "Login");

    }

    @Test()
    public void duplicate_Registration() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();
        driver = getWebDriver();
        homePage = new HomePage(driver);

        RegistrationPage registrationPage = homePage
                .launchSite()
                .clickRegister()
                .populateRegForm(person.getUsername(), person.getEmail(), person.getPassword())
                .clickSubmit();
        Assert.assertEquals(registrationPage.regSuccessMsg(), "Registration successful");
//Register another user
        registrationPage
                .registerAnotherUser()
                .populateRegForm(person.getUsername(), person.getEmail(), person.getPassword())
                .clickSubmit();
        Assert.assertEquals(registrationPage.regSuccessMsg(), "Email already used");
    }

    @AfterTest
    public void closeDown() {
        driver.quit();
    }

}
