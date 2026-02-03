package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HostTool_MessagePage extends BasePage {
    public HostTool_MessagePage(WebDriver driver) {
        super(driver);
    }

    By menuButtonMesssages = By.xpath("//span[text()='Messaging']");
    By allListingsLink = By.xpath("//span[text()='All listings']");

    public void clickmenuButtonMessages() {
        clickElement(menuButtonMesssages);
    }

    public void clickAllListingsLink() {
        clickElement(allListingsLink);
    }
}
