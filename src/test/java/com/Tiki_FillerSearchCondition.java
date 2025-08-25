package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.Constains;
import com.pages.Tiki_BreadcrumbPage;
import com.pages.Tiki_HomePage;
import com.utils.BasicTest;

public class Tiki_FillerSearchCondition extends BasicTest {
    @Test
    public void fillerSearchCondition() {
        Tiki_HomePage tiki_HomePage = new Tiki_HomePage(driver);
        Tiki_BreadcrumbPage tiki_BreadcrumbPage = new Tiki_BreadcrumbPage(driver);
        // Open tiki homepage
        tiki_HomePage.open(Constains.HOMEPAGE_TIKI_URL);
        // select menu
        tiki_HomePage.selectMenu("Điện Gia Dụng");
        tiki_BreadcrumbPage.selectBreadcrumb("Lò vi sóng");
        tiki_BreadcrumbPage.clickFillerButton();
        tiki_BreadcrumbPage.clickSupplierCheckbox();
        tiki_BreadcrumbPage.clickCheckbox();
        tiki_BreadcrumbPage.enterPriceRange("1000000", "2000000");

        tiki_BreadcrumbPage.clickResultButton();
        Assert.assertTrue(tiki_BreadcrumbPage.getNameProductItem().contains("Lò Vi Sóng"));
    }
}
