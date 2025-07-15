package com.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.config.Constains;
import com.pages.LoginICEHRMPage;
import com.pages.LoginPage;
import com.utils.SetupBrowser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps extends SetupBrowser {

    @Given("I am on the login page")
    public void login_page() {
        setup();
        String url = Constains.URL_ICEHRM;
        LoginICEHRMPage loginICEHRMPage = new LoginICEHRMPage(driver);
        loginICEHRMPage.open(url);
    }

    @When("I enter valid credentials")
    public void user_enter_credentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("lenam1235789@gmail.com", "Nam645835");
    }

    @When("I enter username {string} and password {string}")
    public void user_enter_credentials_2(String username, String password) {
        LoginICEHRMPage loginICEHRMPage = new LoginICEHRMPage(driver);
        loginICEHRMPage.enterUsername(username);
        loginICEHRMPage.enterPassword(password);
        loginICEHRMPage.clickLogin();
    }

    @Then("I should be redirected to the dashboard")
    public void user_is_rediected_to_home_page() {
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertEquals(loginPage.isSuccessMessageDisplayed(), "", "Error message");
    }

    @Then("I should see {string}")
    public void user_should_see(String expectedMessage) {
        LoginICEHRMPage loginICEHRMPage = new LoginICEHRMPage(driver);
        String actualMessage = loginICEHRMPage.getErrorMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "The expected message does not match the actual message.");
        quit();
    }
}