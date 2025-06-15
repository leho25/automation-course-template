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
    @Test
    public void bookingTest(){
        //lauch website
        String url = "https://www.ivivu.com/";
        driver.get(url);
        //Click date button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[1]"))).click();
        //choose date start
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='2025-06-16']"))).click();
       //choose date end
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='2025-06-19']"))).click();
        //Search place
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'sb__search-input')]"))).click();
        //choose place
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Đà Lạt')]"))).click();
        //click search button
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(@class,'btn-bs__default')]"))).click();
        //remove map element
        // WebElement map = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='pdv__location-box'])[1]")));
        // JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        // jsExecutor.executeScript("arguments[0].remove();",map);
        //choose hotel
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Khách sạn Colline Đà Lạt']"))).click();
        //click order button
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='hov__summary__book-now--button']"))).click();
        //click request to order button
        // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@fdprocessedid='vpxg5x']"))).click();
        WebElement nameHotel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='rmi__hotel-name']")));
        Assert.assertTrue(nameHotel.isDisplayed());
    }
}
