package com.thetestingacademy.pages.PageFactory;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_PF extends CommonToAllPage {

    public LoginPage_PF(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    //Page locators
    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id = "login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signInButton;

    @FindBy(id = "js-notification-box-msg")
    private WebElement error_message;

    //Page Actions
    public String loginToVWOInvalidCreds(String user, String pwd){

        enterInput(username,user);
        enterInput(password,pwd);
        clickElement(signInButton);

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        String error = getText(error_message);
        return error;
    }
}
