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

        WebDriver driver = (url == null) ? 
                new RemoteWebDriver(caps) :
                new RemoteWebDriver(url, caps);
        
        try{
            driver.manage().window().maximize();
        }catch(Exception e){
            // Chrome Driver historically flaky when using maximize function...
        }
        
        return driver;
    }
    
    public static Capabilities getCapabilities(){
        
        String browserName = System.getProperty("browserName");
        browserName = (browserName == null) ? "" : browserName.toUpperCase();
        
        Capabilities caps = null;
        
        switch(browserName){
            case "CHROME":
                caps = new ChromeOptions();
                ((ChromeOptions) caps).addArguments("--start-maximized");
                break;
            default:
                caps = new FirefoxOptions();
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
