package com.thetestingacademy.pages.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage_VWO {
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
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signInButton).click();

        try{
            Thread.sleep(3000);
        }catch(InterruptedException e){
            throw new RuntimeException(e);
        }

        String error = driver.findElement(error_message).getText();
        return error;
    }
}
