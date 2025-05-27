package com;

import java.io.Console;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai16_LoginTest extends BasicTest {
    String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
    @Test
    public void loginTestSucces() {
        // Laugh website
        // String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        // Enter email
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys("lenam1235789@gmail.com");
        Utils.hardWait(1000);
        // Enter password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("Nam645835");
        Utils.hardWait(1000);
        // Click login button
        WebElement btnLogin = driver.findElement(By.xpath("//button[@name='login']"));
        btnLogin.click();
        Utils.hardWait(1000);
        // Verify login success
        // WebElement accountContent =
        // driver.findElement(By.xpath("//div[@class='woocommerce-notices-wrapper']"));
        // String content = accountContent.getText();
        // Assert.assertFalse(content.contains("lenam1235789"));
        Assert.assertFalse(isErrorMessageDisplayed());
    }

    @Test
    public void loginTestFailed() {
        driver.get(url);
        // Enter email
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys("lenam1235789@gmail.com");
        Utils.hardWait(1000);
        // Do not enter password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys("");
        Utils.hardWait(1000);
        // Click login button
        WebElement btnLogin = driver.findElement(By.xpath("//button[@name='login']"));
        btnLogin.click();
        Utils.hardWait(1000);
        // Verify error message
        // WebElement errormessage =
        // driver.findElement(By.xpath("//ul[@role='alert']"));
        // String message = errormessage.getText();
        // Assert.assertTrue(message.contains("Lỗi"));
        Assert.assertTrue(isErrorMessageDisplayed());
    }

    public Boolean isErrorMessageDisplayed() {
        try {
            WebElement errormessage = driver.findElement(By.xpath("//ul[@role='alert']"));
            return errormessage.isDisplayed();
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }
}
