package com.espn;

import com.MyDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    MyDriver myDriver;
    private StartPageEspn startPageEspn;

    @BeforeSuite
    public void beforeSuite(){
        myDriver=new MyDriver();
        startPageEspn=new StartPageEspn(myDriver.getDriver());
    }

    public StartPageEspn getStartPageEspn(){
        return startPageEspn;
    }


}
