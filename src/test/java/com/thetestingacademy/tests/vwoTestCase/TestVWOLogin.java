package com.thetestingacademy.tests.vwoTestCase;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.PageObjectModel.VWOLogin.DashboardPage_VWO;
import com.thetestingacademy.pages.PageObjectModel.VWOLogin.Loginpage_VWO;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin extends CommonToAllTest {
    @Owner("Preeti Silla")
    @Description("Login VWO with invalid credentials give error")
    @Test
    public void testLoginNegativeVWO(){

        Loginpage_VWO loginPage = new Loginpage_VWO(DriverManager.getDriver());
        String error = loginPage.loginToVWOInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        assertThat(error).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error, PropertiesReader.readKey("error_message"));

    }

    @Owner("Preeti Silla")
    @Description("Login VWO with valid credentials give error")
    @Test
    public void testLoginPositiveVWO(){

        Loginpage_VWO loginPage = new Loginpage_VWO(DriverManager.getDriver());
        loginPage.loginToVWOValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage_VWO dashboardPageVwo = new DashboardPage_VWO(DriverManager.getDriver());
        String loggedUsername = dashboardPageVwo.LoggedInUserName();

        assertThat(loggedUsername).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedUsername, PropertiesReader.readKey("expected_username"));

    }
}
