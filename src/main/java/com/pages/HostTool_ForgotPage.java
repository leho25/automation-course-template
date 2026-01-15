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
    By ForgotPasswordButton = By.xpath("//div[text()='Reset password']");
    By emailField = By.xpath("//input[@data-testid='username']");
    By borderEmailField = By.xpath("//div[@data-invalid='true']");
    By missingEmailError = By.xpath("//span[text()='Missing email.']");

    public Boolean isForgotUrlCorrect() {
        return driver.getCurrentUrl().contains("/forgot");
    }

    public Boolean isHeadingResetPasswordVisible() {
        return waitElementVisible(headingResetPassword).isDisplayed();
    }

    public Boolean isIntructionTextVisible() {
        return waitElementVisible(intructionText).isDisplayed();
    }

    public void enterEmail(String email) {
        enterText(emailField, email);
    }

    public void clickForgotPasswordButton() {
        clickElement(ForgotPasswordButton);
    }

    public Boolean isMissingEmailVisible() {
        return waitElementVisible(missingEmailError).isDisplayed();
    }

    public String getEmailInputBorderColor() {
        System.out.println(waitElementVisible(borderEmailField).getCssValue("border-color"));
        return waitElementVisible(borderEmailField).getCssValue("border-color");
    }

    public Boolean isEmailInputErrorState(){
        return waitElementVisible(emailField).getAttribute("aria-invalid").contains("true");
    }
}
