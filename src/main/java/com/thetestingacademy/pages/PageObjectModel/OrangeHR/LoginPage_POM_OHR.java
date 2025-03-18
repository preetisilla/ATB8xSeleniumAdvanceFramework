package com.thetestingacademy.pages.PageObjectModel.OrangeHR;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage_POM_OHR extends CommonToAllPage {
    WebDriver driver;

    public LoginPage_POM_OHR(WebDriver driver1){
        this.driver = driver1;
    }

    //page locator
    private By username = By.xpath("//input[@placeholder='Username']");
    private By password = By.xpath("//input[@placeholder='Password']");
    private By submit_btn = By.xpath("//button[normalize-space()='Login']");


    //page actions
    public void loginToOHRCreds(String user, String pwd) {

        driver.get(PropertiesReader.readKey("orange_hr_url"));
        enterInput(username, user);
        enterInput(password, pwd);
        clickElement(submit_btn);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
