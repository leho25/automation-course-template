package com.pages;

import org.openqa.selenium.By;

public class Quote_VehicleFinally extends BasePage {
    public Quote_VehicleFinally(org.openqa.selenium.WebDriver driver) {
        super(driver);
    }

    By messageAddSuccess = By.xpath("//h2");
    By warringMessage = By.xpath("//div[@data-fs-field-error]");

    public String getMessageAddSuccess() {
        return waitElementVisible(messageAddSuccess).getText();
    }

    public String getWarringMessage() {
        return waitElementVisible(warringMessage).getText();
    }
}
