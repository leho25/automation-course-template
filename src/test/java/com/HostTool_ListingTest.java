package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.Constains;
import com.pages.HostTool_ListingPage;
import com.pages.HostTool_LoginPage;
import com.pages.HostTool_MessagePage;
import com.utils.BasicTest;

class HostTool_ListingTest extends BasicTest {
    // @Test
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

    @Test
    public void veirfyEmptyRequiredFileds() {
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
        // wait for homepage loadss
        homePage.waitForHomePageLoad();
        // select random
        homePage.selectRandomListing();
        // select 'Listing Settings' option from dropdown
        homePage.cickListingsDropdown("Listing Settings");
        // click checkbox from listing status
        listingPage.clickEnableListing();
        listingPage.clickMessageOnly();
        // select Set Amount option from Pricing Dropdown
        listingPage.selectPriceSourceDropDownOption("Set Amount");
        // clear input price, min night and click on "Save" button
        listingPage.blankBasePriceInput();
        listingPage.blankMinPriceInput();
        listingPage.blankMinNightInput();
        listingPage.clickSaveButton();
        // verify clear input
        Assert.assertTrue(listingPage.isErrorMessageDisplayed("Minimum nights must be greater than 0.")
                .contains("Minimum nights"));
        Assert.assertTrue(listingPage.isErrorMessageDisplayed("Base price must be greater than 0.")
                .contains("Base price"));
        // verify alert display and data not save
        // Assert.assertTrue(listingPage.isMessageAlertDisplayed(),"Message alert is not
        // displayed");
        Assert.assertTrue(listingPage.titleModalDisplay(), "Modal is closed");
        Assert.assertFalse(listingPage.isDataSaveSuccess("Listing content updated"), "Data shouble not be saved");
    }
}