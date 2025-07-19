package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tiki_SearchResultPage extends BasePage {
    public Tiki_SearchResultPage(WebDriver driver) {
        super(driver);
    }

    By itemProduct = By.xpath("(//a[@data-view-id='product_list_item'])[1]");

    public void clickItemProduct() {
        clickElementJS(itemProduct);
    }
}