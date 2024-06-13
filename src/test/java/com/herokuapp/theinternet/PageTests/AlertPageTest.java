package com.herokuapp.theinternet.PageTests;

import com.beust.jcommander.Parameter;
import com.herokuapp.theinternet.Base.Base;
import com.herokuapp.theinternet.pages.AlertPage;
import com.herokuapp.theinternet.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertPageTest extends Base{


    @Test(description = "Verifying JS Alert",groups = "alert")
    public void verifyJSAlertOnPage(){
        HomePage homePage = new HomePage(driver);
        AlertPage alertPage = new AlertPage(driver);

        homePage.navigateToAlertPage();
        alertPage.clickAlertButton();
        alertPage.acceptAlert();

        Assert.assertEquals(alertPage.getResult(),"You successfully clicked an alert");

        alertPage.clickConfirmButton();
        alertPage.dismissAlert();

        Assert.assertEquals(alertPage.getResult(),"You clicked: Cancel");

        alertPage.clickPromptButton();
        alertPage.fillAlert("test");
        alertPage.acceptAlert();

        Assert.assertEquals(alertPage.getResult(),"You entered: test");

    }
}
