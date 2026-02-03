package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.Constains;
import com.pages.HostTool_AddMessageNewPage;
import com.pages.HostTool_AllListingsPage;
import com.pages.HostTool_LoginPage;
import com.pages.HostTool_MessagePage;
import com.utils.BasicTest;

public class HostTool_MessageTest extends BasicTest {
    @Test
    public void verifyUserAddMessage() {
        // Open HostTool login page
        String loginUrl = Constains.HOSTTOOLS_URL;
        HostTool_LoginPage loginPage = new HostTool_LoginPage(driver);
        HostTool_MessagePage messagePage = new HostTool_MessagePage(driver);
        HostTool_AllListingsPage allListingsPage = new HostTool_AllListingsPage(driver);
        HostTool_AddMessageNewPage addMessageNewPage = new HostTool_AddMessageNewPage(driver);
        loginPage.open(loginUrl);
        // Login with valid credentials
        loginPage.enterEmail("cypress@hosttools.com");
        loginPage.enterPassword("QQ2giQUXuHUf6JZMM*eruF");
        loginPage.clickLoginButton();
        // CLick on "Messaging" menu button
        messagePage.clickmenuButtonMessages();
        // // click on "All listings" link navigation to All listings pages
        messagePage.clickAllListingsLink();
        // click on "Add Rule" button
        allListingsPage.clickAddRuleButton();
        // enter message details and click on "Save" button
        addMessageNewPage.enterRuleName("ho");
        addMessageNewPage.enterMessage("lkahslda");
        addMessageNewPage.clickSaveButton();
        Assert.assertTrue(allListingsPage.isRuleNameTitle("ho") && allListingsPage.isMessageContentArea("lkahslda")
                && allListingsPage.newMessageRuleCreated());
    }
}