package com.mominv.qa.pages;

import com.mominv.qa.base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ParentPage {
    //Finding and s
    @FindBy(linkText = "Register")
    WebElement Register;
    @FindBy(linkText = "Login")
    WebElement Login;

    //Constructor to initialize object
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Launching of the site.
    public HomePage launchSite() {
        this.getDriver().get(TestBase.url);
        return this;
    }


    public RegistrationPage clickRegister() {
        Register.click();
        return PageFactory.initElements(getDriver(), RegistrationPage.class);
    }

    public LoginPage clickLogin() {
        Login.click();
        return PageFactory.initElements(getDriver(), LoginPage.class);
    }
}

