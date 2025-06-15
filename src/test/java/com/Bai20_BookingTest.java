package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai20_BookingTest extends BasicTest{
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
