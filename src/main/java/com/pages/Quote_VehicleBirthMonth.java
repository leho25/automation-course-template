package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleBirthMonth extends BasePage {
    public Quote_VehicleBirthMonth(WebDriver driver) {
        super(driver);
    }

    public void clickButtonVeheicleBirthMonth(String month) {
        By buttonVehicleBirthMonth = By.xpath("//h5[text()='" + month + "']");
        clickElement(buttonVehicleBirthMonth);
    }
}