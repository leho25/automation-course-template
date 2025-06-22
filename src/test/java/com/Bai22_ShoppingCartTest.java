package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.Constains;
import com.pages.CartPage;
import com.pages.ProductDetailPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai22_ShoppingCartTest extends BasicTest {
    @Test
    public void shoppingCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        ProductDetailPage homeDetailPage = new ProductDetailPage(driver);
        CartPage cartPage = new CartPage(driver);
        String url = Constains.URL;

        loginPage.open(url);
        loginPage.login("lenam1235789@gmail.com", "Nam645835");
        Assert.assertFalse(loginPage.isSuccessMessageDisplayed().contains("Xin chào lenam1235789"));
        loginPage.enterSearch("merc");

        homePage.clickItem();

        homeDetailPage.selectOptionDropDown("England");
        homeDetailPage.clickAddCart();

        Assert.assertTrue(cartPage.messageAddToCart().contains("đã được thêm vào giỏ hàng"));
    }
}
