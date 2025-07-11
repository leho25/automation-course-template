package com.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.model.Log;
import com.config.Constains;
import com.pages.CartPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductDetailPage;
import com.utils.SetupBrowser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCartSteps extends SetupBrowser {

    @Given("I am on the page login")
    public void page_login() {
        setup();
        String url = Constains.URL;
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open(url);
    }

    @When("I enter valid credential")
    public void user_enter_valid_credentials() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("lenam1235789@gmail.com", "Nam645835");
        // loginPage.clickLoginButton();
    }

    @When("I search for product {string}")
    public void user_search_for_product(String search) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterSearch(search);
    }

    @When("I select the first product from the search results")
    public void user_select_the_first_product() {
        HomePage homePage = new HomePage(driver);
        homePage.clickItem();
    }

    @When("I select proudct option {string}")
    public void user_select_product_option(String option) {
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.selectOptionDropDown(option);
    }

    @When("I add the proudct to the cart")
    public void user_add_the_product_to_the_cart() {
        ProductDetailPage productDetailPage = new ProductDetailPage(driver);
        productDetailPage.clickAddCart();
    }

    @Then("The cart should display a message")
    public void the_cart_should_display_message() {
        CartPage cartPage = new CartPage(driver);
        cartPage.messageAddToCart();
        driver.quit();
    }
}
