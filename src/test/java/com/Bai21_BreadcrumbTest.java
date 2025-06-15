package com;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.utils.BasicTest;
public class Bai21_BreadcrumbTest extends BasicTest {
    @Test
    public void breadcrumbTest() {
        //Lauch website
        String url = "https://bantheme.xyz/hathanhauto/tai-khoan/";
        driver.get(url);
        //method hover menu
        hoverMenu("Hệ thống truyền động, Khung gầm");
        hoverMenu("Hệ thống phanh");
        //Click menu
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Phanh sau ô tô')]")))
                .click();
        //Loop menu
        List<WebElement> listMenu = driver.findElements(By.xpath("//nav[@class='woocommerce-breadcrumb']//a"));
        String breadcrumb = "";
        String menu = "";
        for (int i = 0; i < listMenu.size(); i++) {
            menu = listMenu.get(i).getText();
            breadcrumb += menu;
            //remove "/"
            if (i < listMenu.size() - 1) {
                breadcrumb += " /";
            }
        }
        //Veryfi breadcrumb with correct text displays 
        Assert.assertTrue(breadcrumb.contains(menu));
    } 
    public void hoverMenu(String menuText) {
        String dynamicLocator = "//*[contains(text(),'" + menuText + "')]";
        WebElement hoverElement = driver.findElement(By.xpath(dynamicLocator));
        action.moveToElement(hoverElement).perform();
    }

}
