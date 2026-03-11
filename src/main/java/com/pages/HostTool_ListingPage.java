package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HostTool_ListingPage extends BasePage {
    public HostTool_ListingPage(WebDriver driver) {
        super(driver);
    }

    By nameBreadcrumb = By.xpath("//span[@aria-label='Breadcrumb']");
    By titleModal = By.xpath("//span[text()='Edit Listing']");
    By messageOnlyCheckbox = By
            .xpath("//div[@data-testid='checkbox-message-only'] ");
    By enableListigCheckbox = By
            .xpath("//div[@data-testid='checkbox-enable-listing' ] ");
    By priceSourceDropdown = By.xpath("//div[@data-testid='price-source']");
    By basePriceInput = By.xpath("//input[@data-testid='input-base-price']");
    By minPriceInput = By.xpath("//input[@data-testid='input-min-price']");
    By minNightInput = By.xpath("//input[@data-testid='input-min-nights']");
    By saveButton = By.xpath("//button[@data-testid='btn-save-listing']");
    By messageAlert = By.xpath("//span[@role='alert']");

    public String openModalSuccessfully() {
        return waitElementVisible(nameBreadcrumb).getText();
    }

    public Boolean titleModalDisplay() {
        return waitElementVisible(titleModal).isDisplayed();
    }

    public Boolean isElementVisible(String nameFileds) {
        By filedElement = By.xpath("//span[text()='" + nameFileds + "']");
        return waitElementVisible(filedElement).getText().contains(nameFileds);
    }

    public void clickEnableListing() {
        setChecked(enableListigCheckbox, true);
    }

    public void clickMessageOnly() {
        setChecked(messageOnlyCheckbox, false);

    }

    public void clickPriceSourceDropdown() {
        clickElement(priceSourceDropdown);
    }

    public void selectPriceSourceDropDownOption(String value) {
        clickPriceSourceDropdown();
        By option = By.xpath("//div[@role='option' and normalize-space()='" + value + "']");
        clickElement(option);
    }

    public void blankBasePriceInput() {
        waitElementVisible(basePriceInput).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
    }

    public void blankMinPriceInput() {
        waitElementVisible(minPriceInput).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
    }

    public void blankMinNightInput() {
        waitElementVisible(minNightInput).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
    }

    public void clickSaveButton() {
        clickElement(saveButton);
    }

    public String isErrorMessageDisplayed(String message) {
        By error = By.xpath("//span[text()='" + message + "']");
        return waitElementVisible(error).getText();
    }

    public Boolean isMessageAlertDisplayed() {
        return waitElementVisible(messageAlert).isDisplayed();
    }

public Boolean isDataSaveSuccess(String message) {
        return waitElementVisible(messageAlert).getText().contains(message);
    }
}
