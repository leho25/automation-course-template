package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleAdd extends BasePage {
    public Quote_VehicleAdd(WebDriver driver) {
        super(driver);
    }

    By buttonVehicleNoThanhs = By.xpath("//button[text()='No, Thanks']");
    By buttonVehicleAddAnother = By.xpath("//h5[text()='Add Another Vehicle']");

    public void clickButtonVehicleNoThanks() {
        clickElement(buttonVehicleNoThanhs);
    }

    public void clickButtonVehicleAddAnother() {
        clickElement(buttonVehicleAddAnother);
    }
}
