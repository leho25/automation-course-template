package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginICEHRMPage extends BasePage {
    public LoginICEHRMPage(WebDriver driver) {
        super(driver);
    }

    By usernameInput = By.xpath("//input[@id='username']");
    By passwordInput = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[contains(@onclick,'submitLogin()')]");
    By message = By.xpath("//div[@class='alert alert-danger']");

    public void enterUsername(String username) {
        enterText(usernameInput, username);
    }

    public void enterPassword(String password) {
        enterText(passwordInput, password);
    }

    public void clickLogin() {
        clickElement(loginButton);
    }

    public String getErrorMessage() {
        try {
            WebElement errorMessage = fidElement(message);
            return errorMessage.getText();
        } catch (Exception e) {
            return "";
        }

    }
}
