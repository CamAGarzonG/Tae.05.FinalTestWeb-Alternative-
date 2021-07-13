package com.espn;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StartPageEspn extends BasePage{


    public StartPageEspn(WebDriver driver) {
        super(driver);
        driver.get("https://www.espnqa.com/?src=com&_adblock=true&espn=cloud");
    }

    //SELECTORS
    @FindBy(id = "global-user-trigger") private WebElement userTrigger;
    @FindBy(css = "li a[data-regformid='espn']") private WebElement loginButton;


    //METHODS
    public LoginForm clickUserDataEntry(){
        getWait().until(ExpectedConditions.elementToBeClickable(userTrigger));
        userTrigger.click();
        getWait().until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return new LoginForm(getDriver());
    }

}
