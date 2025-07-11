package com.steps;

import org.testng.Assert;

import com.config.Constains;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utils.SetupBrowser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BreadcrumHoverSteps extends SetupBrowser {
    @Given("I am on the home page")
    public void page_login() {
        setup();
        String url = Constains.HOMEPAGE_URL;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
    }

    @When("I hover over the breadcrumb {string} displays level 2 menu")
    public void user_hover_over_the_breadcrumb(String menu1) {
        HomePage homePage = new HomePage(driver);
        homePage.hoverMenu(menu1);
    }

    @When("I hover over level 2 menu {string}")
    public void user_hover_over_level_2_menu(String menu2) {
        HomePage homePage = new HomePage(driver);
        homePage.hoverMenu(menu2);
    }

    @When("I click level 3 menu {string}")
    public void user_click_level_3_menu(String menu3) {
        HomePage homePage = new HomePage(driver);
        homePage.clickMenu(menu3);
    }

    @Then("The page title should contain {string}")
    public void the_page_title_should(String titleMenu) {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isDisplayTitle().contains(titleMenu));
    }

}
