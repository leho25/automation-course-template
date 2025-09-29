package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_VehicleMilitaryStatus extends BasePage {
    public Quote_VehicleMilitaryStatus(WebDriver driver) {
        super(driver);
    }

    public void clickButtonMilitaryStatus(String military) {

        // By buttonMilitaryStatus = By.xpath("//h5[text()='No']");
        try {
            By buttonMilitaryStatus = By.xpath("//h5[text()='" + military + "']");
            clickElementJS(buttonMilitaryStatus);
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Click military status failed" + e);
        }

    }

}
