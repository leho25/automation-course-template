package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utils.BasicTest;
import com.utils.Utils;

public class Bai19_ICEHRM_LoginTest extends BasicTest {
    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password, String expectedErrorMessage) {
        // Lanch website
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        // Enter email
        WebElement emailInput = driver.findElement(By.xpath("//input[@id='username']"));
        emailInput.sendKeys(username);
        // Enter password
        WebElement passwordInput = driver.findElement(By.xpath("//input[@id='password']"));
        passwordInput.sendKeys(password);
        // Click login button
        WebElement btnLogin = driver.findElement(By.xpath("//button[contains(@onclick,'submitLogin()')]"));
        btnLogin.click();
        // Verify login success
        Assert.assertEquals(isErrorMessageDisplayed(), expectedErrorMessage,
                "Error message does not match expected value.");
    }

    @Test(dataProvider = "cartData")
    public void dropDownProvide(String provide, String productType) {
        // Lauch website
        String url = "https://bantheme.xyz/hathanhauto/";
        driver.get(url);
        // Select dropdown provide
        // WebElement selectDropdownProvide =
        // driver.findElement(By.xpath("//select[@id='provide']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='provide']"))).click();
        // selectDropdownProvide.click();
        // Select provide
        WebElement selectProvide = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//option[contains(text(),'" + provide + "')]")));
        selectProvide.click();
        Utils.hardWait(2000);
        // Verify product type from provide
        WebElement textProductType = wait
                .until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//select[@id='productType']"))));
        Assert.assertTrue(textProductType.getText().contains(productType));
    }

    public String isErrorMessageDisplayed() {
        try {
            WebElement errorMessage = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
            return errorMessage.getText();
        } catch (Exception e) {
            // TODO: handle exception
            // WebElement inforUser = driver.findElement(By.xpath("//div[@class='pull-left
            // info']"));
            return "";
        }

    }

    @DataProvider(name = "loginData")
    public Object[][] testDataFeed() {
        return new Object[][] {
                { "admin", "admin", "" },
                { "admin", "admin123", "Login failed" },
                { "user1", "demouserpwd", "" },
                { "user2", "demouserpwd", "" }
        };
    }

    @DataProvider(name = "cartData")
    public Object[][] testDataCart() {
        return new Object[][] {
                { "Audi", "" },
                { "BMW", "1 Series M (1 sản phẩm)" },
                { "Mercedes-Benz", "116 CDi (3 sản phẩm)" },
                { "Volvo", "XC70 (1 sản phẩm)" }
        };
    }
}
