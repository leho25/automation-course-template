package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver){
        super(driver);
    }
    By clickItemProduct = By.xpath("(//div[@class='item-product'])[1]");

    public void clickItem(){
        clickElement(clickItemProduct);
    }

    
}
