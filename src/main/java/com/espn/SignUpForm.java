package com.espn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;

public class SignUpForm extends BasePage{

    public SignUpForm(WebDriver pDriver) {
        super(pDriver);
    }

    //SELECTORS (Xpath and css)
    //------------------------------------------------------------------------------------------------
    @FindBy(xpath = "//input[@name='firstName']") private WebElement inputUserFirstName;
    //@FindBy(css = "input.ng-pristine.ng-invalid.ng-invalid-required.ng-valid-maxlength.ng-touched") private WebElement inputUserFirstName;

    @FindBy(xpath = "//input[@name='lastName']") private WebElement inputUserLastName;
    //@FindBy(css = "input.ng-pristine.ng-untouched.ng-invalid.ng-invalid-required.ng-valid-maxlength") private WebElement inputUserLastName;

    @FindBy(xpath = "//input[@name='email']") private WebElement inputUserEmail;
    //@FindBy(css = "input.ng-pristine.ng-untouched.ng-invalid.ng-invalid-required.ng-valid-pattern.ng-valid-maxlength") private WebElement inputUserEmail;

    @FindBy(xpath = "//input[@name='newPassword']") private WebElement inputUserPassword;
    //@FindBy(css = "input[name='newPassword']") private WebElement inputUserPassword;

    @FindBy(xpath = "//button[contains(@class, 'btn-primary')]") private WebElement buttonSignUpData;
    //@FindBy(css = "button.btn.btn-primary.ng-scope.ng-isolate-scope']") private WebElement buttonSignUpData;


    //Methods
    //------------------------------------------------------------------------------------------------
    public LoggedPageEspn signUpRegister() throws InterruptedException{
        getWait().until(ExpectedConditions.elementToBeClickable(inputUserFirstName));
        inputUserFirstName.sendKeys(name);
        inputUserLastName.sendKeys(lastName);
        inputUserEmail.sendKeys(email);
        inputUserPassword.sendKeys(password);
        scrollDown();
        buttonSignUpData.click();
        Thread.sleep(4000);
        goDefault();
        return new LoggedPageEspn(getDriver());
    }
}
