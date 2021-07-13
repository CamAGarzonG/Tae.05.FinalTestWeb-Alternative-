package com.espn;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EspnTest extends BaseTest {

    Logger LOG = Logger.getLogger(EspnTest.class.getName());

    @Test
    public void logUp() throws InterruptedException{
        LOG.info("--SingUp--");
        LOG.info("Open the browser and the page");
        StartPageEspn home = getStartPageEspn();
        LOG.info("Maximize Window");
        home.getDriver().manage().window().maximize();
        LOG.info("Go to the global user Account");
        LoginForm login = home.clickUserDataEntry();
        LOG.info("Go to the SignUp option");
        SignUpForm registerInterface = login.clickSignUpButton();
        LOG.info("Enter SignUp Data and Send");
        LoggedPageEspn registerData = registerInterface.signUpRegister();
        LOG.info("LogOut From Espn(Accounted)");
        EndCycle logOut=registerData.logOutUser();
        LOG.info("Close browser");
        logOut.dispose();
    }

    @Test
    public void logIn() throws InterruptedException {
        LOG.info("--SingIn--");
        LOG.info("Open the browser and the page");
        StartPageEspn home = getStartPageEspn();
        LOG.info("Maximize Window");
        home.getDriver().manage().window().maximize();
        LOG.info("Go to the global user Account");
        LoginForm login= home.clickUserDataEntry();
        LOG.info("Enter SignIn Data and Send");
        LoggedPageEspn logedUser = login.signInRegister();
        LOG.info("LogOut From Espn(Accounted)");
        EndCycle logoutRequest=logedUser.logOutUser();
        LOG.info("Phrase for logged user Confirmed [WelcomeCamilo!]");
        Assert.assertEquals(logedUser.phraseLogin(),"WelcomeCamilo!");
        Assert.assertSame(logedUser.phraseLogin(),"WelcomeCamilo!","Test Sucsessfull");
        LOG.info("Close browser");
        logoutRequest.dispose();                    //Close the browser just after LogOut
    }

    @Test
    public void logOut() throws InterruptedException {
        LOG.info("--LogOut--");
        LOG.info("Open the browser and the page");
        StartPageEspn home = getStartPageEspn();
        LOG.info("Maximize Window");
        home.getDriver().manage().window().maximize();
        LOG.info("Go to the global user Account");
        LoginForm login= home.clickUserDataEntry();
        LOG.info("Enter SignIn Data and Send");
        LoggedPageEspn logedUser = login.signInRegister();
        LOG.info("LogOut From Espn(Accounted)");
        EndCycle logoutRequest=logedUser.logOutUser();
        LOG.info("Method to confirm LogOut phrase");
        logoutRequest.logOutUser();
        LOG.info("Phrase for logged user Confirmed [Log Out]");
        Assert.assertEquals(logoutRequest.phraseLogout(),"Log Out");
        LOG.info("Close browser");
        logoutRequest.dispose();                    //Close the browser just after LogOut
    }


    @Test
    public void deleteAccount() throws InterruptedException {
        LOG.info("--Delete Account--");
        LOG.info("Open the browser and the page");
        StartPageEspn home = getStartPageEspn();
        LOG.info("Maximize Window");
        home.getDriver().manage().window().maximize();
        LOG.info("Go to the global user Account");
        LoginForm login= home.clickUserDataEntry();
        LOG.info("Enter SignIn Data and Send");
        LoggedPageEspn loged = login.signInRegister();
        LOG.info("Go to Espn Personal Account Profile");
        DeleteForm delete=loged.preDeleteUser();
        LOG.info("Delete the account");
        EndCycle delAccount= delete.deleteAccount();
        LOG.info("Phrase to confirm delete account [Yes, delete this account]");
        Assert.assertEquals(delete.phraseDelete(),"Yes, delete this account");
        LOG.info("Close browser");
        delAccount.dispose();
    }



}
