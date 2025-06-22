package com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.utils.BasicTest;

public class Bai21_MenuTest extends BasicTest {
    @Test
    public void testNaviga() {
        //Lauch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan";
        driver.get(url);
        //Loop menu
        List<WebElement> list = driver.findElements(By.xpath("//ul[@id='menu-menu-phu']//li/a"));
        for (int i = 0; i < list.size(); i++) {
            list = driver.findElements(By.xpath("//ul[@id='menu-menu-phu']//li/a"));
            WebElement item = list.get(i);
            item.click();
        }
    }   
}
