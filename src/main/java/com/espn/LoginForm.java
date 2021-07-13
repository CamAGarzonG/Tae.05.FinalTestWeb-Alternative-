package com.espn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;

public class LoginForm extends BasePage {

    public LoginForm(WebDriver driver) {
        super(driver);
    }

    //SELECTORS (Xpath and css)
    //------------------------------------------------------------------------------------------------
    @FindBy(xpath = "//input[@type='email']") private WebElement usernameFieldLogin;
    //@FindBy(css = "label span input.ng-pristine.ng-invalid.ng-invalid-required.ng-valid-pattern.ng-touched") private WebElement usernameFieldLogin;

    @FindBy(xpath = "//input[@type='password']") private WebElement passwordFieldLogin;
    //@FindBy(css = "label span input.ng-pristine.ng-untouched.ng-invalid.ng-invalid-required") private WebElement passwordFieldLogin;

    @FindBy(xpath = "//button[contains(@class, 'btn-primary')]") private WebElement buttonLogin;
    //@FindBy(css = "button.btn btn-primary btn-submit ng-isolate-scope") private WebElement buttonLogin;

    @FindBy(xpath = "//a[contains(@class, 'btn-secondary')]") private WebElement buttonSignUp;
    //@FindBy(css = "a.btn btn-secondary ng-isolate-scope") private WebElement buttonSignUp;

    @FindBy(id = "global-user-trigger") private WebElement userTrigger;


    //Methods
    //------------------------------------------------------------------------------------------------
    public LoggedPageEspn signInRegister() throws InterruptedException {
        goFrame();
        getWait().until(ExpectedConditions.elementToBeClickable(buttonLogin));
        usernameFieldLogin.sendKeys(email);
        passwordFieldLogin.sendKeys(password);
        buttonLogin.click();
        //goDefault();
        //getWait().until(ExpectedConditions.elementToBeClickable(userTrigger));
        //getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Thread.sleep(2000);
        goDefault();
        return new LoggedPageEspn(getDriver());
    }

    public SignUpForm clickSignUpButton(){
        goFrame();
        //getDriver().switchTo().frame("disneyid-iframe");
        //getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        getWait().until(ExpectedConditions.elementToBeClickable(buttonSignUp));
        buttonSignUp.click();
        return new SignUpForm(getDriver());
    }
}
