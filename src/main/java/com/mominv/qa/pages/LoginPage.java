package com.mominv.qa.pages;

import com.mominv.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends ParentPage {

    @FindBy(id = "email")
    WebElement txtEmail;
    @FindBy(id = "password")
    WebElement txtPassword;
    @FindBy(xpath = "//button[text()='Reset']")
    WebElement btnReset;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement btnSubmit;
    @FindBy(xpath = "/html/body/div[1]/h2")
    WebElement msgLoginStatus;
    @FindBy(xpath = "/html/body/header/h1")
    WebElement hLoginPage;
    @FindBy(xpath = "/html/body/div[2]/h3")
    WebElement msgWelcome;
    @FindBy(linkText = "logout")
    WebElement Logout;
    //Constructor to initialize object
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public LoginPage populateLoginDetails(String email, String password) {
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        return PageFactory.initElements(getDriver(), LoginPage.class);
    }

    public LoginPage clickSubmit() {
        btnSubmit.click();
        return PageFactory.initElements(getDriver(), LoginPage.class);
    }

    public LoginPage clickLogout() {
        Logout.click();
        return PageFactory.initElements(getDriver(), LoginPage.class);
    }

    public LoginPage clickReset() {
        btnReset.click();
        Assert.assertTrue(txtEmail.getAttribute("value").isEmpty());
        Assert.assertTrue(txtPassword.getAttribute("value").isEmpty());
        return PageFactory.initElements(getDriver(), LoginPage.class);
    }

    public String loginStatusMsg() {
        return msgLoginStatus.getText();
    }

    public String loginWelcomeMsg() {
        return msgWelcome.getText();
    }

    public String loginPageHeader() {
        return hLoginPage.getText();
    }


}

