package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleContact extends BasePage {
    public Quote_VehicleContact(WebDriver driver) {
        super(driver);
    }

    By buttonGetMyQuotes = By.xpath("//button[text()='Get My Quotes']");

    public void enterContectInfomation(String emaill, String phoneNumber) {
        By inputEmail = By.xpath("//input[@type='email']");
        By inputPhoneNumber = By.xpath("//input[@name='phone']");
        enterText(inputEmail, emaill);
        enterText(inputPhoneNumber, phoneNumber);

    }

    public void clickButtonGetMyQuotes() {
        enterContectInfomation("lenam@gmail.com", "2025554434");
        clickElement(buttonGetMyQuotes);
    }
}