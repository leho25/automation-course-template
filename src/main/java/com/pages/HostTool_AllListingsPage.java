package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HostTool_AllListingsPage extends BasePage {
    public HostTool_AllListingsPage(WebDriver driver) {
        super(driver);
    }

    By addRuleButton = By.xpath("(//span[text()='Add Rule'])[2]");
    By timelineItem = By.xpath("//div[contains(@data-testid, 'timeline-item')]");

    By messageContentArea = By.xpath("//pre[@class='mt-0 mb-0']");
    By newMessageRuleAlert = By.xpath("//span[@role='alert']");

    public void clickAddRuleButton() {
        clickElement(addRuleButton);
    }

    public Boolean isRuleNameTitle(String ruleName) {
        By ruleNameTitle = By.xpath("(//span[text()='" + ruleName + "'])[1]");
        return waitElementVisible(ruleNameTitle).getText().contains(ruleName);
    }

    public Boolean isMessageContentArea(String messageContent) {
        return waitElementVisible(messageContentArea).getText().contains(messageContent);
    }

    public Boolean newMessageRuleCreated() {
        return waitElementVisible(newMessageRuleAlert).isDisplayed();
    }
}
