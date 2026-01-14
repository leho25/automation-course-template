package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.Constains;
import com.pages.HostTool_ForgotPage;
import com.pages.HostTool_LoginPage;
import com.utils.BasicTest;

public class HostTool_ForgotTest extends BasicTest {
    @Test
    public void verifyNavigatonToForgotPage() {
        // Open HostTool login page
        String url = Constains.HOSTTOOLS_URL;
        driver.get(url);
        HostTool_LoginPage loginPage = new HostTool_LoginPage(driver);
        HostTool_ForgotPage forgotPage = new HostTool_ForgotPage(driver);
        // Click on "Forgot your password?" link
        loginPage.clickForgotButton();
        // Verify navigaton to forgot page
        Assert.assertTrue(forgotPage.isForgotUrlCorrect(), "URL is not correct");
        // Verify heading and instruction text art visible
        Assert.assertTrue(forgotPage.isHeadingResetPasswordVisible(), "Heading Reset Password is not visible");
        Assert.assertTrue(forgotPage.isIntructionTextVisible(), "Instruction text is not visible");
    }
}