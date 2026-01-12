package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleModel extends BasePage {
    public Quote_VehicleModel(WebDriver driver) {
        super(driver);
    }

    public void clickButtonVehicleModel(String vehicleModel) {
        By buttonVehicleModelBy = By.xpath("//h5[text()='" + vehicleModel + "']");
        clickElement(buttonVehicleModelBy);
    }
}
