package com.espn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoggedPageEspn extends BasePage{

    public LoggedPageEspn(WebDriver driver) {
        super(driver);
    }

    //SELECTORS
    @FindBy(id = "global-user-trigger") private WebElement userTrigger;
    @FindBy(css = "li.display-user") private WebElement phrase_login;
    @FindBy(css = "li a.small") private WebElement logOutButton;
    @FindBy(css = "li a[data-behavior='overlay']") private WebElement profileUserButton;
    @FindBy(id = "disneyid-iframe") private WebElement iframe;


    //METHODS
    public String phraseLogin(){
        String a= phrase_login.getText();
        return a;
    }

    public DeleteForm preDeleteUser(){
        goDefault();
        getWait().until(ExpectedConditions.elementToBeClickable(userTrigger));
        userTrigger.click();
        getWait().until(ExpectedConditions.elementToBeClickable(profileUserButton));
        profileUserButton.click();
        return new DeleteForm(getDriver());
    }

    public EndCycle logOutUser(){
        goDefault();
        getWait().until(ExpectedConditions.elementToBeClickable(userTrigger));
        userTrigger.click();
        getWait().until(ExpectedConditions.elementToBeClickable(logOutButton));
        logOutButton.click();
        getWait().until(ExpectedConditions.elementToBeClickable(userTrigger));
        return new EndCycle(getDriver());
    }

}
