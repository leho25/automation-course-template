package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleGender extends BasePage {
    public Quote_VehicleGender(WebDriver driver) {
        super(driver);
    }

     public void clickButtonGender(String gender) {
        By buttonGender = By.xpath("//h5[text()='" + gender + "']");
        clickElement(buttonGender);
    }
    
}
