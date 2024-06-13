package com.herokuapp.theinternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v125.network.Network;
import org.openqa.selenium.devtools.v125.network.model.Headers;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public DevTools devTools(){
        DevTools devTools = ((HasDevTools)driver).getDevTools();
        try {
            devTools.createSession();
            devTools.send(Network.enable(Optional.empty(),
                    Optional.empty(), Optional.empty()));

        }catch (Exception e){
            return null;
        }
        return devTools;
    }

    public String encode(String value){
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    public void authenticate(DevTools devTools, String auth){
        Map<String, Object> headers = new HashMap<>();
        headers.put("Authorization", "Basic" + auth);
        devTools.send(Network.setExtraHTTPHeaders(new Headers(headers)));
    }
}
