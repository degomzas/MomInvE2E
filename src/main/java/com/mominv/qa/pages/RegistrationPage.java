package com.mominv.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends ParentPage {

    @FindBy(id = "username")
    WebElement txtUserName;
    @FindBy(id = "email")
    WebElement txtEmail;
    @FindBy(id = "password")
    WebElement txtPassword;
    @FindBy(xpath = "//button[text()='Reset']")
    WebElement btnReset;
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement btnSubmit;
    @FindBy(xpath = "/html/body/div[1]/h2")
    WebElement msgRegistration;
    @FindBy(linkText = "login")
    WebElement Login;
    @FindBy(linkText = "Register another user")
    WebElement btnRegAnotherUser;

    //Constructor to initialize object
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    public RegistrationPage populateRegForm(String username, String email, String password) {
        txtUserName.sendKeys(username);
        txtEmail.sendKeys(email);
        txtPassword.sendKeys(password);
        return this;
    }

    public RegistrationPage clickSubmit() {
        btnSubmit.click();
        return this;
    }

    public String regSuccessMsg() {
        return msgRegistration.getText();
    }

    public LoginPage goToLoginScreen() {
        Login.click();
        return PageFactory.initElements(getDriver(), LoginPage.class);
    }

    public RegistrationPage registerAnotherUser() {
        btnRegAnotherUser.click();
        return PageFactory.initElements(getDriver(), RegistrationPage.class);
    }
}

