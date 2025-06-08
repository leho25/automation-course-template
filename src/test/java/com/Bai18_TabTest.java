package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai18_TabTest extends BasicTest {
    @Test
    public void tabTest() {
        //Login
        Bai16_LoginTest login = new Bai16_LoginTest();
        login.loginTestSucces();
        //New tab navigate
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.open('https://bantheme.xyz/hathanhauto')");
        //Get all window handles
        Set<String> handles = driver.getWindowHandles();
        List<String> handlesList = new ArrayList<>(handles);
        //Switch to old tab tab and close
        driver.switchTo().window(handlesList.get(0));
        driver.close();
        //Switch to new tab
        driver.switchTo().window(handlesList.get(1));
        Utils.hardWait(1000);
        //Click login button from https://bantheme.xyz/hathanhauto
        WebElement btnLogin = driver.findElement(By.xpath("//a[@class='pos-login']"));
        btnLogin.click();
        Utils.hardWait(1000);
        //Verity user is still logged
        WebElement mes = driver.findElement(By.xpath("//div[@class = 'woocommerce-MyAccount-content']"));
        Assert.assertTrue(mes.getText().contains("lenam1235789"));
    }
}
