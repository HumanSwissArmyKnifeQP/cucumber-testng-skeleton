package com.zucchini.framework.test;

import com.zucchini.framework.ui.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;

public abstract class AbstractZucchiniGlue implements En {
    
    private final Map<Long,WebDriver> drivers = new HashMap<>();
    
    public AbstractZucchiniGlue(){
        
        Before((Scenario scenario)->{
            System.out.println("Scenario start: " + scenario.getName());
            System.out.println(" -> Thread: " + Thread.currentThread().getId());
        });
        
        After((Scenario scenario)->{
            long threadId = Thread.currentThread().getId();
            System.out.println(" -> Scenario end: " + scenario.getName());
            System.out.println(" -> Thread: " + threadId);
            try {
                WebDriver driver = drivers.get(threadId);
                driver.quit();
                drivers.remove(threadId);
            } catch (Exception e) {
            }
        });
    }
    
    public WebDriver getDriver(){
        long threadId = Thread.currentThread().getId();
        WebDriver driver = DriverFactory.getDriver();
        drivers.put(threadId, driver);
        return driver;
    }
}
