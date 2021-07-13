package com.espn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class DeleteForm extends BasePage{

    public DeleteForm(WebDriver pDriver) {
        super(pDriver);
    }

    //SELECTORS
    @FindBy(css = "button#close") private WebElement buttonClose;
    @FindBy(id = "cancel-account") private WebElement linkdDleteAccount;
    @FindBy(xpath = "//h2[contains(@class, 'title-primary')]") private WebElement phraseConfirmDelete;

    @FindBy(xpath = "//input[@type='tel']") private WebElement test;
    @FindBy(xpath = "//button[contains(@class, 'btn-primary')]") private WebElement buttonDeleteAccount;


    //METHODS
    public String phraseDelete(){
        String a= buttonDeleteAccount.getText();
        return a;
    }

    public EndCycle deleteAccount() throws InterruptedException {
        Thread.sleep(1000);
        goFrame();
        getWait().until(ExpectedConditions.elementToBeClickable(test));
        scrollDown();
        linkdDleteAccount.click();
        getWait().until(ExpectedConditions.elementToBeClickable(buttonClose));
        buttonDeleteAccount.click();
        return new EndCycle(getDriver());
    }


}
