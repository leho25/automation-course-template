package com;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai17_ShoppingCartTest extends BasicTest {
    @Test
    public void shoppingCartTest() {
        // navigate
        // login
        // Verify login success
        Bai16_LoginTest login = new Bai16_LoginTest();
        login.loginTestSucces();
        // enter search
        WebElement searchInput = driver.findElement(By.xpath("(//input[@id='s'])[1]"));
        searchInput.sendKeys("merc", Keys.ENTER);
        Utils.hardWait(2000);
        // select the first result
        WebElement itemProduct = driver.findElement(By.xpath("(//div[@class = 'item-product'])[1]"));
        itemProduct.click();
        Utils.hardWait(2000);
        // select option
        Select selectValue = new Select(driver.findElement(By.id("pa_xuat-xu")));
        selectValue.selectByValue("england");
        Utils.hardWait(2000);
        // click cart button
        WebElement btnCart = driver.findElement(By.xpath("//button[contains(@class,'cart')]"));
        btnCart.click();
        Utils.hardWait(2000);
        // verify item added to cart
        WebElement messageAddToCartSuccess = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertTrue(messageAddToCartSuccess.getText().contains("đã được thêm vào giỏ hàng"));
        Utils.hardWait(1000);
    }
}
