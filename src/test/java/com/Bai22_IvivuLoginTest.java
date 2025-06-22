package com;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.config.Constains;
import com.pages.HomeIvivuPage;
import com.pages.LoginIvivuPage;
import com.utils.BasicTest;
import com.utils.Utils;

public class Bai22_IvivuLoginTest extends BasicTest {
    @Test
    public void IvivuLoginTest() {
        LoginIvivuPage loginIvivu = new LoginIvivuPage(driver);
        HomeIvivuPage homeIvivu = new HomeIvivuPage(driver);
        String url = Constains.HOMEPAGE_IVIVU_URL;
        loginIvivu.open(url);

        homeIvivu.clickUsernameButton();
        homeIvivu.clickLoginButton();

        loginIvivu.enterEmailPhone("lenam1235789@gmail.com");
        loginIvivu.enterPassword("12345678");
        loginIvivu.clickLogin();
        Utils.hardWait(3000);
        Assert.assertTrue(loginIvivu.isErrorMessageDisplayed().contains("Tài khoản không tồn tại !"));
    }
}