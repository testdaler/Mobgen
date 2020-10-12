package com.mobgen.pages;

import com.mobgen.Utilities.ConfigReader;
import com.mobgen.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@href='/login']")

    public WebElement login;

    @FindBy(id = "user")
    public WebElement userEmail;

    @FindBy(id = "password")
    public WebElement userPassword;

    @FindBy(id = "login")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()='Log in']")
    public WebElement loginButton2;

    @FindBy(xpath = "//button[@data-test-id='moonshot-billing-skip-cta']")
    public WebElement startwithoutbussiness;


    public void login() throws InterruptedException {
        login.click();
        userEmail.sendKeys(ConfigReader.getProperty("email"));
       userPassword.sendKeys(ConfigReader.getProperty("password1"));
       loginButton.click();
       Thread.sleep(2000);
       userPassword.sendKeys(ConfigReader.getProperty("password2"));
       loginButton2.click();
        Thread.sleep(2000);
       //startwithoutbussiness.click();

    }

}
