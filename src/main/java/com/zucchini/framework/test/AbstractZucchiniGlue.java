package com.zucchini.framework.test;

import com.zucchini.framework.ui.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
import org.openqa.selenium.WebDriver;

public abstract class AbstractZucchiniGlue implements En {
    
    private final WebDriver driver = DriverFactory.getDriver();
    
    public AbstractZucchiniGlue(){
        
        Before((Scenario scenario)->{
            System.out.println("Scenario start: " + scenario.getName());
        });
        
        After((Scenario scenario)->{
            System.out.println(" -> Scenario end: " + scenario.getName());
            driver.quit();
        });
    }
    
    public WebDriver getDriver(){                
        return driver;
    }
}
