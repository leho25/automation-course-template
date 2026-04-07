package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    public Boolean waitElementLocatedInVisiable(By by) {
        return this.wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public Boolean waitElementInVisiable(WebElement element) {
        return this.wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public WebElement waitElementVisible(By by) {
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public Boolean waitUrlContains(String url){
        return this.wait.until(ExpectedConditions.urlContains(url));
    }
    public List<WebElement> waitElementPresence(By by) {
        return this.wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public WebElement waitElementClickable(By by) {
        return this.wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public Boolean waitUrlToBe(String url) {
        return this.wait.until(ExpectedConditions.urlToBe(url));
    }

    public void clickElement(By by) {
        waitElementClickable(by).click();
    }

    public void clickElementJS(By by) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", waitElementClickable(by));
    }

    public void enterText(By by, String text) {
        waitElementVisible(by).sendKeys(text);
    }

    public void enterTextAndKeys(By by, String text, Keys key) {
        waitElementVisible(by).sendKeys(text, key);
    }

    public void setChecked(By by, boolean shouldBeChecked) {
        WebElement checkbox = waitElementVisible(by);
        boolean isChecked = checkbox.getAttribute("data-checked").equals("true");
        if (isChecked != shouldBeChecked) {
            checkbox.click();
        }
    }
    // public int getElementValue(By by){
    //     String value = waitElementVisible(by).getAttribute("value");
    //     if(value == null || value.isEmpty()){
    //         return 0;
    //     }
    //     return Integer.parseInt(value);
    // }
}
