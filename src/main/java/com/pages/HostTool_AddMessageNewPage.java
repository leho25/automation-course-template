package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HostTool_AddMessageNewPage extends BasePage {
    public HostTool_AddMessageNewPage(WebDriver driver) {
        super(driver);
    }

    By ruleNameField = By.xpath("//input[@data-testid='input-rule-name']");
    By messageField = By.xpath("//textarea[@data-testid='input-message']");
    By saveButton = By.xpath("//div[text()='Save']");

    public void enterRuleName(String ruleName) {
        enterText(ruleNameField, ruleName);
    }
    public void enterMessage(String message){
        enterText(messageField, message);
    }
    public void clickSaveButton(){
        clickElement(saveButton);
    }
}