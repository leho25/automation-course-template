package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomeIvivuPage extends BasePage {
    public HomeIvivuPage(WebDriver driver) {
        super(driver);
    }

    By clickUserNameButton = By.xpath("//div[contains(@class,'hlb__acc-option')]");
    By clickLoginButton = By.xpath("//button[contains(@class,'hlb__btn-signin')]");

    public void clickUsernameButton() {
        clickElement(clickUserNameButton);
    }

    public void clickLoginButton() {
        clickElement(clickLoginButton);
    }
}
