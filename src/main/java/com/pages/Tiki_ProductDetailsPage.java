package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tiki_ProductDetailsPage extends BasePage {
    public Tiki_ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    By currentPriceElement = By.xpath("//div[@class='product-price__current-price']");
    By originalPriceElement = By.xpath(" //div[@class='product-price__original-price']");
    By discountRateElement = By.xpath(" //div[@class='product-price__discount-rate']");

    // public void getNameProductDetails(String name) {
    //     By nameProduct = By.xpath("//h1[contains(text(),'" + name + "')]");
    //     waitElementVisible(nameProduct);
    // }

    public void getNamePriceProduct(String name) {
        By nameProduct = By.xpath("//h1[contains(text(),'" + name + "')]");
        WebElement currentPrice = waitElementVisible(currentPriceElement);
        WebElement originalPrice = waitElementVisible(originalPriceElement);
        WebElement discountRate = waitElementVisible(discountRateElement);
        if (discountRate.isDisplayed()) {
            currentPrice.getText();
            waitElementVisible(nameProduct);
        } else {
            originalPrice.getText();
            waitElementVisible(nameProduct);
        }
    }

}
