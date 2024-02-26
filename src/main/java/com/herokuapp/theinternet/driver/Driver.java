package com.herokuapp.theinternet.driver;

import com.herokuapp.theinternet.Base.Base;
import com.herokuapp.theinternet.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Driver extends Base{

    public WebDriver getDriver(){
        return driver;
    }

    public void navigate(String url){
        driver.navigate().to(url);
    }
}
