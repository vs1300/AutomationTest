package com.herokuapp.theinternet.PageTests;

import com.herokuapp.theinternet.Base.Base;
import com.herokuapp.theinternet.driver.Driver;
import com.herokuapp.theinternet.pages.AlertPage;
import com.herokuapp.theinternet.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertPageTest extends Base{


    @Test
    public void verifyJSAlertOnPage(){
        Driver driverActions = new Driver();
        HomePage homePage = new HomePage(driver);
        AlertPage alertPage = new AlertPage(driver);

        homePage.navigateToAlertPage();
        alertPage.clickAlertButton();
        alertPage.acceptAlert();

        Assert.assertEquals(alertPage.getResult(),"You successfully clicked an alert");

    }
}
