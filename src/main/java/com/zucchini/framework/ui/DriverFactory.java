package com.zucchini.framework.ui;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Capabilities;

public class DriverFactory {
    
    // Add you Selenium Node & Hub Urls below
    public static final String NODE_URL = null; 
    public static final String HUB_URL = "http://localhost:1337";
    
    /**
     * Returns the default WebDriver
     * @return 
     */
    public static WebDriver getDriver() {
        URL url = null;
        
        try {
            url = getTestServerURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException("Test server URL is invalid", e);
        }
        
        Capabilities caps = getCapabilities();

        
        return (url == null) ? 
                new RemoteWebDriver(caps) :
                new RemoteWebDriver(url, caps);
    }
    
    public static Capabilities getCapabilities(){
        
        String browserName = System.getProperty("browserName");
        browserName = (browserName == null) ? "" : browserName.toUpperCase();
        
        Capabilities caps = null;
        
        switch(browserName){
            case "FIREFOX":
                caps = new FirefoxOptions();
                break;

            default:
                caps = new ChromeOptions();
                ((ChromeOptions) caps).addArguments("--start-maximized");
                break;
        }
        
        return caps;
    }
    
    public static URL getTestServerURL() throws MalformedURLException{
        
        String testServer = System.getProperty("testServer");
        testServer = (testServer == null) ? "" : testServer.toUpperCase();
        
        URL url = null;
        switch(testServer){
            case "HUB": 
                url = new URL(HUB_URL + "/wd/hub");
                break;
            default:
                url = new URL(HUB_URL + "/wd/hub");
                break;
        }
        
        return url;
    }
}
