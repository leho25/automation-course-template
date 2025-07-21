package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tiki_HomePage extends BasePage {
    public Tiki_HomePage(WebDriver driver) {
        super(driver);
    }

    By searchInput = By.xpath("//input[@data-view-id='main_search_form_input']");
    By searchButton = By.xpath("//button[@data-view-id='main_search_form_button']");

    public Tiki_HomePage enterSearchTiki(String text) {
        enterText(searchInput, text);
        return this;
    }

    public Tiki_HomePage clickSearchButtonTiki() {
        clickElement(searchButton);
        return this;
    }

    public void search(String search) {
        enterSearchTiki(search);
        clickSearchButtonTiki();
    }

}
