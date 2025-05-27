package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Bai16_RegisterTest extends BasicTest {

    @Test
    public void registerTest() {
        // WebDriverManager.chromedriver().setup();//Setup WebDriveManager for
        // ChormeDriver
        // WebDriver driver = new ChromeDriver();//Initia your webdrive here
        // laugh website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        // enter email
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='reg_email']"));
        emailInput.sendKeys("testtest@gmail.com");
        Utils.hardWait(1000);
        // do not enter password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='reg_password']"));
        passwordInput.sendKeys("");
        Utils.hardWait(1000);
        // click register button
        WebElement btnRegister = driver.findElement(By.xpath("//button[@name='register']"));
        btnRegister.click();
        Utils.hardWait(1000);
        // verifi error message
        WebElement errormessage = driver.findElement(By.xpath("//ul[@role='alert']"));
        String message = errormessage.getText();
        Assert.assertTrue(message.contains("Lỗi"));
        // Assert.assertTrue(message.contains("An account is already registered with
        // your email address."));
        // Assert.assertTrue(loginTest.isErrorMessageDisplayed());
        // Assert.assertTrue(message.contains("Vui lòng nhập mật khẩu tài khoản."));
    }
}
