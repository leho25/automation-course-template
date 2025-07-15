package com.steps;

import org.testng.Assert;

import com.config.Constains;
import com.pages.HomeIvivuPage;
import com.utils.SetupBrowser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BookingIvivuSteps extends SetupBrowser {

    @Given("I am on the home page ivivu")
    public void i_am_on_the_home_page_ivivu() {
        setup();
        HomeIvivuPage homeIvivuPage = new HomeIvivuPage(driver);
        String url = Constains.HOMEPAGE_IVIVU_URL;
        homeIvivuPage.open(url);
    }

    @When("I select the start date and end date")
    public void user_select_the_start_date_and_end_date() {
        HomeIvivuPage homeIvivuPage = new HomeIvivuPage(driver);
        homeIvivuPage.clickDateButton();
        homeIvivuPage.selectDate("19", "Tháng 92025");
        homeIvivuPage.selectDate("19", "Tháng 102025");
        // homeIvivuPage.clickEndDate();
    }

    @When("I click search and select the first item")
    public void user_click_search_and_select_the_first_item() {
        HomeIvivuPage homeIvivuPage = new HomeIvivuPage(driver);
        homeIvivuPage.clickSearchInput();
        homeIvivuPage.selectItemSearch("Đà Lạt");
    }

    @When("I click search button")
    public void user_click_search_button() {
        HomeIvivuPage homeIvivuPage = new HomeIvivuPage(driver);
        homeIvivuPage.clickSearchButton();
    }

    @When("I select hotel from the search results")
    public void user_select_hotel_from_the_search_results() {
        HomeIvivuPage homeIvivuPage = new HomeIvivuPage(driver);
        homeIvivuPage.selectItemHotel("Khách sạn Colline Đà Lạt");
    }

    @Then("I see the hotel name")
    public void user_see_the_hotel_name() {
        HomeIvivuPage homeIvivuPage = new HomeIvivuPage(driver);
        Assert.assertTrue(homeIvivuPage.getTitleNameHotel());
        quit();
    }
}
