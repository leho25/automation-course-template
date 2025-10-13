package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.Constains;
import com.pages.Quote_Homepage;
import com.pages.Quote_VehicleAdd;
import com.pages.Quote_VehicleAddDriver;
import com.pages.Quote_VehicleAddress;
import com.pages.Quote_VehicleBirthDay;
import com.pages.Quote_VehicleBirthMonth;
import com.pages.Quote_VehicleBirthYear;
import com.pages.Quote_VehicleContact;
import com.pages.Quote_VehicleCurrentyInsured;
import com.pages.Quote_VehicleDriverName;
import com.pages.Quote_VehicleFinally;
import com.pages.Quote_VehicleGender;
import com.pages.Quote_VehicleHomeOwnership;
import com.pages.Quote_VehicleMake;
import com.pages.Quote_VehicleMaritalStatus;
import com.pages.Quote_VehicleMilitaryStatus;
import com.pages.Quote_VehicleModel;
import com.pages.Quote_VehicleOwnership;
import com.pages.Quote_VehicleYear;
import com.utils.BasicTest;
import com.utils.Utils;

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
        Quote_VehicleAdd quote_VehicleAdd = new Quote_VehicleAdd(driver);
        Quote_VehicleCurrentyInsured quote_VehicleCurrentyInsured = new Quote_VehicleCurrentyInsured(driver);
        Quote_VehicleBirthMonth quote_VehicleBirthMonth = new Quote_VehicleBirthMonth(driver);
        Quote_VehicleBirthDay quote_VehicleBirthDay = new Quote_VehicleBirthDay(driver);
        Quote_VehicleBirthYear quote_VehicleBirthYear = new Quote_VehicleBirthYear(driver);
        Quote_VehicleGender quote_VehicleGender = new Quote_VehicleGender(driver);
        Quote_VehicleMaritalStatus quote_VehicleMaritalStatus = new Quote_VehicleMaritalStatus(driver);
        Quote_VehicleMilitaryStatus quote_VehicleMilitaryStatus = new Quote_VehicleMilitaryStatus(driver);
        Quote_VehicleDriverName quote_VehicleDriverName = new Quote_VehicleDriverName(driver);
        Quote_VehicleAddDriver quote_VehicleAddDriver = new Quote_VehicleAddDriver(driver);
        Quote_VehicleHomeOwnership quote_VehicleHomeOwnership = new Quote_VehicleHomeOwnership(driver);
        Quote_VehicleAddress quote_VehicleAddress = new Quote_VehicleAddress(driver);
        Quote_VehicleContact quote_VehicleContact = new Quote_VehicleContact(driver);
        Quote_VehicleFinally quote_VehicleFinally = new Quote_VehicleFinally(driver);
        // open website https://dev.autowisequote.com/
        quote_Homepage.open(Constains.QUOTE_HOMEPAGE_URL);
        // click button Request Free Quote
        quote_Homepage.clickButtonRequestFreeQuote();
        // click button vehicle make
        quote_VehicleMake.clickButtonVehicleMake("BUICK");
        // click button vehicle year
        quote_VehicleYear.clickButtonVehicleYear(2024);
        // click button vehicle model
        quote_VehicleModel.clickButtonVehicleModel("Electra E4");
        // click button vehicle ownership
        quote_VehicleOwnership.clickButtonVehicleOwnership("Financed");
        // click button No, Thanks
        quote_VehicleAdd.clickButtonVehicleNoThanks();
        // click button vehicle currently insured
        quote_VehicleCurrentyInsured.clickButtonVeheicleCurrentyInsured("No");
        // click button vehicle birth month
        quote_VehicleBirthMonth.clickButtonVeheicleBirthMonth("January");
        // click button vehicle birth day
        quote_VehicleBirthDay.clickButtonVehicleBirthDay("1");
        // enter vehicle birth year
        quote_VehicleBirthYear.enterBirthYear("2000");
        // click button gender
        quote_VehicleGender.clickButtonGender("Male");
        // click button marital status
        quote_VehicleMaritalStatus.clickButtonMaritalStatus("No");
        // click button military status
        Utils.hardWait(500);
        quote_VehicleMilitaryStatus.clickButtonMilitaryStatus("No");
        // enter driver name
        quote_VehicleDriverName.clickButtonContinue();
        // click button add driver
        quote_VehicleAddDriver.clickButtonAddDriver("No, Thanks");
        // click button home ownership
        quote_VehicleHomeOwnership.clickButtonOwnership("Rent");
        // enter address
        quote_VehicleAddress.clickButtonContinue();
        // enter contact information
        quote_VehicleContact.clickButtonGetMyQuotes();
        // verify offer is displayed
        Assert.assertTrue(quote_VehicleFinally.getMessageAddSuccess().contains(" We found great offers for you in "));

    }

    @Test
    public void addTowVehicle() {
        Quote_Homepage quote_Homepage = new Quote_Homepage(driver);
        Quote_VehicleMake quote_VehicleMake = new Quote_VehicleMake(driver);
        Quote_VehicleYear quote_VehicleYear = new Quote_VehicleYear(driver);
        Quote_VehicleModel quote_VehicleModel = new Quote_VehicleModel(driver);
        Quote_VehicleOwnership quote_VehicleOwnership = new Quote_VehicleOwnership(driver);
        Quote_VehicleAdd quote_VehicleAdd = new Quote_VehicleAdd(driver);
        Quote_VehicleCurrentyInsured quote_VehicleCurrentyInsured = new Quote_VehicleCurrentyInsured(driver);
        Quote_VehicleBirthMonth quote_VehicleBirthMonth = new Quote_VehicleBirthMonth(driver);
        Quote_VehicleBirthDay quote_VehicleBirthDay = new Quote_VehicleBirthDay(driver);
        Quote_VehicleBirthYear quote_VehicleBirthYear = new Quote_VehicleBirthYear(driver);
        Quote_VehicleGender quote_VehicleGender = new Quote_VehicleGender(driver);
        Quote_VehicleMaritalStatus quote_VehicleMaritalStatus = new Quote_VehicleMaritalStatus(driver);
        Quote_VehicleMilitaryStatus quote_VehicleMilitaryStatus = new Quote_VehicleMilitaryStatus(driver);
        Quote_VehicleDriverName quote_VehicleDriverName = new Quote_VehicleDriverName(driver);
        Quote_VehicleAddDriver quote_VehicleAddDriver = new Quote_VehicleAddDriver(driver);
        Quote_VehicleHomeOwnership quote_VehicleHomeOwnership = new Quote_VehicleHomeOwnership(driver);
        Quote_VehicleAddress quote_VehicleAddress = new Quote_VehicleAddress(driver);
        Quote_VehicleContact quote_VehicleContact = new Quote_VehicleContact(driver);
        Quote_VehicleFinally quote_VehicleFinally = new Quote_VehicleFinally(driver);
        // open website https://dev.autowisequote.com/
        quote_Homepage.open(Constains.QUOTE_HOMEPAGE_URL);
        // click button Request Free Quote
        quote_Homepage.clickButtonRequestFreeQuote();
        // click button vehicle make
        quote_VehicleMake.clickButtonVehicleMake("BUICK");
        // click button vehicle year
        quote_VehicleYear.clickButtonVehicleYear(2024);
        // click button vehicle model
        quote_VehicleModel.clickButtonVehicleModel("Electra E4");
        // click button vehicle ownership
        quote_VehicleOwnership.clickButtonVehicleOwnership("Financed");
        // click button add another vehicle
        quote_VehicleAdd.clickButtonVehicleAddAnother();
        // click button vehicle make
        quote_VehicleMake.clickButtonVehicleMake("CHEVROLET");
        // click button vehicle year
        quote_VehicleYear.clickButtonVehicleYear(2022);
        // click button vehicle model
        quote_VehicleModel.clickButtonVehicleModel("Bolt");
        // click button vehicle ownership
        quote_VehicleOwnership.clickButtonVehicleOwnership("Financed");
        // click button add another vehicle
        quote_VehicleAdd.clickButtonVehicleNoThanks();
        // click button vehicle currently insured
        quote_VehicleCurrentyInsured.clickButtonVeheicleCurrentyInsured("No");
        // click button vehicle birth month
        quote_VehicleBirthMonth.clickButtonVeheicleBirthMonth("January");
        // click button vehicle birth day
        quote_VehicleBirthDay.clickButtonVehicleBirthDay("1");
        // enter vehicle birth year
        quote_VehicleBirthYear.enterBirthYear("2000");
        // click button gender
        quote_VehicleGender.clickButtonGender("Male");
        // click button marital status
        quote_VehicleMaritalStatus.clickButtonMaritalStatus("No");
        // click button military status

        Utils.hardWait(500);
        quote_VehicleMilitaryStatus.clickButtonMilitaryStatus("No");
        // enter driver name
        quote_VehicleDriverName.clickButtonContinue();
        // click button add driver
        quote_VehicleAddDriver.clickButtonAddDriver("No, Thanks");
        // click button home ownership
        quote_VehicleHomeOwnership.clickButtonOwnership("Rent");
        // enter address
        quote_VehicleAddress.clickButtonContinue();
        // enter contact information
        quote_VehicleContact.clickButtonGetMyQuotes();
        // verify offer is displayed
        Assert.assertTrue(quote_VehicleFinally.getMessageAddSuccess().contains(" We found great offers for you in "));

    }
}
