package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {

    WebDriver driver;

    public MyDriver () {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver=new ChromeDriver();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    /*
    public MyDriver(String browser){
        switch (browser){
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
                //ChromeOptions options = new ChromeOptions();
                //options.addArguments("--start-maximized");
                driver.manage().window().maximize();
                driver=new ChromeDriver();
                break;
            default:
                break;
        }
    }
     */

}
