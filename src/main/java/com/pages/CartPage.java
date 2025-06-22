package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    By messageAddToCartSuccess = By.xpath("//div[@class='woocommerce-message']");

    public String messageAddToCart() {
        return fidElement(messageAddToCartSuccess).getText();
    }
}
