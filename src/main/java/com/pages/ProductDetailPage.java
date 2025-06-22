package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage extends BasePage {
    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    By clickAddCartButton = By.xpath("//button[contains(@class,'single_add_to_cart_button')]");

    public void selectOptionDropDown(String selectOption) {
        By selectValue = By.xpath("//option[contains(text(),'" + selectOption + "')]");
        fidElement(selectValue).click();
    }

    public ProductDetailPage clickAddCart() {
        clickElement(clickAddCartButton);
        return this;
    }

}
