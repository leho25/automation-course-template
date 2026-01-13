package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.Constains;
import com.pages.HostTool_LoginPage;
import com.utils.BasicTest;

public class HostTool_LoginTest extends BasicTest {
    // @Test
    public void openHostToolPage() {
        String url = Constains.HOSTTOOLS_URL;
        driver.get(url);
    }

    @Test
    public void verifyBlankEmailAndPassword() {
        openHostToolPage();
        HostTool_LoginPage loginPage = new HostTool_LoginPage(driver);
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        // Assert.assertTrue(loginPage.getErrorMessage("Missing
        // email.").contains("Missing email")
        // && loginPage.getErrorMessage("Please enter your password.").contains("Please
        // enter your password"));
        Assert.assertTrue(loginPage.getErrorMessage("Missing email.")
                && loginPage.getErrorMessage("Please enter your password."));
    }

    @Test
    public void verifyInvalidEmailFormat() {
        openHostToolPage();
        HostTool_LoginPage loginPage = new HostTool_LoginPage(driver);
        loginPage.enterEmail("%&#@gmail,com");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage("Please enter a valid email."));
    }

    @Test
    public void verifyInvalidPassword() {
        openHostToolPage();
        HostTool_LoginPage loginPage = new HostTool_LoginPage(driver);
        loginPage.enterEmail("cypress@hosttools.com");
        loginPage.enterPassword("23456789");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.getErrorMessage("That email and password combination is invalid.  Try something else."));
    }
}
