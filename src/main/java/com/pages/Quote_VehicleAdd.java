package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleAdd extends BasePage {
    public Quote_VehicleAdd(WebDriver driver) {
        super(driver);
    }

    By buttonVehicleNoThanhs = By.xpath("//button[text()='No, Thanks']");

    public void clickButtonVehicleNoThanks() {
        clickElement(buttonVehicleNoThanhs);
    }
}
