package com.pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HostTool_MessagePage extends BasePage {
    public HostTool_MessagePage(WebDriver driver) {
        super(driver);
    }

    By menuButtonMesssages = By.xpath("//span[text()='Messaging']");
    By allListingsLink = By.xpath("//span[text()='All listings']");
    By calenderBoxElement = By.xpath("//div[@data-testid='box-content-wrapper']");
    By listingItemElement = By.xpath("//div[@data-testid='listing-slat']");
    By dotsListingButton = By.xpath("//button[@data-testid='more-menu-listing']");
    By nameListingElement = By.xpath("//span[@data-testid='listing-title']");

    public void clickmenuButtonMessages() {
        clickElement(menuButtonMesssages);
    }

    public void clickAllListingsLink() {
        clickElement(allListingsLink);
    }

    public void waitForHomePageLoad() {
        waitElementVisible(calenderBoxElement);

    }

    public void selectRandomListing() {
        waitElementVisible(listingItemElement);
        List<WebElement> listingItems = driver.findElements(listingItemElement);
        // Generate a radom index to select a random listing
        int randomIndex = new Random().nextInt(listingItems.size());
         System.out.println("randomIndex listing: " + randomIndex);
        // click on the randomly selected listing
        WebElement randomListing = listingItems.get(randomIndex);
         System.out.println("randomListing listing: " + randomListing.getText());
        String listingName = randomListing.findElement(nameListingElement).getText();
        System.out.println("Selected listing: " + listingName);
        randomListing.findElement(dotsListingButton).click();
        System.out.println("Clicked on the dots button for listing: " + randomListing.findElement(dotsListingButton));
    }

    public void cickListingsDropdown(String options) {
        By optionDropdow = By.xpath("//span[text()='" + options + "']");
        clickElement(optionDropdow);
    }

}
