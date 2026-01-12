package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Tiki_BreadcrumbPage extends BasePage {
    public Tiki_BreadcrumbPage(WebDriver driver) {
        super(driver);
    }

    By fillerButton = By.xpath("//div[text()='Tất cả']");
    By topDealCheckbox = By.xpath("(//span[text()='Siêu rẻ'])[2]");
    By addSupplierButton = By.xpath("(//a[@class='toggler'])[3]");
    By supplierCheckbox = By.xpath("//span[text()='Tiki Trading']");
    By priceRangeFromInput = By.xpath("//input[@placeholder='Từ']");
    By priceRangeToInput = By.xpath("//input[@placeholder='Đến']");
    By resultButton = By.xpath("//div[text()='Xem kết quả']");
    By nameProductItem = By.xpath("(//h3[text()='Lò Vi Sóng Sharp R-205VN(S) - 20L - Hàng chính hãng'])");

    public void selectBreadcrumb(String menu) {
        By breadcrumbElement = By.xpath("//a[text()='" + menu + "']");
        clickElement(breadcrumbElement);
    }

    public void clickFillerButton() {
        clickElementJS(fillerButton);
    }

    public void clickCheckbox() {
        clickElementJS(topDealCheckbox);
    }

    public void clickSupplierCheckbox() {
        clickElementJS(addSupplierButton);
        clickElementJS(supplierCheckbox);
    }

    public void enterPriceRange(String priceFrom, String priceTo) {
        enterText(priceRangeFromInput, priceFrom);
        enterText(priceRangeToInput, priceTo);
    }

    public void clickResultButton() {
        clickElement(resultButton);
    }

    public String getNameProductItem() {
        String name = waitElementVisible(nameProductItem).getText();
        System.out.println(name);
        return name;
    }
}