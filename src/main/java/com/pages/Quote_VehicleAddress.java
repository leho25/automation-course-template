package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Quote_VehicleAddress extends BasePage {
    public Quote_VehicleAddress(WebDriver driver) {
        super(driver);
    }

    By buttonContinue = By.xpath("//button[text()='Continue']");

    public void enterAddress(String zipCode, String streetAddress) {

        By inputZipCode = By.xpath("//input[@name='zipcode']");
        By inputStreetAddress = By.xpath("//input[@placeholder='e.g. 120 South Beverly Drive']");
        waitElementVisible(inputZipCode).clear();
        enterText(inputZipCode, zipCode);
        enterText(inputStreetAddress, streetAddress);

    }

    public void clickButtonContinue() {
        clickElement(buttonContinue);
    }
}