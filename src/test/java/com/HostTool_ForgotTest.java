package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.Constains;
import com.pages.HostTool_ForgotPage;
import com.pages.HostTool_LoginPage;
import com.utils.BasicTest;

public class HostTool_ForgotTest extends BasicTest {
    // @Test
    public void verifyNavigatonToForgotPage() {
        // Open HostTool login page
        String url = Constains.HOSTTOOLS_URL;
        HostTool_LoginPage loginPage = new HostTool_LoginPage(driver);
        loginPage.open(url);
        HostTool_ForgotPage forgotPage = new HostTool_ForgotPage(driver);
        // Click on "Forgot your password?" link
        loginPage.clickForgotButton();
        // Verify navigaton to forgot page
        Assert.assertTrue(forgotPage.isForgotUrlCorrect(), "URL is not correct");
        // Verify heading and instruction text art visible
        Assert.assertTrue(forgotPage.isHeadingResetPasswordVisible(), "Heading Reset Password is not visible");
        Assert.assertTrue(forgotPage.isIntructionTextVisible(), "Instruction text is not visible");
    }

    @Test
    public void verifyBlankEmailOnForgotPage() {
        // Open HostTool forgot page
        String forgotUrl = Constains.HOSTTOOLS_FORGOT_URL;
        HostTool_ForgotPage forgotPage = new HostTool_ForgotPage(driver);
        forgotPage.open(forgotUrl);
        // Click on "Reset password" button with blank email\
        forgotPage.enterEmail("");
        forgotPage.clickForgotPasswordButton();
        // Verify "Missng email" error message is displayed
        Assert.assertTrue(forgotPage.isMissingEmailVisible());
        // Verify email input field has red border
        Assert.assertEquals(forgotPage.getEmailInputBorderColor(), "rgb(220, 38, 38)", "Border color is not correct");
        // Assert.assertTrue(forgotPage.isEmailInputErrorState(), "Email input is not in error state");
    }
}