package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginIvivuPage extends BasePage {
    public LoginIvivuPage(WebDriver driver) {
        super(driver);
    }

    By emailPhoneIvivuField = By.xpath("//input[@name='emailOrPhone']");
    By passwordIvivuField = By.xpath("//input[@type='password']");
    By clickLoginButton = By.xpath("//button[@class='auth-login__button']");
    By errorMessage = By.xpath("//small[contains(@class,'is-error')]");

    public void enterEmailPhone(String text) {
        enterText(emailPhoneIvivuField, text);
    }

    public void enterPassword(String text) {
        enterText(passwordIvivuField, text);
    }

    public void clickLogin() {
        clickElement(clickLoginButton);
    }

    public String isErrorMessageDisplayed() {
        try {
            return fidElement(errorMessage).getText();
        } catch (Exception e) {
            // TODO: handle exception
            return "";
        }
    }
}
