package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;

public class BasicAuthPage extends BasePage {

    private By result = By.xpath("//div[@class='example']//p");

    public BasicAuthPage(WebDriver driver) {
        super(driver);
    }

    public String getResult(){
        return driver.findElement(result).getText();
    }

    public void login(String username, String password){
        String authentication = username + ":" + password;
        authenticate(devTools(),encode(authentication));
    }
}
