package com.thetestingacademy.tests.vwoTestCase;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.driver.DriverManagerTL;
import com.thetestingacademy.pages.PageObjectModel.VWOLogin.DashboardPage_VWO;
import com.thetestingacademy.pages.PageObjectModel.VWOLogin.Loginpage_VWO;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin extends CommonToAllTest {
    private static final Logger logger = LogManager.getLogger(TestVWOLogin.class);

    @Owner("Preeti Silla")
    @Description("Login VWO with invalid credentials give error")
    @Test
    public void testLoginNegativeVWO(){
        logger.info("Start of VWO login negative test case");

        Loginpage_VWO loginPage = new Loginpage_VWO(DriverManagerTL.getDriver());
        String error = loginPage.loginToVWOInvalidCreds(PropertiesReader.readKey("invalid_username"),PropertiesReader.readKey("invalid_password"));

        assertThat(error).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error, PropertiesReader.readKey("error_message"));

        logger.info("End of VWO login negative test case");
    }

    @Owner("Preeti Silla")
    @Description("Login VWO with valid credentials give error")
    @Test
    public void testLoginPositiveVWO(){

        Loginpage_VWO loginPage = new Loginpage_VWO(DriverManagerTL.getDriver());
        loginPage.loginToVWOValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashboardPage_VWO dashboardPageVwo = new DashboardPage_VWO(DriverManagerTL.getDriver());
        String loggedUsername = dashboardPageVwo.LoggedInUserName();

        assertThat(loggedUsername).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(loggedUsername, PropertiesReader.readKey("expected_username"));

    }
}
