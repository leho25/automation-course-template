package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HostTool_PricingPage extends BasePage {
    public HostTool_PricingPage(WebDriver driver) {
        super(driver);
    }

    By threeDotsButton = By.xpath("//button[@data-testid='more-menu-listing']");
    By listingSettingButton = By.xpath("//div[@data-testid='menu-item-listing-settings']");
    By pricingChart = By.xpath("//canvas[@class='chartjs-render-monitor']");

    public void clickThreeDotsButton() {
        clickElement(threeDotsButton);
    }

    public void clickListingSetting() {
        clickElement(listingSettingButton);
    }

    public void waitLoadDataPricingPage() {
        waitElementVisible(pricingChart);
    }

    public String nickNameTitleVisible(String nickName) {
        By nickNameTitle = By.xpath("//span[text()='" + nickName + "']");
        return waitElementVisible(nickNameTitle).getText();
    }
    public Boolean openListingSetingModal(){
        return waitElementVisible(listingSettingButton).isDisplayed();
    }
}
