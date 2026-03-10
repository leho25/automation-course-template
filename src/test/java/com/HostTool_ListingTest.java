package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.Constains;
import com.pages.HostTool_ListingPage;
import com.pages.HostTool_LoginPage;
import com.pages.HostTool_MessagePage;
import com.utils.BasicTest;

class HostTool_ListingTest extends BasicTest {
    @Test
    public void verifyOpenListingSettings() {
        // Oen HostTool login page
        String loginUrl = Constains.HOSTTOOLS_LOGIN_URL;
        String homeUrl = Constains.HOSTTOOLS_HOME_URL;
        HostTool_LoginPage loginPage = new HostTool_LoginPage(driver);
        HostTool_MessagePage homePage = new HostTool_MessagePage(driver);
        HostTool_ListingPage listingPage = new HostTool_ListingPage(driver);
        loginPage.open(loginUrl);
        // Login with valid credentials
        loginPage.enterEmail("cypress@hosttools.com");
        loginPage.enterPassword("QQ2giQUXuHUf6JZMM*eruF");
        loginPage.clickLoginButton();
        loginPage.navigateToHomePage(homeUrl);
        // wait for homepage load
        homePage.waitForHomePageLoad();
        String actualListingName = homePage.selectRandomListing();
        homePage.cickListingsDropdown("Listing Settings");
        Assert.assertEquals(actualListingName, listingPage.openModalSuccessfully());
        Assert.assertTrue(listingPage.titleModalDisplay(), "Modal title is not display");
        Assert.assertTrue(listingPage.isElementVisible("Listing Status")
                && listingPage.isElementVisible("Listing Nickname") && listingPage.isElementVisible("Pricing"));
    }

    
}