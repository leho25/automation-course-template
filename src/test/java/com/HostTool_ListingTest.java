package com;

import org.testng.annotations.Test;

import com.config.Constains;
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
        loginPage.open(loginUrl);
        // Login with valid credentials
        loginPage.enterEmail("cypress@hosttools.com");
        loginPage.enterPassword("QQ2giQUXuHUf6JZMM*eruF");
        loginPage.clickLoginButton();
        loginPage.navigateToHomePage(homeUrl);
        // wait for homepage load
        homePage.waitForHomePageLoad();
        homePage.selectRandomListing();
        homePage.cickListingsDropdown("Listing Settings");
    }
}