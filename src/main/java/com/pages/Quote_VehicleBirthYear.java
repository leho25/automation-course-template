package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleBirthYear extends BasePage {
    public Quote_VehicleBirthYear(WebDriver driver) {
        super(driver);
    }

    By buttonContinue = By.xpath("//button[text()='Continue']");

    public void enterBirthYear(String year) {
        By inputBirthYear = By.xpath("//input[@autocomplete='bday-year']");
        enterText(inputBirthYear, year);
        clickElement(buttonContinue);
    }
}
