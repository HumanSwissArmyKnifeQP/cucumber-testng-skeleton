package com.zucchini.sample.test.stepdefs;

import com.zucchini.framework.test.AbstractZucchiniGlue;
import org.openqa.selenium.WebDriver;

public class BrowserStepdefs extends AbstractZucchiniGlue {

    public BrowserStepdefs() {
        
        super();
        
        Given("^I am on the Google Search page", ()->{
            WebDriver driver = super.getDriver();
            driver.get("https://www.google.ca");
            Thread.sleep(1000);
        });
        
        And("^I search for (.*)$", (String s)->{
            
        });
        
        Then("^we pass", ()->{
            
        });
    }
    
    
    
}
