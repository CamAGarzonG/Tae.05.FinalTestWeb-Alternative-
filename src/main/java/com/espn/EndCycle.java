package com.espn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EndCycle extends BasePage{

    public EndCycle(WebDriver pDriver) {
        super(pDriver);
    }

    @FindBy(id = "global-user-trigger") private WebElement userTrigger;
    @FindBy(css = "li.display-user") private WebElement phrasePostLogOut;
    @FindBy(css = "li a.small") private WebElement logOutButton;

    public void closeBrowser(){
        dispose();
    }


    public String phraseLogout(){
        String a= logOutButton.getText();
        return a;
    }

    public void logOutUser(){
        goDefault();
        getWait().until(ExpectedConditions.elementToBeClickable(userTrigger));
        userTrigger.click();
    }
}
