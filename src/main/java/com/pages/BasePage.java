package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    public void open(String url) {
        this.driver.get(url);
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public WebElement fidElement(By by) {
        return this.driver.findElement(by);
    }

    public WebElement waitElementVisible(By by) {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waiElementClickable(By by) {
        return this.wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void clickElement(By by) {
        waiElementClickable(by).click();
    }

    public void enterText(By by, String text) {
        waitElementVisible(by).sendKeys(text);
    }

    public void enterTextAndKeys(By by, String text, Keys key) {
        waitElementVisible(by).sendKeys(text, key);
    }
}
