package com.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SetupBrowser {
    protected static WebDriver driver;

    public void setup() {
        String browser = "chrome";
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--window-size=1366,768");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        // driver.manage().window().maximize();

    }

    public void quit() {
        driver.quit();
    }
}
