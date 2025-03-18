package com.thetestingacademy.tests.OrangeHR;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.PageObjectModel.OrangeHR.DashboardPage_OHR;
import com.thetestingacademy.pages.PageObjectModel.OrangeHR.LoginPage_POM_OHR;
import com.thetestingacademy.pages.PageObjectModel.VWOLogin.DashboardPage_VWO;
import com.thetestingacademy.pages.PageObjectModel.VWOLogin.Loginpage_VWO;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestOrangeHR extends CommonToAllTest {
    @Owner("Preeti Silla")
    @Description("Login Orange HR with valid credentials")
    @Test
    public void testLoginPositiveOHR(){

        LoginPage_POM_OHR testOrangeHR = new LoginPage_POM_OHR(DriverManager.getDriver());
        testOrangeHR.loginToOHRCreds(PropertiesReader.readKey("ohr_username"),PropertiesReader.readKey("ohr_password"));

        DashboardPage_OHR dashboardPageOHR = new DashboardPage_OHR(DriverManager.getDriver());
        String loggedUsername = dashboardPageOHR.LoggedInUserName();

        assertThat(loggedUsername).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedUsername, PropertiesReader.readKey("ohr_expected_username"));

    }
}
