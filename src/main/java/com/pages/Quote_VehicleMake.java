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

    By buttonVehicleMake = By.xpath("//span[text()='CHEVROLET']");

    public void clickButtonVehicleMake() {
        clickElement(buttonVehicleMake);
        Set<String> handles = driver.getWindowHandles();
        List<String> handList = new ArrayList<>(handles);
        driver.switchTo().window(handList.get(1));
    }

}
