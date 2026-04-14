package com;

import org.apache.poi.util.Units;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.Constains;
import com.pages.HostTool_ListingPage;
import com.pages.HostTool_LoginPage;
import com.pages.HostTool_MessagePage;
import com.pages.HostTool_PricingPage;
import com.utils.BasicTest;
import com.utils.Utils;

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

    // @Test
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

    // @Test(priority = 1)
    public void verifyEditListing() {
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
        listingPage.clickEnableListing();
        listingPage.clickMessageOnly();
        // click edit nick name and update with "-edited" suffix
        listingPage.enterUpdateNickName("Ho-edited");
        // calculator min price
        int minPrice = listingPage.getMinPrice();
        listingPage.enterUpdateMinPrice(minPrice + 100);
        // calculator base price
        int basePrice = listingPage.getBasePrice();
        listingPage.enterUpdateBasePrice(basePrice + 100);
        // set min night
        listingPage.enterUpdateMinNight(2);
        // add link calender
        listingPage.addUrlCalender(Constains.CALENDER_GOOGLE_URL);
        // click on "refresh" button
        listingPage.clickRefreshIconButton();
        // click on "save" button
        listingPage.clickSaveButton();
        // Verify expected result
        // System.out.println("Nick name: " + listingPage.getValueNickName());
        Assert.assertEquals(listingPage.getValueNickName(), "Ho-edited");
        Assert.assertTrue(listingPage.isBasePrice());
        Assert.assertTrue(listingPage.isMinPrice());
        Assert.assertTrue(listingPage.isMinNight());
        Assert.assertTrue(listingPage.isUrlCalender(Constains.CALENDER_GOOGLE_URL));
        Assert.assertTrue(listingPage.isExportCalenderLink("ical"));
        Utils.hardWait(2000);
        listingPage.clickNavigationHeader("Calendar");
        driver.navigate().refresh();
        Assert.assertTrue(homePage.isNewNickNameCalender("Ho-edited").contains("Ho-edited"),
                "new nick name is not visible in calender page");
    }

    // @Test(priority = 2)
    public void verifyPresistAcrossPricing() {
        // Oen HostTool login page
        String loginUrl = Constains.HOSTTOOLS_LOGIN_URL;
        String homeUrl = Constains.HOSTTOOLS_HOME_URL;
        HostTool_LoginPage loginPage = new HostTool_LoginPage(driver);
        HostTool_MessagePage homePage = new HostTool_MessagePage(driver);
        HostTool_ListingPage listingPage = new HostTool_ListingPage(driver);
        HostTool_PricingPage pricingPage = new HostTool_PricingPage(driver);
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
        listingPage.clickEnableListing();
        listingPage.clickMessageOnly();
        // click edit nick name and update with "-edited" suffix
        listingPage.enterUpdateNickName("Ho-edited");
        // calculator min price
        int minPrice = listingPage.getMinPrice();
        listingPage.enterUpdateMinPrice(minPrice + 100);
        // calculator base price
        int basePrice = listingPage.getBasePrice();
        listingPage.enterUpdateBasePrice(basePrice + 100);
        // set min night
        listingPage.enterUpdateMinNight(2);
        // add link calender
        listingPage.addUrlCalender(Constains.CALENDER_GOOGLE_URL);
        // click on "refresh" button
        listingPage.clickRefreshIconButton();
        // click on "save" button
        listingPage.clickSaveButton();
        listingPage.processClickSuccess("Saving");
        // // click on "Pricing" button in hearder
        listingPage.clickNavigationHeader("Pricing");
        // // select nick name after search
        listingPage.clickListingAfterSearch("Ho-edited");
        // // wait for pricing page load
        pricingPage.waitLoadDataPricingPage();
        // // verify data persist across pricing page
        pricingPage.clickThreeDotsButton();
        pricingPage.clickListingSetting();
        // edit nick name field
        listingPage.enterUpdateNickName("Ho-edited2");
        // click on "save" button
        listingPage.clickSaveButton();
        listingPage.processClickSuccess("Saving");
        // listingPage.listItems();
        Assert.assertTrue(pricingPage.nickNameTitleVisible("Ho-edited").contains("edited"), "nick name is not visible");
        Assert.assertEquals(listingPage.getValueNickName(), "Ho-edited2", "nick name is not updated");
        Assert.assertEquals(listingPage.getBasePrice(), basePrice + 100, "base price is incorrect");
        Assert.assertEquals(listingPage.getMinPrice(), minPrice + 100, "min price is incorrect");
        Assert.assertTrue(listingPage.isExportCalenderLink("ical"));
        Assert.assertTrue(listingPage.urlCalenderExists(Constains.CALENDER_GOOGLE_URL));

    }

    @Test(priority = 3)
    public void verifyRestoreListingSetting() {
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
        String url = listingPage.getCurrentUrl();
        String id = url.split("/listings/")[1].split("\\?")[0];
        System.out.println("Extracted ID from URL: " + id);
        listingPage.clickEnableListing();
        listingPage.clickMessageOnly();
        listingPage.enterUpdateNickName("");
        listingPage.enterUpdateBasePrice(500);
        listingPage.enterUpdateMinPrice(300);
        listingPage.enterUpdateMinNight(10);
        listingPage.clickDeleteUrlCalender();
        listingPage.clickSaveButton();
        listingPage.processClickSuccess("Saving");
        listingPage.clickNavigationHeader("Listings");
        listingPage.waitForListingPageLoad();
        Assert.assertTrue(listingPage.isOpenModalSetting().contains("Listings"), "Listing page is not display");
        listingPage.navigationListingSettingItem(id);
        Assert.assertTrue(listingPage.getValueNickName().isEmpty());
        Assert.assertTrue(listingPage.getBasePrice() == 500);
        Assert.assertTrue(listingPage.getMinPrice() == 300);
        Assert.assertTrue(listingPage.getMinNight() == 10);
        Assert.assertFalse(listingPage.isUrlCalender(Constains.CALENDER_GOOGLE_URL));
        Assert.assertEquals(listingPage.getValueNickName(), "");
        Assert.assertEquals(listingPage.getBasePrice(), 500);
        Assert.assertEquals(listingPage.getMinPrice(), 300);
        Assert.assertEquals(listingPage.getMinNight(), 10);
    }
}