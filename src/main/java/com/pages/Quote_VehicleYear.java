package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleYear extends BasePage {
    public Quote_VehicleYear(WebDriver driver) {
        super(driver);
    }

    public void clickButtonVehicleYear(Integer year) {
        By buttonVehicleYear = By.xpath("//h5[text()='" + year + "']");
        System.out.println(driver.findElements(By.xpath("//h5[text()='" + year + "']")).size());
        clickElement(buttonVehicleYear);
    }
}
