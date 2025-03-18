package com.thetestingacademy.pages.PageObjectModel.OrangeHR;

import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage_OHR extends CommonToAllPage {
    WebDriver driver;

    public DashboardPage_OHR(WebDriver driver1){
        this.driver = driver1;
    }

    //Page Locator
    By userNameOnDashboard = By.xpath("//h6[normalize-space()='PIM']");

    //Page Action
    public String LoggedInUserName(){
        presenceOfElement(userNameOnDashboard);
        return getElement(userNameOnDashboard).getText();
    }
}
