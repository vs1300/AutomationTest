package com.herokuapp.theinternet.PageTests;

import com.herokuapp.theinternet.Base.Base;
import com.herokuapp.theinternet.pages.BasicAuthPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthTest extends Base {
    String username=System.getenv("BASIC_AUTH_USERNAME");
    String password=System.getenv("BASIC_AUTH_PASSWORD");

    @Test(description = "Verifying basic auth",groups = "auth")
    public void verifyBasicAuth(){
        BasicAuthPage basicAuthPage = new BasicAuthPage(driver);
        basicAuthPage.login(username, password);

        String actual = basicAuthPage.getResult().trim();
        String expected = "Congratulations! You must have the proper credentials.";

        Assert.assertEquals(actual, expected);
    }
}
