package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By clickItemProduct = By.xpath("(//div[@class='item-product'])[1]");
    By textTitle = By.xpath("//nav[@class='woocommerce-breadcrumb']");

    public void clickItem() {
        clickElement(clickItemProduct);
    }

    public void hoverMenu(String menuText) {
        By dynamicLocator = By.xpath("//*[contains(text(),'" + menuText + "')]");
        actionHover(dynamicLocator);
    }

    public void clickMenu(String menuText) {
        By dynamicLocator = By.xpath("//*[contains(text(),'" + menuText + "')]");
        clickElement(dynamicLocator);
    }

    public String isDisplayTitle() {
        return fidElement(textTitle).getText();
    }
}
