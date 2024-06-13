package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private By alerts = By.xpath("//div[@id='content']/ul//a[contains(@href,'basic')]");
    private By basicAuth = By.xpath("//div[@id='content']/ul//a[contains(@href,'alerts')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToAlertPage(){
        driver.findElement(alerts).click();
    }

    public void navigateToBasicAuth(){
        driver.findElement(basicAuth).click();
    }
}
