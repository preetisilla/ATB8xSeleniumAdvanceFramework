package com.thetestingacademy.pages.PageObjectModel.VWOLogin;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage_VWO extends CommonToAllPage {
    WebDriver driver;

    public Loginpage_VWO(WebDriver driver1){
        this.driver = driver1;
    }
    //Page locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signInButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    //Page Actions
    public String loginToVWOInvalidCreds(String user, String pwd){

        driver.get(PropertiesReader.readKey("url"));
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

    public void loginToVWOValidCreds(String user, String pwd) {

        driver.get(PropertiesReader.readKey("url"));
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(signInButton);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
