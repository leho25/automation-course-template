package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailField = By.xpath("//input[@id='username']");
    By passwordField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[@name='login']");
    By errorMessage = By.xpath("//ul[@role='alert']");
    By inforMessage = By.xpath("//div[@class='woocommerce-notices-wrapper']");
    By searchField = By.xpath("(//input[@id='s'])[1]");
    Keys keyEnter = Keys.ENTER;

    public LoginPage enterEmail(String email) {
        enterText(emailField, email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        enterText(passwordField, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        clickElementJS(loginButton);
        return this;
    }

    public void enterSearch(String search) {
        enterTextAndKeys(searchField, search, keyEnter);
    }

    public String isSuccessMessageDisplayed() {
        try {
            return fidElement(errorMessage).getText();
        } catch (Exception e) {
            // TODO: handle exception
            return fidElement(inforMessage).getText();
            // return "";
        }
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
