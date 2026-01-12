package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleCurrentyInsured extends BasePage {
    public Quote_VehicleCurrentyInsured(WebDriver driver) {
        super(driver);
    }

    public void clickButtonVeheicleCurrentyInsured(String insured) {
        By buttonVehicleCurrentyInsured = By.xpath("//h5[text()='" + insured + "']");
        clickElement(buttonVehicleCurrentyInsured);
    }
}