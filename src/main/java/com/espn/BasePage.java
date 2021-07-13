package com.espn;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

        private WebDriver driver;
        private WebDriverWait wait;

        protected String name="Camilo";
        protected String lastName="Garzon";
        protected String email="xicegot663@ovooovo.com";
        protected String password="prueba001";


    public BasePage(WebDriver pDriver) {
        PageFactory.initElements(pDriver, this);
        wait=new WebDriverWait(pDriver, 2);
        driver=pDriver;
    }

    public WebDriverWait getWait() { return wait; }
    public WebDriver getDriver() { return driver; }


    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,900)","");
    }

    public void goFrame(){ driver.switchTo().frame("disneyid-iframe"); }
    public void goDefault(){ driver.switchTo().defaultContent(); }


    public void dispose(){
        if (driver!=null){
            driver.quit();
        }
    }

}


