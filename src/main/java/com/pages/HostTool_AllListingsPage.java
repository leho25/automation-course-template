package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HostTool_AllListingsPage extends BasePage {
    public HostTool_AllListingsPage(WebDriver driver) {
        super(driver);
    }

    By timelineItem = By.xpath("//div[contains(@data-testid, 'timeline-item')]");
    By addMessageRuleButton = By.xpath("//div[text()='Add Message Rule']");
    By messageContentArea = By.xpath("//pre[@class='mt-0 mb-0']");
    By newMessageRuleAlert = By.xpath("//span[@role='alert']");
    By listMessageRule = By.xpath("//div[contains(@data-testid,'timeline-item')]");
    By editMessageButton = By.xpath("//button[@data-testid='btn-edit-message-rule']");

    public void clickAddRuleButton() {
        clickElement(addMessageRuleButton);
    }

    public Boolean isRuleNameNotExist(String ruleName) {
        By ruleNameNotExist = By.xpath("//div[@data-testid='collapse']//span[text()='" + ruleName + "']");
        waitElementInVisiable(ruleNameNotExist);
        return driver.findElements(ruleNameNotExist).isEmpty();
        // div[@data-testid='collapse']//span[text()='ho1']
    }

    public Boolean isRuleNameVisible(String ruleName) {
        By ruleNameVisible = By.xpath("//div[@data-testid='collapse']//span[text()='" + ruleName + "']");
        return waitElementVisible(ruleNameVisible).isDisplayed();
    }

    public Boolean isMessageContentArea(String messageContent) {
        return waitElementVisible(messageContentArea).getText().contains(messageContent);
    }

    public Boolean newMessageRuleCreated() {
        return waitElementVisible(newMessageRuleAlert).isDisplayed();
    }

    public void clickEditMessageButton() {
        clickElement(editMessageButton);
    }
}
