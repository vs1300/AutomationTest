package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertPage extends BasePage {

    private By alertButton = By.xpath("//div[@class='example']/ul/li/button[contains(text(),'Alert')]");
    private By confirmButton = By.xpath("//div[@class='example']/ul/li/button[contains(text(),'Confirm')]");
    private By promptButton = By.xpath("//div[@class='example']/ul/li/button[contains(string(),'Prompt')]");
    private By result = By.id("result");

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public void clickAlertButton(){
        driver.findElement(alertButton).click();
    }

    public void clickConfirmButton(){
        driver.findElement(confirmButton).click();
    }

    public void clickPromptButton(){
        driver.findElement(promptButton).click();
    }

    public String getResult(){
        return driver.findElement(result).getText();
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void fillAlert(String message){
        driver.switchTo().alert().sendKeys(message);
    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }
}
