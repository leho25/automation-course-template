package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleDriverName extends BasePage {
    public Quote_VehicleDriverName(WebDriver driver) {
        super(driver);
    }

    By buttonContinue = By.xpath("//button[text()='Continue']");
    By dropdownRelationship = By.xpath("//button[@name='drivers_1_relationship']");

    public void enterDriverName(String firstName, String lastName) {
        By inputFirstName = By.xpath("//input[@placeholder='First Name']");
        By inputLastName = By.xpath("//input[@placeholder='Last Name']");
        enterText(inputFirstName, firstName);
        enterText(inputLastName, lastName);

    }

    public void clickButtonContinue() {
        clickElement(buttonContinue);
    }

    public void clickDropdownRelationship() {
        clickElement(dropdownRelationship);
    }

    public void clickRelationshipOption(String relationship) {
        By optionRelationship = By.xpath("//div[text()='" + relationship + "']");
        clickElement(optionRelationship);
    }
}