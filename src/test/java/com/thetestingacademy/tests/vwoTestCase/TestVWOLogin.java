package com.thetestingacademy.tests.vwoTestCase;

import com.thetestingacademy.pages.PageObjectModel.Loginpage_VWO;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin {
    @Owner("Preeti Silla")
    @Description("Login VWO with invalid credentials give error")
    @Test
    public void testLoginNegativeVWO(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com/#/login");

        Loginpage_VWO loginPage = new Loginpage_VWO(driver);
        String error = loginPage.loginToVWOInvalidCreds("user","pwd");

        assertThat(error).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(error,"Your email, password, IP address or location did not match");

        driver.quit();
    }
}
