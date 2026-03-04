package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HostTool_AddMessageNewPage extends BasePage {
    public HostTool_AddMessageNewPage(WebDriver driver) {
        super(driver);
    }

    By ruleNameField = By.xpath("//input[@data-testid='input-rule-name']");
    By messageField = By.xpath("//textarea[@data-testid='input-message']");
    By saveButton = By.xpath("//div[text()='Save']");
    By messageTempatesDropdown = By.xpath("//div[@id='select-message-template']");
    By delayDropdown = By.xpath("//div[@id='select-delay']");

    public void enterRuleName(String ruleName) {
        enterText(ruleNameField, ruleName);
    }

    public void enterEditRuleName(String editRuleName) {
        waitElementVisible(ruleNameField).sendKeys(Keys.CONTROL + "a");
        waitElementVisible(ruleNameField).sendKeys(Keys.DELETE);
        enterText(ruleNameField, editRuleName);
    }

    public void enterMessage(String message) {
        enterText(messageField, message);
    }

    public void clickSaveButton() {
        clickElementJS(saveButton);
    }

    public void clickMessageTemplatesDropdown() {
        clickElement(messageTempatesDropdown);
    }

    public void selectMessageTemplate(String templateName) {
        List<WebElement> options = driver.findElements(By.xpath("//div[@role='option']"));
        for (WebElement el : options) {
            if (el.getText().equals(templateName)) {
                el.click();
                break;
            }
        }

    }

    public Boolean isTemplateRuleNameVisible(String templateRuleName) {
        waitElementVisible(ruleNameField).getText().contains(templateRuleName);
        return true;
    }

    public Boolean getMessageContent(String expectedContent) {
        waitElementVisible(messageField).getText().contains(expectedContent);
        return true;
    }

    public void clickDelayDropdown() {
        clickElement(delayDropdown);
    }

    public Boolean showDelayOptions(String delayOption) {
        By delayOptionsLocator = By.xpath(
                "//div[@role='option' and normalize-space()='"
                        + delayOption + "']");
        return waitElementVisible(delayOptionsLocator).isDisplayed();
    }
}