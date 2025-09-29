package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleDriverName extends BasePage {
    public Quote_VehicleDriverName(WebDriver driver) {
        super(driver);
    }

    By buttonContinue = By.xpath("//button[text()='Continue']");

    public void enterDriverName(String firstName, String lastName) {
        By inputFirstName = By.xpath("//input[@placeholder='First Name']");
        By inputLastName = By.xpath("//input[@placeholder='Last Name']");
        enterText(inputFirstName, firstName);
        enterText(inputLastName, lastName);

    }

    public void clickButtonContinue() {
        enterDriverName("le", "Ho");
        clickElement(buttonContinue);
    }
}