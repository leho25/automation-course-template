package com;

import org.testng.annotations.Test;

import com.config.Constains;
import com.pages.Tiki_HomePage;
import com.pages.Tiki_SearchResultPage;
import com.utils.BasicTest;

public class Tiki_ProductDetailsTest extends BasicTest {
    @Test
    public void productDetailTest() {
        Tiki_HomePage tiki_HomePage = new Tiki_HomePage(driver);
        Tiki_SearchResultPage tiki_SearchResultPage = new Tiki_SearchResultPage(driver);
        String url = Constains.HOMEPAGE_TIKI_URL;
        tiki_HomePage.open(url);
        tiki_HomePage.search("Điện Thoại");
        tiki_SearchResultPage.clickItemProduct();
    }
}
