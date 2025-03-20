package com.thetestingacademy.tests.vwoTestCase.PageFactorTestcases;

import com.thetestingacademy.base.CommonToAllTest;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.listeners.RetryAnalyser;
import com.thetestingacademy.pages.PageFactory.LoginPage_PF;
import com.thetestingacademy.pages.PageObjectModel.VWOLogin.Loginpage_VWO;
import com.thetestingacademy.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_PF extends CommonToAllTest {
    @Owner("Preeti Silla")
    @Description("Login VWO with invalid credentials give error - Page Factory")
    @Test(retryAnalyzer = RetryAnalyser.class)
    public void testLoginNegativeVWO_PF() {

        WebDriver driver = DriverManager.getDriver();
        driver.get(PropertiesReader.readKey("url"));
        LoginPage_PF loginPagePf = new LoginPage_PF(driver);
        String error = loginPagePf.loginToVWOInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));
        Assert.assertEquals(error, PropertiesReader.readKey("error_message"));

    }
}
