package com;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai20_ShoppingCartTest extends BasicTest{
    @Test
    public void shoppingCartTest() {
        // navigate
        // login
        // Verify login success
        Bai16_LoginTest login = new Bai16_LoginTest();
        login.loginTestSucces();
        // enter search*
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='s'])[1]"))).sendKeys("merc",Keys.ENTER);
        // select the first result
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class = 'item-product'])[1]"))).click();
        // select option
        Select selectValue = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pa_xuat-xu"))));
        selectValue.selectByValue("england");
        // click cart button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'cart')]"))).click();
        // verify item added to cart
        WebElement messageAddToCartSuccess = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertTrue(messageAddToCartSuccess.getText().contains("đã được thêm vào giỏ hàng"));
    }
    
}
