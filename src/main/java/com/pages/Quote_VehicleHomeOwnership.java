package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleHomeOwnership extends BasePage {
    public Quote_VehicleHomeOwnership(WebDriver driver) {
        super(driver);
    }

     public void clickButtonOwnership(String ownership) {
        By buttonOwnership = By.xpath("//h5[text()='" + ownership + "']");
        clickElement(buttonOwnership);
    }
    
}
