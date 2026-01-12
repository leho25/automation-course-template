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
        By inputZipCodeRelation = By.xpath("//input[@name='postalCode']");
        By inputStreetAddress = By.xpath("//input[@placeholder='e.g. 120 South Beverly Drive']");

        if (driver.findElements(inputZipCode).size() > 0) {
            waitElementVisible(inputZipCode).clear();
            enterText(inputZipCode, zipCode);
            System.out.println("enter zipcode is locator: zipcode");
        } else {
            waitElementVisible(inputZipCodeRelation).clear();
            enterText(inputZipCodeRelation, zipCode);
            System.out.println("enter zipcode is locator: postalCode");
        }

        enterText(inputStreetAddress, streetAddress);
    }

    public void clickButtonContinue() {
        clickElement(buttonContinue);
    }
}