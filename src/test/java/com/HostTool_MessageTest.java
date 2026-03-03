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
    // @Tests
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
        addMessageNewPage.enterRuleName("1");
        addMessageNewPage.enterMessage("lkahslda");
        addMessageNewPage.clickSaveButton();
        Assert.assertTrue(allListingsPage.isRuleNameVisible("1") &&
                allListingsPage.isMessageContentArea("lkahslda")
                && allListingsPage.newMessageRuleCreated());
    }

    // @Test
    public void verifyEditExistingMessage() {
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
        // click on "Editt" button
        allListingsPage.clickEditMessageButton();
        // update message rule and click on "Save" button
        addMessageNewPage.enterEditRuleName("ho1");
        addMessageNewPage.clickSaveButton();
        Assert.assertTrue(allListingsPage.isRuleNameNotExist("ho"), "Old rule name is still exist");
        Assert.assertTrue(allListingsPage.isRuleNameVisible("ho1"), "new rule name is not visible");
        Assert.assertTrue(allListingsPage.newMessageRuleCreated(), "Edit message rule alert is not visile");
    }

    // @Test
    public void verifyPauseMessageRule() {
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
        addMessageNewPage.enterRuleName("ho213");
        addMessageNewPage.enterMessage("lkahslda");
        addMessageNewPage.clickSaveButton();
        // the message rule is created successfully notifiction disappears
        allListingsPage.isMessageNotiNotVisible();
        // click on "Pause" button
        allListingsPage.clickPauseMessgeRuleButton();
        Assert.assertTrue(allListingsPage.isMessageRulePause("The message rule has been paused"),
                "Message rule pause alert is not visible");
        driver.navigate().refresh();
        Assert.assertTrue(allListingsPage.isPausedChangesState(), "Paused state is not visible");
    }

    // @Test
    public void verifyDeleteMessageRule() {
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
        addMessageNewPage.enterRuleName("ho213");
        addMessageNewPage.enterMessage("lkahslda");
        addMessageNewPage.clickSaveButton();
        // the message rule is created successfully notifiction disappears
        allListingsPage.isMessageNotiNotVisible();
        allListingsPage.clickDeleteMessageButton();
        allListingsPage.clickConfirmDeleteButton();

        Assert.assertTrue(allListingsPage.isConfimDeleteModal(), "Confirm delete modal is not visible");
        Assert.assertTrue(allListingsPage.newMessageRuleCreated(), "Delete message rule alert is not visible");
        Assert.assertTrue(allListingsPage.isRuleNameNotExist("ho213"), "Deleted rule name is still visible");
    }
    @Test
    public void verifySwitchBetweenMessageTemplates(){
        String loginUrl = Constains.HOSTTOOLS_URL;
        HostTool_LoginPage loginPage = new HostTool_LoginPage(driver);
        HostTool_MessagePage messagePage = new HostTool_MessagePage(driver);
        HostTool_AllListingsPage allListingsPage = new HostTool_AllListingsPage(driver);
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
        // allListingsPage.selectMessageTemplate("Booking Confirmation Rule");    
        allListingsPage.clickMessageTemplatesDropdown();
        allListingsPage.selectMessageTemplate("Booking Confirmation Message Template");
    }
}   