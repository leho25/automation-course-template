package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleAddDriver extends BasePage {
    public Quote_VehicleAddDriver(WebDriver driver) {
        super(driver);
    }

    By buttonAddAnotherDriver = By.xpath("//h5[text()='Add Another Driver']");
    By buttonNoThanks = By.xpath("//button[text()='No, Thanks']");

    public void clickButtonNoThanks() {
        clickElementJS(buttonNoThanks);
    }

    public void clickButtonAddAnotherDriver() {
        clickElement(buttonAddAnotherDriver);
    }
}
