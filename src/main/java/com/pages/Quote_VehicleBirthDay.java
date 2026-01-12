package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleBirthDay extends BasePage {
    public Quote_VehicleBirthDay(WebDriver driver) {
        super(driver);
    }

    public void clickButtonVehicleBirthDay(String day) {
        By buttonVehicleBirthDay = By.xpath("//h5[text()='" + day + "']");
        clickElement(buttonVehicleBirthDay);
    }
}