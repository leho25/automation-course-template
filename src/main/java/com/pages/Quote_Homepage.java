package com.pages;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Quote_Homepage extends BasePage {
    public Quote_Homepage(WebDriver driver) {
        super(driver);
    }

    By logoQuote = By.xpath("//img[@alt='Auto Wise Quote']");
    By buttonRequestFreeQuote = By.xpath("(//button[@type='button'])[1]");

    public boolean isLogoQuoteDisplayed(){
        return waitElementVisible(logoQuote).isDisplayed();
    }
    public void clickButtonRequestFreeQuote(){
        clickElement(buttonRequestFreeQuote);
    }

}