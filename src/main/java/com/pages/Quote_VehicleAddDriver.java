package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleAddDriver extends BasePage {
    public Quote_VehicleAddDriver(WebDriver driver) {
        super(driver);
    }

    public void clickButtonAddDriver(String addDriver) {
        By buttonAddDriver = By.xpath("//button[text()='" + addDriver + "']");
        // By buttonMilitaryStatus = By.xpath("//h5[text()='No']");

        clickElementJS(buttonAddDriver);

    }

}
