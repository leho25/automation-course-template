package com.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleMake extends BasePage {
    public Quote_VehicleMake(WebDriver driver) {
        super(driver);
    }

    public void clickButtonVehicleMake(String vehicleMake) {
        By buttonVehicleMake = By.xpath("//span[text()='" + vehicleMake + "']");
        clickElement(buttonVehicleMake);
        Set<String> handles = driver.getWindowHandles();
        List<String> handList = new ArrayList<>(handles);
        driver.switchTo().window(handList.get(1));
    }

}
