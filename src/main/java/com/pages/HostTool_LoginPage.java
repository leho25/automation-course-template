package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HostTool_LoginPage extends BasePage {
    public HostTool_LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailField = By.xpath("//input[@data-testid='username']");
    By passwordField = By.xpath("//input[@data-testid='password']");
    By loginButton = By.xpath("//div[text()='Sign in']");

    public void enterEmail(String email) {
        enterText(emailField, email);
    }

    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public Boolean getErrorMessage(String message) {
        By errorMessage = By.xpath("//span[text()='" + message + "']");
        return waitElementVisible(errorMessage).isDisplayed();

    }
}