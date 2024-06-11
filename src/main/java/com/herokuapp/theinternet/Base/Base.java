package com.herokuapp.theinternet.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
    protected WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void initializeDriver(){
        //System.setProperty("webdriver.chrome.driver", "/usr/bin/google-chrome");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }

    @AfterTest(alwaysRun = true)
    public void quitDriver(){
        driver.quit();
    }
}
