package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HostTool_ListingPage extends BasePage {
    public HostTool_ListingPage(WebDriver driver) {
        super(driver);
    }

    By nameBreadcrumb = By.xpath("//span[@aria-label='Breadcrumb']");
    By titleModal = By.xpath("//span[text()='Edit Listing']");

    public String openModalSuccessfully() {
        return waitElementVisible(nameBreadcrumb).getText();
    }

    public Boolean titleModalDisplay() {
        return waitElementVisible(titleModal).isDisplayed();
    }

    public Boolean isElementVisible(String nameFileds) {
        By filedElement = By.xpath("//span[text()='" + nameFileds + "']");
        return waitElementVisible(filedElement).getText().contains(nameFileds);
    }
}
