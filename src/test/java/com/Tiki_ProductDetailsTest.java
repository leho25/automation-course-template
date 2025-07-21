package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.Constains;
import com.pages.Tiki_HomePage;
import com.pages.Tiki_ProductDetailsPage;
import com.pages.Tiki_SearchResultPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class Tiki_ProductDetailsTest extends BasicTest {
    @Test
    public void productDetailTest() {
        Tiki_HomePage tiki_HomePage = new Tiki_HomePage(driver);
        Tiki_SearchResultPage tiki_SearchResultPage = new Tiki_SearchResultPage(driver);
        String url = Constains.HOMEPAGE_TIKI_URL;
        tiki_HomePage.open(url);
        tiki_HomePage.search("Điện Thoại");
        Utils.hardWait(2000);
        tiki_SearchResultPage.clickItemProduct();
        Assert.assertTrue(namePriceDisplayed());
    }

    public Boolean namePriceDisplayed() {
        Tiki_ProductDetailsPage productDetailsPage = new Tiki_ProductDetailsPage(driver);
        productDetailsPage.getNamePriceProduct("Điện Thoại Samsung Galaxy A06 (4GB/128GB) - Hàng Chính Hãng");
        return true;
    }
}
