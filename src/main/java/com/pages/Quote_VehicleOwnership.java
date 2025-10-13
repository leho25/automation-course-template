package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleOwnership extends BasePage {
    public Quote_VehicleOwnership(WebDriver driver) {
        super(driver);
    }

    public void clickButtonVehicleOwnership(String ownershipType) {
        By buttonVehicleOwnership = By.xpath("//h5[text()='" + ownershipType + "']");
        clickElement(buttonVehicleOwnership);
    }
}