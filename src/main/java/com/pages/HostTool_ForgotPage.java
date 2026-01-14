package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HostTool_ForgotPage extends BasePage {
    public HostTool_ForgotPage(WebDriver driver) {
        super(driver);
    }

    By headingResetPassword = By.xpath("//span[text()='Reset Password']");
    By intructionText = By.xpath(
            "//span[text()=\"Enter the email you used to sign up on Host Tools and we'll send you a password reset email.\"]");

    public Boolean isForgotUrlCorrect() {
        return driver.getCurrentUrl().contains("/forgot");
    }

    public Boolean isHeadingResetPasswordVisible() {
        return waitElementVisible(headingResetPassword).isDisplayed();
    }

    public Boolean isIntructionTextVisible() {
        return waitElementVisible(intructionText).isDisplayed();
    }
}
