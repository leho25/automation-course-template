package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomeIvivuPage extends BasePage {
    public HomeIvivuPage(WebDriver driver) {
        super(driver);
    }

    By clickUserNameButton = By.xpath("//div[contains(@class,'hlb__acc-option')]");
    By clickLoginButton = By.xpath("//button[contains(@class,'hlb__btn-signin')]");
    By clickDateButton = By.xpath("(//button[@type='button'])[1]");
    By clickSearchInput = By.xpath("//input[contains(@class,'sb__search-input')]");
    By clickSearchButton = By.xpath("//button[contains(@class,'btn-bs__default')]");
    By selectItemHotel = By.xpath("//img[@alt='Khách sạn Colline Đà Lạt']");
    By titleNameHotel = By.xpath("//h1[@class='rmi__hotel-name']");

    public void clickUsernameButton() {
        clickElement(clickUserNameButton);
    }

    public void clickLoginButton() {
        clickElement(clickLoginButton);
    }

    public void clickDateButton() {
        clickElement(clickDateButton);
    }

    public void clickDate(String date) {
        By selectStartDate = By.xpath("//div[contains(text(),'" + date + "')]");
        clickElementJS(selectStartDate);
    }

    public void clickSearchInput() {
        clickElement(clickSearchInput);
    }

    public void clickSearchButton() {
        clickElement(clickSearchButton);
    }

    public void selectItemSearch(String text) {
        By selectItemSearch = By.xpath("//span[contains(text(),'" + text + "')]");
        clickElement(selectItemSearch);
    }

    public void selectItemHotel(String text) {
        By selectItemHotel = By.xpath("//img[@alt='" + text + "']");
        clickElement(selectItemHotel);
    }

    public Boolean getTitleNameHotel() {
        return fidElement(titleNameHotel).isDisplayed();
    }

    public void selectDate(String date, String monthYear) {
        By month = By.xpath("(//div[@class='month-item-header']//div)[1]");
        By nextMonthButton = By.xpath("(//button[@class='button-next-month'])[2]");
        while (true) {
            WebElement currentMonth = fidElement(month);
            if (currentMonth.getText().equals(monthYear)) {
                clickDate(date);
                break;
            } else {
                clickElementJS(nextMonthButton);
            }
        }
    }
}
