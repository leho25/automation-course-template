package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.Constains;
import com.pages.Quote_Homepage;
import com.pages.Quote_VehicleMake;
import com.pages.Quote_VehicleModel;
import com.pages.Quote_VehicleOwnership;
import com.pages.Quote_VehicleYear;
import com.utils.BasicTest;

public class Quote extends BasicTest {
    // @Test
    public void openQuotePage() {
        Quote_Homepage quote_Homepage = new Quote_Homepage(driver);
        quote_Homepage.open(Constains.QUOTE_HOMEPAGE_URL);
        Assert.assertTrue(quote_Homepage.isLogoQuoteDisplayed(), "Logo Quote is not displayed");
    }

    @Test
    public void addOneVehicle() {
        Quote_Homepage quote_Homepage = new Quote_Homepage(driver);
        Quote_VehicleMake quote_VehicleMake = new Quote_VehicleMake(driver);
        Quote_VehicleYear quote_VehicleYear = new Quote_VehicleYear(driver);
        Quote_VehicleModel quote_VehicleModel = new Quote_VehicleModel(driver);
        Quote_VehicleOwnership quote_VehicleOwnership = new Quote_VehicleOwnership(driver);
        // open website https://dev.autowisequote.com/
        quote_Homepage.open(Constains.QUOTE_HOMEPAGE_URL);
        // click button Request Free Quote
        quote_Homepage.clickButtonRequestFreeQuote();
        // click button vehicle make
        quote_VehicleMake.clickButtonVehicleMake();
        // click button vehicle year
        quote_VehicleYear.clickButtonVehicleYear(2022);
        // click button vehicle model
        quote_VehicleModel.clickButtonVehicleModel();
        // click button vehicle ownership
        quote_VehicleOwnership.clickButtonVehicleOwnership();
    }
}
