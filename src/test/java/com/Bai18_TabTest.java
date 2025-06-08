package com;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai18_TabTest extends BasicTest {
    @Test
    public void tabTest() {
        // login
        Bai16_LoginTest login = new Bai16_LoginTest();
        login.loginTestSucces();
        // open new tab
        // close old tad
        // driver.close();
        // Utils.hardWait(3000);
        // on the new tab click login button
        WebElement btnLoginHome = driver.findElement(By.xpath("//a[@class='pos-login']"));
        btnLoginHome.click();
        Utils.hardWait(3000);
        // verify user is still logged
    }
}
