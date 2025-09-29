package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleMaritalStatus extends BasePage {
    public Quote_VehicleMaritalStatus(WebDriver driver) {
        super(driver);
    }

     public void clickButtonMaritalStatus(String marital) {
        By buttonMaritalStatus = By.xpath("//h5[text()='" + marital + "']");
        clickElement(buttonMaritalStatus);
    }
    
}
