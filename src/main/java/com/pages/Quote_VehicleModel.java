package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleModel extends BasePage {
    public Quote_VehicleModel(WebDriver driver) {
        super(driver);
    }

    By buttonVehicleModelBy = By.xpath("//h5[text()='Aveo']");

    public void clickButtonVehicleModel() {
        clickElement(buttonVehicleModelBy);
    }
}
