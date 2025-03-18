package com.thetestingacademy.pages.PageObjectModel.VWOLogin;

import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage_VWO extends CommonToAllPage {
    WebDriver driver;

    public DashboardPage_VWO(WebDriver driver1){
        this.driver = driver1;
    }

    //Page Locator
    By userNameOnDashboard = By.cssSelector("[data-qa='lufexuloga']");

    //Page Action
    public String LoggedInUserName(){
        presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }
}
