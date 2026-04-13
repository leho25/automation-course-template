package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
    By nickNameInput = By.xpath("//input[@data-testid='input-nickname']");
    By icalUrlInput = By.xpath("//input[@data-testid='input-ical-url']");
    By addCalenderButton = By.xpath("//div[@data-testid='btn-add-calendar']");
    By refreshIconButton = By.xpath("//button[@data-testid='btn-refresh-icon']");
    By errorAddUrlExists = By.xpath("//span[text()='The iCal link already exists.']");
    By deleteUrlButton = By.xpath("//button[@data-testid='btn-delete-ical-url']");
    By urlCalenderLink = By.xpath("//a[@data-testid='link-url']");
    By nameListingElement = By.xpath("//span[@data-testid='listing-title']");
    By searchListingInput = By.xpath("//input[@data-testid='input-search-listing']");
    By linkListingSetting = By.xpath("//a[@href='/settings/listings']");
    public void navigationListingSettingItem(String id){
        String urlItem = "https://beta.hosttools.com/settings/listings/" + id;
        System.out.println("urlItem: " + urlItem);
        open(urlItem);
    }
    public String openModalSuccessfully() {
        return waitElementVisible(nameBreadcrumb).getText();
    }
    public void processClickSuccess(String text){
        waitTextPrensenInElement(saveButton, text);
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

    public void enterUpdateNickName(String nickName) {

        String value = waitElementVisible(nickNameInput).getAttribute("value");
        System.out.println("value: " + value);
        if (value.isEmpty()) {
            enterText(nickNameInput, nickName);
        } else {
            waitElementVisible(nickNameInput).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
            enterText(nickNameInput, nickName);
        }
        waitElementVisible(nickNameInput).sendKeys(Keys.ENTER);
    }
    public void clickDeleteUrlCalender() {
        clickElementJS(deleteUrlButton);
    }
    public String getValueNickName() {
        return waitElementVisible(nickNameInput).getAttribute("value");
    }

    public int getMinPrice() {
        String value = waitElementVisible(minPriceInput).getAttribute("value");
        return value.isEmpty() ? 0 : Integer.parseInt(value);
    }

    public int getBasePrice() {
        String value = waitElementVisible(basePriceInput).getAttribute("value");
        return value.isEmpty() ? 0 : Integer.parseInt(value);
    }
     public int getMinNight() {
        String value = waitElementVisible(minNightInput).getAttribute("value");
        return value.isEmpty() ? 0 : Integer.parseInt(value);
    }

    public void enterUpdateMinPrice(int price) {
        waitElementVisible(minPriceInput).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        enterText(minPriceInput, String.valueOf(price));
    }

    public void enterUpdateBasePrice(int price) {
        waitElementVisible(basePriceInput).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        enterText(basePriceInput, String.valueOf(price));
    }

    public void enterUpdateMinNight(int time) {
        waitElementVisible(minNightInput).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        enterText(minNightInput, String.valueOf(time));
    }

    public Boolean urlCalenderExists(String url) {
        try {
            enterText(icalUrlInput, url);
            clickElement(addCalenderButton);
            return waitElementVisible(errorAddUrlExists).isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public void addUrlCalender(String url) {
        if (isExportCalenderLink(url)) {
            enterText(icalUrlInput, url);
            clickElement(addCalenderButton);
            try {
                Boolean isErrorUrlExits = waitElementVisible(errorAddUrlExists).isDisplayed();
                if (isErrorUrlExits) {
                    waitElementVisible(icalUrlInput).sendKeys(Keys.CONTROL + "a", Keys.DELETE);
                }
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("e: " + e);
            }

        } else {
            enterText(icalUrlInput, url);
            clickElement(addCalenderButton);
            System.out.println("1111111111111111111");
        }

    }

    public void clickRefreshIconButton() {
        clickElement(refreshIconButton);
    }

    public Boolean isBasePrice() {
        return waitElementVisible(basePriceInput).isDisplayed();
    }

    public Boolean isMinPrice() {
        return waitElementVisible(minPriceInput).isDisplayed();
    }

    public Boolean isMinNight() {
        return waitElementVisible(minNightInput).isDisplayed();
    }

    public Boolean isUrlCalender(String url) {
        By urlCalenderItem = By.xpath("//span[text()='" + url + "']");
        return waitElementVisible(urlCalenderItem).getText().contains(url);
    }

    public Boolean isExportCalenderLink(String url) {
        return waitElementVisible(urlCalenderLink).getText().contains(url);
    }

    public void clickNavigationHeader(String hearder) {
        By calenderHeader = By.xpath("//span[text()='" + hearder + "']");
        clickElement(calenderHeader);
    }
    
    public void enterSearchListing(String search) {
        enterText(searchListingInput, search);
    }

    public void clickListingAfterSearch(String nickName) {
        By nickNameSearchListing = By.xpath("//div[@data-testid='link-listing-item']//span[text()='" + nickName + "']");
        clickElement(nickNameSearchListing);
    }

}
